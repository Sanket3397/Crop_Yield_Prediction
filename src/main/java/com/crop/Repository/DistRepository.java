package com.crop.Repository;

import java.util.List;

import com.Model.DistModel;

public interface DistRepository 
{
	public abstract boolean isDistrictAdd(DistModel distmodel);
	
	public abstract List<DistModel>  districtList ();
}
