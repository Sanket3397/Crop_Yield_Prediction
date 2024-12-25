package com.crop.Repository;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Model.CropModel;

public class CropRepositoryImpl extends DBState implements CropRepository {
	@Override
	public boolean isCropAdded(CropModel cropmodel) {

			Scanner sc = new Scanner(System.in);
			
		try
		{
			stmt=conn.prepareStatement("insert into cropmaster values(?,?,?,?,?,?,?,?,?,?)");
			FileInputStream inputstream=new FileInputStream("E:\\cropdataset.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
			
			
			
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
		return false;
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
				String fertilizer = rs.getString("fertilizer");
				float temp = rs.getFloat("temp");
				float pH = rs.getFloat("pH");
				int rainfall = rs.getInt("rainfall");
				int stateId = rs.getInt("stateId");
				int distId = rs.getInt("distId");
				int cityId = rs.getInt("cityId");
				int Area = rs.getInt("Area");
				
				System.out.println("Crop Id :"+ cropId +" Crop Name : "+cropName+ " Crop Fertilizer : "+fertilizer+ " Region Temperature :"+temp+" Soil pH :"
						+pH+ "  Rainfall :  "+rainfall + " State ID :"+stateId+" DistName :"+distId+" CityId :"+cityId+"Area : "+Area);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
