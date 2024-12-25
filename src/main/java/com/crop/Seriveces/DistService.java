package com.crop.Seriveces;

import java.util.List;

import com.Model.DistModel;

public interface DistService {
	public boolean isAssociateDistToState(String stateName,String distName);
	public  String getStateName(String stateName);
	public String getDistrictName(String distName);
	public abstract List<DistModel> districtList();
}
