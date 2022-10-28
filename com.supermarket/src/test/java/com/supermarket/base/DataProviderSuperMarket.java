package com.supermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviderSuperMarket {
	
	@DataProvider (name="searchcategory")
	 public Object[] [] expenseCategory()
	 {
		return new Object [][] {{"Mango"},{"Chocolates"},{"Vegetables"},{"Grocery"}};
			
		
	 }

}
