package com.crop.Repository;

import java.util.List;

import com.Model.DistModel;

public interface DistRepository 
{
	public boolean isAssociateDistToState(String stateName,String distName);
	public  String getStateName(String stateName);
	public String getDistrictName(String distName);
	public abstract List<DistModel>  districtList ();
}
