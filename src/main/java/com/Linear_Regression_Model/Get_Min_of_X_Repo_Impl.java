package com.Linear_Regression_Model;

import com.crop.Repository.DBState;

public class Get_Min_of_X_Repo_Impl extends DBState implements GetMinOf_X_Repository{

	public float getMinOfTemp(String cropname) {
		
		try
		{
			stmt=conn.prepareStatement("select avg(temp) from olddataset where cropname = ?");
			stmt.setString(1, cropname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getFloat(1);
			}			
			else
			{
				return 0;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return -1;
		}
	}


	public float getMinofRainfall(String cropname) {
	
		try
		{
			stmt=conn.prepareStatement("select avg(rainfall) from olddataset where cropname = ?");
			stmt.setString(1, cropname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getFloat(1);
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	
	public float getMinOfpH(String cropname) {

		try
		{
			stmt=conn.prepareStatement("select avg(pH) from olddataset where cropname = ?");
			stmt.setString(1, cropname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getFloat(1);
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}

	
	public float getMinOfFertilizer(String cropname) {
		try
		{
			stmt=conn.prepareStatement("select avg(Fertilizer) from olddataset where cropname = ?");
			stmt.setString(1, cropname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getFloat(1);
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return 0;
	}

	public float getMinOfYeild(String cropname) {
		try
		{
			stmt=conn.prepareStatement("select avg(yield) from olddataset where cropname =? ");
			stmt.setString(1, cropname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getFloat(1);
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

}