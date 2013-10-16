if (typeof(XCoLab) == 'undefined') 
	throw new "XCoLab isn't defined";
if (typeof(XCoLab.modeling) == 'undefined')
	throw new "XCoLab.modeling isn't defined"; 
if (typeof(XCoLab.modeling.serieRenderers) == 'undefined')
	XCoLab.modeling.serieRenderers = [];

var groupInputRenderer = {

	canRender: function(input) {
		return input.displayItemType == 'GROUP' && input.groupType == 'HORIZONTAL'; 
	},
	renderEdit: function(target, input, modeling, idx) {
		console.log('rendering group vertical input', input);
		var verticalGroupTable = jQuery("<table class='inputDefTable'></table>");
		
		verticalGroupTable.append("<tr><td><div class='actInputDef control_title'><span>" + (idx+1) + ".</span> " + input.name + "</div></td></tr>");
		verticalGroupTable.appendTo(target);
		var verticalGroupContainer = jQuery("<table></table>");
		var groupRow = jQuery("<tr></tr>");
		verticalGroupContainer.append(groupRow);
		target.append(verticalGroupContainer);
		var self = this;
		jQuery.each(input.inputs, function(idx, childInput) {
			var itemCell = jQuery("<td></td>");
			groupRow.append(itemCell);
			modeling.getInputRenderer(childInput).render(itemCell, childInput, modeling, idx, input);
		});
	},
	renderView: function(target, input, modeling, idx) {
		var groupContainer = jQuery("<div class='actInputDef'></div>").appendTo(target);
		groupContainer.append("<div><span class='input_def_header'>" + input.name + "</span></div>");

		jQuery.each(input.inputs, function(idx, childInput) {
			modeling.getInputRenderer(childInput).render(groupContainer, childInput, modeling, idx, input);
			groupContainer.append(" ");
		});
		
	},
	render: function(target, input, modeling, idx, parent) {
		var renderFunc = this.renderView;
		if (XCoLab.modeling.inEditMode) {
			renderFunc = this.renderEdit;
		}
		renderFunc(target, input, modeling, idx, parent);
	}
};

XCoLab.modeling.inputRenderers.push(groupInputRenderer);
