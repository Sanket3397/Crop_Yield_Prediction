package com.crop.Repository;

import java.util.List;

import com.Model.CustomerLoginModel;

public interface CustomerLoginRepo {
public List<CustomerLoginModel> allLoginCustomer(String email);
	
	public boolean isAddedCustomerLogin ();
	
}
