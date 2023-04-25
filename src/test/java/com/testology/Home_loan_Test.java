package com.testology;

import org.testng.annotations.Test;
public class Home_loan_Test
{  
@Test  
public void WebLoginHomeLoan()  
{  
  System.out.println("Web Login Home Loan");
  try {
    Thread.sleep(10000);
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
}  
@Test(groups= {"SmokeTest","SanityTest"})
public void MobileLoginHomeLoan()  
{  
  System.out.println("Mobile Login Home Loan");

  try {
    Thread.sleep(15000);
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
}  

@Test(groups = {"SanityTest"})
public void APILoginHomeLoan()  
{  
  System.out.println("API Login Home Loan");
  try {
    Thread.sleep(5000);
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
}  
}  