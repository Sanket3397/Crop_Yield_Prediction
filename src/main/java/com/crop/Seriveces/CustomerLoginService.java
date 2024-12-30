package com.crop.Seriveces;

import java.util.List;

import com.Model.CustomerLoginModel;

public interface CustomerLoginService
{
	public boolean isCustomerMatch(String user ,String pass);
	
	public List<CustomerLoginModel> allLoginCustomer(String email);
	public List<CustomerLoginModel> custDetail();
	public boolean isRegCust(String firstName,String lastName,String customerEmail,String password,String customerPhoneNumber,String customerAddress);
	public boolean isAddedCustomerLogin(int custid,int cropid,String fertilizer,float ph,float temp,float rainfall,float farm_area,String season,int year,int stateId,int distId,int cityid) ;
}
