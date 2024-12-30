package com.crop.Repository;
import java.sql.*;
import java.util.*;
import com.Model.DistModel;
import com.Model.StateModel;
import com.crop.ClientApp.Crop_Yield_Prediction_App;
public  class StateRepositoryImpl extends DBState implements StateRepository
{
	Scanner sc = new Scanner(System.in); 
	
	
	DBState state = new DBState();
	StateModel statemodel;
	
	public boolean isAddedNewState(StateModel statemodel) {
		
		try
		{ 			
			if(conn!=null)
			{ 
				
				System.out.println("Enter the StateName :");
				String state=sc.nextLine();
				
				stmt=conn.prepareStatement("insert into statemaster values('0',?)");
				stmt.setString(1, state);
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
			else
			{
				System.out.println("The Connection is Failed !!!!");				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
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
		}
		
		return allState;
	}



	@Override
	public StateModel getStateByName(String stateName) 
	{
		try
		{
			stmt=conn.prepareStatement("select * from statemaster where stateName=?;");
			stmt.setString(1, stateName);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return new StateModel(rs.getInt(1),rs.getString(2));
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
	public boolean isDeleteState(String stateName)
	{
		try
		{
			stmt=conn.prepareStatement("delete from statemaster where stateName=?");
			stmt.setString(1, stateName);
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
			System.out.println("Error in StateDel"+ex);
			return false;
		}
		
	}



	@Override
	public boolean isUpdateState(String currName, String newName)
	{
		try
		{
			StateModel stateId=this.getStateByName(currName);
			stmt=conn.prepareStatement("update statemaster set stateName=? where stateName=?");
			stmt.setString(1, newName);
			//stmt.setInt(1, stateId);
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
		
		return false;
	}

}
