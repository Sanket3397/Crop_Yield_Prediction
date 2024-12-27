package com.crop.Seriveces;

import java.util.List;

import com.Model.OldDataSetModel;
import com.crop.Repository.OldDataSetRepositoryImpl;

public class OldDataSetServiceImpl implements OldDataSetService 
{
	OldDataSetRepositoryImpl olddataRepo=new OldDataSetRepositoryImpl();
	


	@Override
	public boolean isOldDataSetAdded(int cropid, int Fertilizer, float ph, float temp, float rainfall, float yield,
			int year, String season, int cityId,String cropname) {
		// TODO Auto-generated method stub
		return olddataRepo.isOldDataSetAdded(cropid, Fertilizer, ph, temp, rainfall, yield, year, season, cityId,cropname);
	}


	@Override
	public List<OldDataSetModel> olddataset() 
	{
		// TODO Auto-generated method stub
		return olddataRepo.olddataset();
	}




}
