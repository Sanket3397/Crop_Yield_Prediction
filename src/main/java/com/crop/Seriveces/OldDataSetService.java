package com.crop.Seriveces;

import java.util.List;

import com.Model.OldDataSetModel;

public interface OldDataSetService {
	public boolean isOldDataSetAdded(int Fertilizer,float ph,float temp,float rainfall,float yield,int year,String season,int cityId,String cropname);

	public List<OldDataSetModel> olddataset();
}
