package com.crop.Seriveces;

import com.Model.DistModel;

public interface DistService 
{
	public boolean isAddNewDist(DistModel dmodel);
	
	public boolean isAddStateDist(String stateName,String distName);
}
