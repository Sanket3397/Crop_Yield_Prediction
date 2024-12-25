package com.crop.Repository;

import java.util.List;
import java.util.Scanner;

import com.Model.DistModel;

public class DistRepositoryImpl extends DBState implements DistRepository
{
	Scanner sc = new Scanner(System.in);
	

	@Override
	public boolean isAssociateDistToState(String stateName, String distName)
	{
		try
		{
			cstmt=conn.prepareCall("{call saveDist(?,?)}");
			cstmt.setString(1, stateName);
			cstmt.setString(2, distName);
			boolean b=cstmt.execute();
			return !b;
		}
		catch(Exception ex)
		{
			System.out.println(""+ex);
			return false;
		}
		
	}
	public String getStateName(String stateName)
	{
		String fetchname=null;
		try
		{
			stmt=conn.prepareStatement("select * from statemaster where stateName=?");
			stmt.setString(1, stateName);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				fetchname=rs.getString(2);
			}
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			
		}
		return fetchname;
		
		
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
	@Override
	public String getDistrictName(String distName)
	{
		String fetchDistName=null;
		
		try
		{
			stmt=conn.prepareStatement("Select * from distmaster where distName=?");
			stmt.setString(1, distName);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				fetchDistName=rs.getString(2);
			}
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
		return fetchDistName;
	}




	


}
