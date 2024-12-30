package com.crop.Repository;

import java.util.List;
import java.util.*;

import com.Model.OldDataSetModel;

public class OldDataSetRepositoryImpl  extends DBState implements OldDataSetRepository{
	

	@Override
	public boolean isOldDataSetAdded(int Fertilizer, float ph, float temp, float rainfall, float yield,
			int year, String season, int cityId,String cropname) 
	{
		try
		{
			stmt=conn.prepareStatement("insert into olddataset values('0',?,?,?,?,?,?,?,?,?)");
			
			stmt.setInt(1, Fertilizer);
			stmt.setDouble(2, ph);
			stmt.setFloat(3, temp);
			stmt.setFloat(4, rainfall);
			stmt.setFloat(5, yield);
			stmt.setInt(6, year);
			stmt.setString(7, season);
			stmt.setInt(8, cityId);
			stmt.setString(9,cropname);
						
			int result=stmt.executeUpdate();
			if(result>0)
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
	
	
	

	public List<OldDataSetModel> olddataset() {
		
		try
		{
			stmt = conn.prepareStatement("select * from olddataset ");
			rs= stmt.executeQuery();
			
			
			while(rs.next())
			{	
			int datasetid = rs.getInt(1);
			int fertilizer = rs.getInt(2);
			float pH = rs.getFloat(3);
			float temp = rs.getFloat(4);
			int rainfall = rs.getInt(5);
			float yield = rs.getFloat(6);
			int  year = rs.getInt(7);
			String season = rs.getString(8);
			int cityid=rs.getInt(9);
			String cropname = rs.getString(10);
			
			System.out.println("\n===============================================================================================================================================================================================\n");
			System.out.println("Old_Data_Set_Id : "+datasetid+"\ncropname: "+cropname+ "\nFertilizer :"+fertilizer+"\npH :"+pH+"\nTemperature :"+temp+"\nRainfall :"+rainfall+"\nYield :"+yield+"\nSeason :"+season+"\nCityId :"+cityid);
			System.out.println("\n===============================================================================================================================================================================================\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


}
