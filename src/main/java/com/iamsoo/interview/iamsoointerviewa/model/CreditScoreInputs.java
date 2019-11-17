package com.iamsoo.interview.iamsoointerviewa.model;


public class CreditScoreInputs {
   private String companyType;
   private Integer noOfEmployee;
   private Integer timeInBusiness;

    public CreditScoreInputs(){

    }

    public CreditScoreInputs(String companyType, Integer noOfEmployee, Integer timeInBusiness) {
        this.companyType = companyType;
        this.noOfEmployee = noOfEmployee;
        this.timeInBusiness = timeInBusiness;
    }


    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Integer getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(Integer noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    public Integer getTimeInBusiness() {
        return timeInBusiness;
    }

    public void setTimeInBusiness(Integer timeInBusiness) {
        this.timeInBusiness = timeInBusiness;
    }
}
