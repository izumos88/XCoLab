package com.ext.portlet.model.impl;

import com.ext.portlet.model.PlanPosition;
import com.ext.portlet.service.PlanPositionLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the PlanPosition service. Represents a row in the &quot;xcolab_PlanPosition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PlanPositionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlanPositionImpl
 * @see com.ext.portlet.model.PlanPosition
 * @generated
 */
public abstract class PlanPositionBaseImpl extends PlanPositionModelImpl
    implements PlanPosition {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a plan position model instance should use the {@link PlanPosition} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            PlanPositionLocalServiceUtil.addPlanPosition(this);
        } else {
            PlanPositionLocalServiceUtil.updatePlanPosition(this);
        }
    }
}