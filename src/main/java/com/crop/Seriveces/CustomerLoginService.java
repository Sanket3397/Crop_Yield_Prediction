package com.crop.Seriveces;

import java.util.List;

import com.Model.CustomerLoginModel;

public interface CustomerLoginService {
public boolean isCustomerMatch(String user ,String pass);
	
	public List<CustomerLoginModel> allLoginCustomer(String email);
	
	public boolean isAddedCustomerLogin() ;
}
