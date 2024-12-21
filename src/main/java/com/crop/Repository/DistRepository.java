package com.crop.Repository;

import com.Model.DistModel;

public interface DistRepository 
{
	public boolean isAddNewDist(DistModel dmodel);
	
	public boolean isAddStateDist(String stateName,String distName);
}
