package com.testology;

import org.testng.annotations.Test;
public class Car_loan_Test
{
    //@Test
    public void WebLoginCarLoan()
    {
        System.out.println("Web Login Home Loan");
    }
    //@Test
    public void MobileLoginCarLoan()
    {
        System.out.println("Mobile Login Home Loan");
    }
    @Test(groups= {"SmokeTest"})
    public void APILoginCarLoan()
    {
        System.out.println("API Login Home Loan");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}