package com.iamsoo.interview.iamsoointerviewa.service;

import com.iamsoo.interview.iamsoointerviewa.model.CreditScoreInputs;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class AbstractCreditScoreCalculatorService {

    static final ConcurrentNavigableMap<Integer,Integer> TIME_IN_BUSINESS_MAP = new ConcurrentSkipListMap<>();
    static final ConcurrentNavigableMap<Integer,Integer> NO_OF_EMPLOYEE_MAP = new ConcurrentSkipListMap<>();
    static final ConcurrentHashMap<String,Integer> COMPANY_TYPE_MAP = new ConcurrentHashMap<>();

    static {

            // This part should be modified to make a single tone or read from database.
            /**
             * 0-3 years	0
             * 4-9 years	28
             * 10-15 years	36
             * 16+ years	59
             */

            AbstractCreditScoreCalculatorService.TIME_IN_BUSINESS_MAP.put(0, 0);
            AbstractCreditScoreCalculatorService.TIME_IN_BUSINESS_MAP.put(4, 28);
            AbstractCreditScoreCalculatorService.TIME_IN_BUSINESS_MAP.put(10, 36);
            AbstractCreditScoreCalculatorService.TIME_IN_BUSINESS_MAP.put(16, 59);

            /**
             * 1 to 5	0
             * 6 to 10	20
             * 11 to 15	32
             * 15 to 20	55
             * 20+	70
             */
            AbstractCreditScoreCalculatorService.NO_OF_EMPLOYEE_MAP.put(1, 0);
            AbstractCreditScoreCalculatorService.NO_OF_EMPLOYEE_MAP.put(6, 20);
            AbstractCreditScoreCalculatorService.NO_OF_EMPLOYEE_MAP.put(11, 32);
            AbstractCreditScoreCalculatorService.NO_OF_EMPLOYEE_MAP.put(15, 55);
            AbstractCreditScoreCalculatorService.NO_OF_EMPLOYEE_MAP.put(20, 70);

            /**
             * Sole proprietorship	12
             * Limited Liability Company	63
             * Partnership	75
             * Others	0
             */

            AbstractCreditScoreCalculatorService.COMPANY_TYPE_MAP.put("Sole proprietorship".replaceAll(" ","").toLowerCase(), 12);
            AbstractCreditScoreCalculatorService.COMPANY_TYPE_MAP.put("Limited Liability Company".replaceAll(" ","").toLowerCase(), 63);
            AbstractCreditScoreCalculatorService.COMPANY_TYPE_MAP.put("Partnership".toLowerCase(), 75);
            AbstractCreditScoreCalculatorService.COMPANY_TYPE_MAP.put("Others".toLowerCase(), 0);

    }



    public int getScoreByCompanyType(String companyType) {
        Optional<Integer> optional = Optional.ofNullable(COMPANY_TYPE_MAP.get(companyType.replaceAll(" ","").toLowerCase()));
        if (optional.isPresent())
            return optional.get();
        else {
            throw new IllegalArgumentException("Invalid Company type in the input.");
        }
    }

    public int getScoreByNoOfEmployee(Integer noOfEmployee) {
        Optional<Integer> optional = Optional.ofNullable(NO_OF_EMPLOYEE_MAP.floorEntry(noOfEmployee).getValue());
        if (optional.isPresent())
            return optional.get();
        else {
            throw new IllegalArgumentException("Invalid No of employee in the input.");
        }
    }

    public int getScoreByTimeInBusiness(Integer timeInBusiness) {
        Optional<Integer> optional = Optional.ofNullable(TIME_IN_BUSINESS_MAP.floorEntry(timeInBusiness).getValue());
        if (optional.isPresent())
            return optional.get();
        else {
            throw new IllegalArgumentException("Invalid Time In Business Input.");
        }
    }

    public abstract int calculateCreditScore(CreditScoreInputs input);

}
