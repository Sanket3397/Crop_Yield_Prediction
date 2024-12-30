package com.crop.Repository;

import java.util.ArrayList;
import java.util.List;

import com.Model.CropModel;

public class Filter_Data_Repo_Impl extends DBState implements Filter_Data_Repo
{
	List <CropModel> CropList = new ArrayList<CropModel>();
	List <CropModel> SeaonWiseCrop = new ArrayList<CropModel>();
	@Override
	public List<CropModel> filterbyCropName(String cropname)
	{
		try
		{
			stmt = conn.prepareStatement("select * from crop where cropname = ? ");
			stmt.setString(1, cropname);
			rs =stmt.executeQuery();
			while(rs.next())
			{
				CropList.add( new CropModel(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getString(11)));
			}				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return CropList;
	}

	/*
	 ------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| cropid     | int          | NO   | PRI | NULL    | auto_increment |
| cropname   | varchar(50)  | NO   |     | NULL    |                |
| fertilizer | int          | YES  |     | NULL    |                |
| temp       | varchar(20)  | YES  |     | NULL    |                |
| pH         | decimal(4,2) | YES  |     | NULL    |                |
| rainfall   | int          | YES  |     | NULL    |                |
| stateId    | int          | YES  | MUL | NULL    |                |
| distId     | int          | YES  | MUL | NULL    |                |
| cityId     | int          | YES  | MUL | NULL    |                |
| Area       | int          | YES  |     | NULL    |                |
| season     | varchar(200) | YES  |     | NULL    |                |
+------------+--------
	 */
	@Override
	public List<CropModel> filterCropBySeason(String season) 
	{
		try
		{
			stmt=conn.prepareStatement("select * from crop where season=?");
			stmt.setString(1, season);
			
			rs=stmt.executeQuery();
			while(rs.next())
			{
				SeaonWiseCrop.add(new CropModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getString(11)));
			}
			return SeaonWiseCrop.size() >0 ? CropList: null;
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			return null;
		}
	
	}

}
