package com.crop.Seriveces;

import java.util.List;

import com.Model.CityModel;
import com.Model.CropModel;
import com.crop.Repository.*;
public class CropServiceImpl implements CropService
{
	
	CropRepository cropRepo=new CropRepositoryImpl();


	@Override
	public boolean isCropAdded(String cropname, int fertilizer, String temp, Double pH, int rainfall, int stateId,
			int distId, int cityId, int Area,String season) 
	{
	
		return cropRepo.isCropAdded(cropname, fertilizer, temp, pH, rainfall, stateId, distId, cityId, Area,season);
	}
	


	@Override
	public List<CropModel> allCropList() {
		// TODO Auto-generated method stub
		return cropRepo.allCropList();
	}





}
