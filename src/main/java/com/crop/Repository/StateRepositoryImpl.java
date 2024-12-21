package com.crop.Repository;
import java.sql.*;
import java.util.*;

import com.Model.CustModel;
import com.Model.DistModel;
import com.Model.StateModel;
import com.crop.ClientApp.Crop_Yield_Prediction_App;
public  class StateRepositoryImpl extends DBState implements StateRepository
{
	Scanner sc=new Scanner(System.in);
	List<CustModel> list=new ArrayList<>();
	@Override
	public boolean AddDataCust(CustModel cmodel) 
	{
	
		try
		{
			if(conn!=null)
			{
				stmt=conn.prepareStatement("insert into custdata values(?,?,?)");
				stmt.setInt(1,cmodel.getCustid());
				stmt.setString(2,cmodel.getCustname());
				stmt.setString(3, cmodel.getCustemail());
				
				int result=stmt.executeUpdate();
				if(result>0)
				{
					return true;
				}
				else
					return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	//@Override
//	public  List<CustModel> getCustName()
//	{
//		
//	
//		
//	}

	@Override
	public boolean isAddNewState(StateModel model) 
	{
		try
		{
			
			if(conn!=null)
			{
				System.out.println("Database connected sucessfully");
				stmt=conn.prepareStatement("insert into statemaster values('0',?)");
				
				stmt.setString(1,model.getSname());
				
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
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		return false;
	
	}

	@Override
	public List<StateModel> allState() 
	{ 
		List<StateModel> allState = new ArrayList<StateModel>();
	
		try
		{
			stmt =conn.prepareStatement("select * from statemaster ");
			rs = stmt.executeQuery();
	
			while(rs.next())
			{
				int stateId = rs.getInt("stateId");
				String stateName = rs.getString("stateName");
			
				System.out.println("State ID : "+stateId+" State Name :"+stateName);
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return allState;
		}
		return allState;
		
	
		
	}

	@Override
	public List<CustModel> getCustName(String str) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public boolean isAddNewDist(DistModel dmodel) 
//	{
//		try
//		{
//			stmt=conn.prepareStatement("insert into distmaster values('0',?)");
//			stmt.setString(1, dmodel.getDistName());
//			
//			int result=stmt.executeUpdate();
//			if(result>0)
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//			}
//			
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//			return false;
//
//		}
//	}

//	@Override
//	public List<CustModel> getCustName(String str) 
//	{
//		try
//		{
//			stmt=conn.prepareStatement("select * from custdata where custname=?");
//			stmt.setString(1, str);
//			rs=stmt.executeQuery();
//			while(rs.next())
//			{
//				int custId=rs.getInt(1);
//				String custname=rs.getString(2);
//				String email=rs.getString(3);
//				System.out.println("CustId:"+custId+"\tCustName:"+custname+"\tEmail:"+email);
//				CustModel cmodel=new CustModel(rs.getInt(1),rs.getString(2),rs.getString(3));
//				list.add(cmodel);
//			}
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//			
//		}
//		return list;
//	}

//	@Override
//	public boolean isAddStateDist(String stateName, String distName) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	
	
	

}
