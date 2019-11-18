package com.iamsoo.interview.iamsoointerviewa.controller;


import com.iamsoo.interview.iamsoointerviewa.model.CreditScoreInputs;
import com.iamsoo.interview.iamsoointerviewa.service.CreditScoreCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditScoreController {

    @Autowired
    private CreditScoreCalculatorService creditScoreCalculatorService;

    @GetMapping("/")
    public String serviceStatus(){
        return "Iam Running";
    }

    @PostMapping("/calculateCreditScore")
    public int calculateCreditScore(@RequestBody CreditScoreInputs input){
        return creditScoreCalculatorService.calculateCreditScore(input);
    }



}


