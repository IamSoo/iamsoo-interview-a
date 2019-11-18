package com.iamsoo.interview.iamsoointerviewa.service;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreditScoreCalculatorServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void calculateScoreByCompanyTypeTest(){
        CreditScoreCalculatorService service = new CreditScoreCalculatorService();
        int expected = 0;
        int actual = service.getScoreByCompanyType("Others");
        Assert.assertEquals("GetScore By Company is returning right value  :",expected,actual);

        expected = 999;
        actual = service.getScoreByCompanyType("NOTEXISTS");
        Assert.assertEquals("GetScore By Company is returning right value  :",expected,actual);
    }

    @Test
    public void calculateScoreByNoOfEmployee(){
        CreditScoreCalculatorService service = new CreditScoreCalculatorService();
        int expected = 0;
        int actual = service.getScoreByNoOfEmployee(5);
        Assert.assertEquals("GetScore By No of Employee  :",expected,actual);

        expected = 20;
        actual = service.getScoreByNoOfEmployee(9);
        Assert.assertEquals("GetScore By No of Employee :",expected,actual);
    }

    @Test
    public void calculateScoreByTimeInBusiness(){
        CreditScoreCalculatorService service = new CreditScoreCalculatorService();
        int expected = 0;
        int actual = service.getScoreByTimeInBusiness(3);
        Assert.assertEquals("GetScore By Time in Business  :",expected,actual);

        expected = 28;
        actual = service.getScoreByTimeInBusiness(8);
        Assert.assertEquals("GetScore By Time in Business  :",expected,actual);

        expected = 59;
        actual = service.getScoreByTimeInBusiness(100);
        Assert.assertEquals("GetScore By Time in Business :",expected,actual);
    }
}
