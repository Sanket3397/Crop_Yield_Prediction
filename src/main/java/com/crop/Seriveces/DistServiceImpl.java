package com.crop.Seriveces;

import java.util.List;

import com.Model.DistModel;
import com.crop.Repository.*;


public class DistServiceImpl implements DistService
{

	DistRepository distrepo = new DistRepositoryImpl();
	@Override
	public String getStateName(String stateName)
	{
		
		return distrepo.getStateName(stateName);
	}
	@Override
	public boolean isAssociateDistToState(String stateName, String distName)
	{
		
		return distrepo.isAssociateDistToState(stateName, distName);
	}
	

	@Override
	public List<DistModel> districtList() {
	
		return distrepo.districtList();
	}
	@Override
	public String getDistrictName(String distName)
	{
		
		return distrepo.getDistrictName(distName);
	}
	@Override
	public boolean isDeleteDist(String distName) {
		// TODO Auto-generated method stub
		return distrepo.isDeleteDist(distName);
	}
	@Override
	public boolean isUpdateDist(String currName, String newName) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public DistModel getDistByName(String distName) {
		// TODO Auto-generated method stub
		return distrepo.getDistByName(distName);
	}
	@Override
	public boolean isAddBulkDist(String path) {
		// TODO Auto-generated method stub
		return distrepo.isAddBulkDist(path);
	}



}
