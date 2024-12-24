package com.crop.Repository;

import java.util.List;
import java.util.Scanner;

import com.Model.DistModel;

public class DistRepositoryImpl extends DBState implements DistRepository
{
Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean isDistrictAdd(DistModel distmodel) {
		
		try
		{
			System.out.println("Enter District Name :");
			String distName = sc.nextLine();			
			stmt=conn.prepareStatement("insert into distmaster values('0',?)");
			stmt.setString(1,distName);
			
			int result = stmt.executeUpdate();
					 
			if(result>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<DistModel> districtList() {
		
		try
		{
			stmt=conn.prepareStatement("select * from distmaster ");
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("distId");
				String districtname = rs.getString("distName");
				
				System.out.println("District Id : "+id+" District Name : " +districtname);
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


}
