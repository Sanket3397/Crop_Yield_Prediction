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



}
