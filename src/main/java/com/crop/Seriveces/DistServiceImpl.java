package com.crop.Seriveces;

import java.util.List;

import com.Model.DistModel;
import com.crop.Repository.*;


public class DistServiceImpl implements DistService
{

	DistRepository distrepo = new DistRepositoryImpl();
	
	@Override
	public boolean isDistrictAdd(DistModel distmodel) 
	{
		
		return  distrepo.isDistrictAdd(distmodel);
	}

	@Override
	public List<DistModel> districtList() {
	
		return distrepo.districtList();
	}
	
}
