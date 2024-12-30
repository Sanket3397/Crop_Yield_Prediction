package com.crop.Repository;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Model.CropModel;

public class CropRepositoryImpl extends DBState implements CropRepository {
	//@Override
//	public boolean isCropAdded(CropModel cropmodel) {
//
//			Scanner sc = new Scanner(System.in);
//			
//		try
//		{
//			stmt=conn.prepareStatement("insert into cropmaster values(?,?,?,?,?,?,?,?,?,?)");
//			FileInputStream inputstream=new FileInputStream("E:\\cropdataset.xlsx");
//			XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
//			
//			
//			
//		}
//		catch(Exception ex)
//		{
//			ex.getStackTrace();
//		}
//		return false;
//	}


	@Override
	public boolean isCropAdded(String cropname, int fertilizer, String temp, Double pH, int rainfall, int stateId,
			int distId, int cityId, int Area,String season)
	{
		try
		{
			stmt=conn.prepareStatement("insert into crop values('0',?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, cropname);
			stmt.setInt(2, fertilizer);
			stmt.setString(3, temp);
			stmt.setDouble(4, pH);
			stmt.setInt(5, rainfall);
			stmt.setInt(6, stateId);
			stmt.setInt(7, distId);
			stmt.setInt(8, cityId);
			stmt.setInt(9, Area);
			stmt.setString(10, season);
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
	public List<CropModel> allCropList() {

		try
		{
			stmt = conn.prepareStatement("select * from crop");
			rs= stmt.executeQuery();
			
			while(rs.next())
			{
				int cropId = rs.getInt("cropid");
				String cropName = rs.getString("cropname");
				int fertilizer = rs.getInt("fertilizer");
				float temp = rs.getFloat("temp");
				float pH = rs.getFloat("pH");
				int rainfall = rs.getInt("rainfall");
				int stateId = rs.getInt("stateId");
				int distId = rs.getInt("distId");
				int cityId = rs.getInt("cityId");
				int Area = rs.getInt("Area");
				String season=rs.getString("season");
				System.out.println("Crop Id :"+ cropId +"\nCrop Name : "+cropName+ "\nCrop Fertilizer : "+fertilizer+ "\nRegion Temperature :"+temp+"\nSoil pH :"
						+pH+ "\nRainfall :"+rainfall + "\nState ID :"+stateId+"\nDistName :"+distId+"\nCityId :"+cityId+"\nArea :"+Area+"\n"+"season:"+season);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	
}
