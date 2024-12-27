package com.crop.Repository;

import java.util.List;

import com.Model.OldDataSetModel;

public interface OldDataSetRepository 
{
	public boolean isOldDataSetAdded(int cropid,int Fertilizer,float ph,float temp,float rainfall,float yield,int year,String season,int cityId,String cropname);
	public List <OldDataSetModel> olddataset(); 
}
