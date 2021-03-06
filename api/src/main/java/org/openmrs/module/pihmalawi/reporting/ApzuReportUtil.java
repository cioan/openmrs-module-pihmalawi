package org.openmrs.module.pihmalawi.reporting;

import org.openmrs.api.context.Context;
import org.openmrs.module.reporting.common.ObjectUtil;
import org.openmrs.module.reporting.report.ReportDesign;
import org.openmrs.module.reporting.report.definition.ReportDefinition;
import org.openmrs.module.reporting.report.manager.ReportManagerUtil;
import org.openmrs.module.reporting.report.renderer.XlsReportRenderer;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility classes that can be used for convenience
 */
public class ApzuReportUtil {

    /**
     * @return the Excel password configured as a global property
     */
    public static String getExcelPassword() {
        String ret = Context.getAdministrationService().getGlobalProperty("pihmalawi.excelPassword");
        return ObjectUtil.nvlStr(ret, "");
    }

    public static Calendar nextDayOfWeek(Date fromDate, int dow) {
        Calendar instance = Calendar.getInstance();
        if ( fromDate != null ) {
            instance.setTime(fromDate);
        }
        if (dow > 0 && dow < 8) {
            int diff = dow - instance.get(Calendar.DAY_OF_WEEK);
            if (!(diff >= 0)) {
                diff += 7;
            }
            instance.add(Calendar.DAY_OF_MONTH, diff);
        }
        return instance;
    }
    /**
     * @return a new ReportDesign for a standard Excel output
     */
    public static ReportDesign createExcelDesign(String reportDesignUuid, ReportDefinition reportDefinition) {
        ReportDesign design = ReportManagerUtil.createExcelDesign(reportDesignUuid, reportDefinition);
        design.addPropertyValue(XlsReportRenderer.PASSWORD_PROPERTY, getExcelPassword());
        return design;
    }
}
