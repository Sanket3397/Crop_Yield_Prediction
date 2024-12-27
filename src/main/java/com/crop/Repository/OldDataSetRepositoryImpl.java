package com.crop.Repository;

import java.util.List;
import java.util.*;

import com.Model.OldDataSetModel;

public class OldDataSetRepositoryImpl  extends DBState implements OldDataSetRepository{
	

	@Override
	public boolean isOldDataSetAdded(int cropid, int Fertilizer, float ph, float temp, float rainfall, float yield,
			int year, String season, int cityId,String cropname) 
	{
		try
		{
			stmt=conn.prepareStatement("insert into olddataset values('0',?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, cropid);
			stmt.setInt(2, Fertilizer);
			stmt.setDouble(3, ph);
			stmt.setFloat(4, temp);
			stmt.setFloat(5, rainfall);
			stmt.setFloat(6, yield);
			stmt.setInt(7, year);
			stmt.setString(8, season);
			stmt.setInt(9, cityId);
			stmt.setString(10,cropname);
						
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
			int cropId = rs.getInt(2);
			String fertilizer = rs.getString(3);
			float pH = rs.getFloat(4);
			float temp = rs.getFloat(5);
			int rainfall = rs.getInt(6);
			int yield = rs.getInt(7);
			int  year = rs.getInt(8);
			String season = rs.getString(9);
			int cityId = rs.getInt(10);
			
			System.out.println("\n====================================================\n");
			System.out.println(" Old_Data_Set_Id : "+datasetid+" cropId : "+cropId+ "Fertilizer :"+fertilizer+"  pH :"+pH+" Temperature :"+temp+" Rainfall :"+rainfall+"  Yield :"+yield+" Season :"+season+" CityId :"+cityId);
			System.out.println("\n====================================================\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


}
