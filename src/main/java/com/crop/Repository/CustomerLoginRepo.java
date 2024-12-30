package com.crop.Repository;

import java.util.List;

import com.Model.CustomerLoginModel;

public interface CustomerLoginRepo 
{
	public List<CustomerLoginModel> allLoginCustomer(String email);
	public boolean isRegCust(String firstName,String lastName,String customerEmail,String password,String customerPhoneNumber,String customerAddress);
	public boolean isAddedCustomerLogin ();	
	public List<CustomerLoginModel> custDetail();
	public boolean isAddedCustomerLogin(int custid,int cropid,String fertilizer,float ph,float temp,float rainfall,float farm_area,String season,int year,int stateId,int distId,int cityid) ;

	
}
