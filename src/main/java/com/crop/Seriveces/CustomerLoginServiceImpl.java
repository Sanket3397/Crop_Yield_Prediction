package com.crop.Seriveces;

import java.util.List;

import com.Model.CustomerLoginModel;
import com.crop.Repository.*;

public class CustomerLoginServiceImpl implements CustomerLoginService
{
    CustomerCredentialRepository customerLoginRepo=new CustomerCredentialRepositoryImpl();
	
	CustomerLoginRepo custologinRepo=  new  CustomerLoginRepoImpl();
	
	public boolean isCustomerMatch(String user, String pass) 
	{
		// TODO Auto-generated method stub
		return customerLoginRepo.isCustomerMatch(user, pass);
	}

	
	public List<CustomerLoginModel> allLoginCustomer(String email) {
	
		return custologinRepo.allLoginCustomer(email);
	}


	@Override
	public boolean isRegCust(String firstName, String lastName, String customerEmail, String password,String customerPhoneNumber, String customerAddress) 
	{
		
		return custologinRepo.isRegCust(firstName, lastName, customerEmail, password, customerPhoneNumber, customerAddress);
	}


	@Override
	public boolean isAddedCustomerLogin(int custid, int cropid, String fertilizer, float ph, float temp, float rainfall,
			float farm_area, String season, int year, int stateId, int distId, int cityid) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<CustomerLoginModel> custDetail() {
		// TODO Auto-generated method stub
		return custologinRepo.custDetail();
	}


}
