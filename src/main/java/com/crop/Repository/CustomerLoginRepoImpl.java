package com.crop.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Model.CustomerLoginModel;
import com.google.protobuf.Timestamp;


public class CustomerLoginRepoImpl extends DBState implements CustomerLoginRepo{
	Scanner sc = new Scanner(System.in);
	@Override
	public List<CustomerLoginModel> allLoginCustomer( String email) {
		
		try
		{
			stmt=conn.prepareStatement("select * from customerlogin where customerEmail = ? ");
			stmt.setString(1, email);
			rs =stmt.executeQuery();
			
			 
			while(rs.next())
			{
				String firstName = rs.getString("firstName");
				String lastName  = rs.getString("lastName");
				String phoneNumber = rs.getString("customerPhoneNumber");
				String customerAddress = rs.getString("customerAddress");
				
				System.out.println("\n=================================================================================================================\n");
				System.out.println("Customer Name :"+firstName+" "+lastName+" PhoneNumber : "+phoneNumber+"  CustomerAddress : "+customerAddress);
				System.out.println("\n=================================================================================================================\n");
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return null;
		
	}


	@Override
	public boolean isAddedCustomerLogin(int custid, int cropid, String fertilizer, float ph, float temp, float rainfall,
			float farm_area, String season, int year, int stateId, int distId, int cityid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRegCust(String firstName, String lastName, String customerEmail, String password,
			String customerPhoneNumber, String customerAddress) 
	{
		try
		{
			
			stmt=conn.prepareStatement("insert into  customerlogin(firstName,lastName,customerEmail,password,customerPhoneNumber,customerAddress)values(?,?,?,?,?,?)");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, customerEmail);
			stmt.setString(4, password);
			stmt.setString(5, customerPhoneNumber);
			stmt.setString(6, customerAddress);
		
			//stmt.setString(7, registrationDate);
			
			int result=stmt.executeUpdate();
			if(result>0)
			{
				System.out.println("Customer added in database");
				return true;
				
			}
			
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			
		}
		return false;
	}


	@Override
	public boolean isAddedCustomerLogin()
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<CustomerLoginModel> custDetail() {
	    List<CustomerLoginModel> customers = new ArrayList<>();
	    try {
	        stmt = conn.prepareStatement("select * from customerlogin");
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            // Retrieve data from the result set
	            int custId = rs.getInt("customerId");
	            String firstName = rs.getString("firstName");
	            String lastName = rs.getString("lastName");
	            String email = rs.getString("customerEmail");
	            String password = rs.getString("password");
	            String phoneNumber = rs.getString("customerPhoneNumber");
	            String address = rs.getString("customerAddress");
	            java.sql.Timestamp registrationDate = rs.getTimestamp("registrationDate");

	            // Add customer details to the list
	            customers.add(new CustomerLoginModel(custId, firstName, lastName, email, password, phoneNumber, address, registrationDate));
	        }
	    } catch (Exception ex) {
	        // Log the exception properly
	        ex.printStackTrace(); // or use logging library
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return customers;
	}


}
