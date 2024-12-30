package com.crop.Seriveces;

import java.util.List;

import com.Model.CropModel;

public interface CropService {
	public boolean isCropAdded(String cropname,int fertilizer,String temp,Double pH,int rainfall,int stateId,int distId,int cityId,int Area,String season);

	public List<CropModel> allCropList();
}
