package com.crop.Seriveces;
import com.crop.Repository.*;
public class AdminCredentialServiceImpl implements AdminCredentialService{

	AdminCredentialRepository adminrepo=new AdminCredentialMatchRepositoryImpl();
		public boolean isAdminMatch(String user, String pass) {
			
			return adminrepo.isAdminMatch(user, pass);
		}

	
}
