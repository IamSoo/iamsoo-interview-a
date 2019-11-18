package com.iamsoo.interview.iamsoointerviewa.service;

import cucumber.api.CucumberOptions;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class CalculateCreditScoreStepDefTest implements En {

    CreditScoreCalculatorService service;
    int result = 0;

    public CalculateCreditScoreStepDefTest() {
        service = new CreditScoreCalculatorService();

        When("^The calculateCreditAssessmentScore API is called with parameters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$", (String numberOfEmployees, String companyType, String numberOfYearsOperated) -> {
            result = service.getScoreByNoOfEmployee(Integer.parseInt(numberOfEmployees) ) + service.getScoreByCompanyType(companyType) + service.getScoreByTimeInBusiness(Integer.parseInt(numberOfYearsOperated));
        });

        Then("^The credit assessment score should match \"([^\"]*)\"$", (Integer arg0) -> {
            org.junit.jupiter.api.Assertions.assertEquals(result,arg0);
        });

    }
}
