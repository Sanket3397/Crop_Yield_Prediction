package com.crop.Repository;

public interface CustomerCredentialRepository {
	public boolean isCustomerMatch(String custEmail,String pass);
}
