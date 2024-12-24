package com.crop.Seriveces;

import java.util.List;

import com.Model.CustomerLoginModel;
import com.crop.Repository.*;

public class CustomerLoginServiceImpl implements CustomerLoginService
{
    CustomerCredentialRepository customerLoginRepo=new CustomerCredentialRepositoryImpl();
	
	CustomerLoginRepo custologinRepo=  new  CustomerLoginRepoImpl();
	
	public boolean isCustomerMatch(String user, String pass) {
		// TODO Auto-generated method stub
		return customerLoginRepo.isCustomerMatch(user, pass);
	}

	
	public List<CustomerLoginModel> allLoginCustomer(String email) {
	
		return custologinRepo.allLoginCustomer(email);
	}


	@Override
	public boolean isAddedCustomerLogin() {
		// TODO Auto-generated method stub
		return custologinRepo.isAddedCustomerLogin();
	}
}
