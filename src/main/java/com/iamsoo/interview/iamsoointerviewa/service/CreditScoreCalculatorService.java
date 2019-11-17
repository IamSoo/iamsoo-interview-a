package com.iamsoo.interview.iamsoointerviewa.service;

import com.iamsoo.interview.iamsoointerviewa.model.CreditScoreInputs;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreCalculatorService extends AbstractCreditScoreCalculatorService {


    public int calculateCreditScore(CreditScoreInputs input) {
        try {
            int scoreCompanyType = getScoreByCompanyType(input.getCompanyType());
            int scoreNoOfEmployee = getScoreByNoOfEmpoyee(input.getNoOfEmployee());
            int scoreTimeInBusiness = getScoreByTimeInBusiness(input.getTimeInBusiness());

            return scoreCompanyType + scoreNoOfEmployee + scoreTimeInBusiness;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }


}
