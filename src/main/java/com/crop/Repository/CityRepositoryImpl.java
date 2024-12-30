package com.crop.Repository;

import java.util.List;

import com.Model.CityModel;

public class CityRepositoryImpl extends DBState implements CityRepository
{

	@Override
	public boolean isAddDistCity(String distName, String cityName)
	{
		try
		{
			cstmt=conn.prepareCall("{call saveCity(?,?)}");
			cstmt.setString(1, distName);
			cstmt.setString(2, cityName);
			
			boolean b=cstmt.execute();
			
			if(!b)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			return false;
		}
		
	
	}

	@Override
	public List<CityModel> getAllCity() 
	{
		try
		{
			stmt=conn.prepareStatement("select * from citymaster");
			
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				int cityid=rs.getInt(1);
				String cityname=rs.getString(2);
				System.out.println("CityID:\t"+cityid+"\tcityname:"+cityname);
			}
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
		return null;
	}

}
