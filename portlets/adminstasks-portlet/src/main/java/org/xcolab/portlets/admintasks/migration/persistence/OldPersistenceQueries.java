package org.xcolab.portlets.admintasks.migration.persistence;

import com.ext.portlet.model.*;
import com.ext.portlet.service.*;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.*;
import org.xcolab.portlets.admintasks.migration.Pair;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: patrickhiesel
 * Date: 10/1/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class OldPersistenceQueries {
    private static final String ENTITY_CLASS_LOADER_CONTEXT = "plansProposalsFacade-portlet";
    private static ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(
            ENTITY_CLASS_LOADER_CONTEXT, "portletClassLoader");

    public static List<PlanAttribute> getRibbonsForPlan(PlanItem plan){
        // Get Ribbons For a plan
        DynamicQuery planRibbonQuery = DynamicQueryFactoryUtil.forClass(PlanAttribute.class, portletClassLoader);
        planRibbonQuery.add(PropertyFactoryUtil.forName("attributeName").like("PLAN_RIBBON%"));
        planRibbonQuery.add(PropertyFactoryUtil.forName("planId").eq(plan.getPlanId()));

        List<PlanAttribute> ribbons = null;
        try{
            ribbons = PlanAttributeLocalServiceUtil.dynamicQuery(planRibbonQuery);
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return ribbons;
    }

    public static Pair<Long,String> getRibbonAndHoverTextForPlan(PlanItem plan){
        List<PlanAttribute> ribbons = OldPersistenceQueries.getRibbonsForPlan(plan);
        if (ribbons == null) return null;

        long planRibbon = -1;
        String planRibbonText = "";

        for (PlanAttribute pa : ribbons){
            if (pa.getAttributeName().equalsIgnoreCase("PLAN_RIBBON")){
                try{
                    planRibbon = Long.parseLong(pa.getAttributeValue());
                } catch (NumberFormatException e){
                    planRibbon = -1;
                }
            } else if (pa.getAttributeName().equalsIgnoreCase("PLAN_RIBBON_TEXT")){
                planRibbonText = pa.getAttributeValue();
            }
        }

        if (planRibbon == -1) return null;
        return new Pair<Long, String>(planRibbon,planRibbonText);
    }

    public static List<PlanSection> getPlanSectionsForPlan(PlanItem plan){
        DynamicQuery sectionQuery = DynamicQueryFactoryUtil.forClass(PlanSection.class, portletClassLoader);
        sectionQuery.add(PropertyFactoryUtil.forName("planVersion").eq(plan.getVersion()));
        sectionQuery.add(PropertyFactoryUtil.forName("planId").eq(plan.getPlanId()));
        sectionQuery.addOrder(OrderFactoryUtil.asc("version"));

        List<PlanSection> planSections = null;
        try{
            planSections = PlanSectionLocalServiceUtil.dynamicQuery(sectionQuery);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return planSections;
    }

    public static List<PlanItem> getAllVersionsForPlanASC(long planId){
        DynamicQuery planQuery = DynamicQueryFactoryUtil.forClass(PlanItem.class, portletClassLoader);
        planQuery.add(PropertyFactoryUtil.forName("planId").eq(planId));
        planQuery.addOrder(OrderFactoryUtil.asc("version"));

        List<PlanItem> planItems = null;
        try{
            planItems = PlanItemLocalServiceUtil.dynamicQuery(planQuery);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return planItems;
    }

    public static List<Long> getPlanItemsWithoutGroups(){
        DynamicQuery plansInGroups = DynamicQueryFactoryUtil.forClass(PlanItemGroup.class, portletClassLoader);
        plansInGroups.setProjection(ProjectionFactoryUtil.property("planId"));
        DynamicQuery planItems = DynamicQueryFactoryUtil.forClass(PlanItem.class, portletClassLoader);
        planItems.add(PropertyFactoryUtil.forName("planId").notIn(plansInGroups));
        planItems.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("planId")));

        try{
            return PlanItemLocalServiceUtil.dynamicQuery(planItems);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
