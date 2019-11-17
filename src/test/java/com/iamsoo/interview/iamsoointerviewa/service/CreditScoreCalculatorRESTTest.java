package com.iamsoo.interview.iamsoointerviewa.service;


import com.iamsoo.interview.iamsoointerviewa.model.CreditScoreInputs;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditScoreCalculatorRESTTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int serverRunningPort;

    @Test
    public void testCreditScoreContollerServiceStatus() throws URISyntaxException{
        final String baseUrl = "http://localhost:"+serverRunningPort+"/";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json");

        String response = this.restTemplate.getForObject(uri,String.class);

        Assert.assertEquals("Iam Running", response);

    }


    @Test
    public void testCreditScoreContollerCalculateCreditScore() throws URISyntaxException{
        final String baseUrl = "http://localhost:"+serverRunningPort+"/calculateCreditScore";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json");

        CreditScoreInputs input = new CreditScoreInputs();
        input.setCompanyType("Partnership");
        input.setNoOfEmployee(15);
        input.setTimeInBusiness(5);

        HttpEntity<CreditScoreInputs> request = new HttpEntity<>(input, headers);

        ResponseEntity<Integer> responseEntity = this.restTemplate.postForEntity(uri,request,Integer.class);

        Assert.assertEquals(158, responseEntity.getBody().intValue());

    }
}
