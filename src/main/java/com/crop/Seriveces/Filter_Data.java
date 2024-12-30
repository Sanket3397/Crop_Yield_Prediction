package com.crop.Seriveces;

import java.util.List;

import com.Model.CropModel;

public interface Filter_Data
{
	public List<CropModel>  filterbyCropName(String cropname); 
	public List<CropModel> filterCropBySeason(String season);
}
