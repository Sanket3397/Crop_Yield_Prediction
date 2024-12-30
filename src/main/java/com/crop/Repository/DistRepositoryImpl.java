package com.crop.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.*;

import com.Model.DistModel;
import com.Model.StateModel;

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
	@Override
	public boolean isDeleteDist(String distName) 
	{
		try {
		stmt=conn.prepareStatement("delete from distmaster where distName=?");
		stmt.setString(1, distName);
		int b=stmt.executeUpdate();
		if(b>0)
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
			System.out.println("Error in Distdel"+ex);
			return false;
		}
	}
	@Override
	public boolean isUpdateDist(String currName, String newName) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public DistModel getDistByName(String distName)
	{
		try
		{
		stmt=conn.prepareStatement("select * from distmaster where distName=?;");
		stmt.setString(1, distName);
		rs=stmt.executeQuery();
		if(rs.next())
		{
			return new DistModel(rs.getInt(1),rs.getString(2));
		}
		else
		{
			return null;
		}
	}
	catch(Exception ex)
	{
		System.out.println("Error is search repo"+ex);
		return null;
	}
	}
	@Override
	public boolean isAddBulkDist(String path) 
	{
		
		 FileInputStream fileInputStream = null;
	        Workbook workbook = null;
	         stmt = null;
	         try {
	             // Open the Excel file
	             fileInputStream = new FileInputStream(path);

	             // Create Workbook instance
	             workbook = WorkbookFactory.create(fileInputStream);

	             // Get the first sheet
	             Sheet sheet = workbook.getSheetAt(0);
	             stmt=conn.prepareStatement("INSERT INTO distmaster (distName) VALUES (?)");
	             
	             // Iterate over rows (optional example)
	             for (Row row : sheet)
	             {
	            	 if (row.getRowNum() == 0) continue;
	            	 String distName = row.getCell(0).getStringCellValue().trim();
	            	 stmt.setString(1, distName);
	            	 
	            	 stmt.addBatch();
	            	 
	               return true;
	             }
	             int[] result = stmt.executeBatch();
	             
		          System.out.println("Data inserted successfully! Rows affected: " + result.length);
	        
	         } 
	         catch (Exception e) 
	         {
		            e.printStackTrace();
		       } 
	         finally 
	         {
		            // Close resources
		            try 
		            {
		            	if (stmt != null) stmt.close(); 
		            } 
		            catch (Exception e)
		            {
		            	e.printStackTrace(); 
		            }
		            try 
		            {
		            	if (workbook != null) workbook.close();
		            } 
		            catch (Exception e) 
		            { 
		            	e.printStackTrace(); 
		            }
		            try 
		            { 
		            	if (fileInputStream != null) fileInputStream.close(); 
		            }
		            catch (Exception e)
		            { 
		            	e.printStackTrace();
		            }
		      }
			return false;
	}




	


}
