package com.summer;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/04/02/16:58
 * @Description
 */
public class Demo {
    public static void main(String[] args) {
        String xml = "ID,ABSTRACT,ACCDOCCODE," +
                "ACCDOCDATE,ACCDOCDATEUTC,ACCDOCTYPEID," +
                "ACCMANAGERID,ACCMANAGERNAME,ACCORGID," +
                "ACCPERIODCODE,ACCPERIODID,AMOUNT," +
                "APPROVERID,APPROVERNAME,AUDITOR," +
                "AUDITORNAME,BIZBILLTYPEID,BIZINTERFACETYPE," +
                "BOOKERID,BOOKERNAME,BUDGETABSTRACT," +
                "BUDGETACCDOCCODE,BUDGETAMOUNT,CANCELLATIONACCDOCISN," +
                "CASHFLOWREADIN,CASHIERID,CASHIERNAME," +
                "CERBASE64STRING,CTRLBUDGETID,DWVERSION," +
                "ERMITEMID,EXTERNALCOL,EXTERNALDOC," +
                "FIACCDOCCODE,GEELECDOC,IMAGEBARCODE," +
                "IMAGEELECACCDOC,IMAGEFLAG,ISAPPROVED," +
                "ISAUDIT,ISBOOK,ISCASHFLOWREAD," +
                "ISCOMPLETE,ISSIGNED,ISVOID," +
                "LEADINPERIOD,LEADINYEAR,LEDGER," +
                "MAKERCODE,MAKERID,MAKERNAME," +
                "MODULEID,NUMBEROFATTCH,NUMBEROFNOTE," +
                "OPERATORID,OPERATORNAME,PRINTFLAG," +
                "PZKID,READONLYFLAG,REALTIMETALLY," +
                "REASONFORNAUDIT,REASONFORREFUSAL,SECRETLEVELID," +
                "SECRETLEVELNUM,SIGNMESSAGE,SOURCECLASS," +
                "TIMESTAMP_CREATEDBY,TIMESTAMP_CREATEDON,TIMESTAMP_LASTCHANGEDBY," +
                "TIMESTAMP_LASTCHANGEDON,YEAR,EXSTATE01," +
                "SM01,SM02,SM03," +
                "SM04,SM05";
        String s = "AccountingDocument";
        String[] split = xml.trim().split(",");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            sb.append(s).append(".").append(s1).append(" as ").append(s).append(s1).append(",");
        }
        System.out.println(sb);
    }
}
