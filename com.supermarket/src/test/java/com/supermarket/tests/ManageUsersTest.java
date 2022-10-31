package com.supermarket.tests;



import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarkets.pages.LogInPage;
import com.supermarkets.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	 LogInPage loginPage;
   ManageUsersPage manageuserspage;
   
   
   @Test
   public void verify_ManageUserDeactivation()
   {
	   loginPage=new LogInPage(driver);
		 loginPage.logIn();
		 
		 manageuserspage=new  ManageUsersPage(driver);
		 manageuserspage.click_ManageUsersLink();
		 manageuserspage.deactivate_User("lex rex");
		 manageuserspage.unLock_Enabled();
		 
   }
}
