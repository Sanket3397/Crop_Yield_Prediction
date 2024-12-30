package com.crop.Repository;

import java.util.List;

import com.Model.CropModel;

public interface Filter_Data_Repo
{
	public List<CropModel>  filterbyCropName(String CropName); 
	public List<CropModel> filterCropBySeason(String season);
}
