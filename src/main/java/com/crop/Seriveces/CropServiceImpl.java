package com.crop.Seriveces;

import java.util.List;

import com.Model.CityModel;
import com.Model.CropModel;
import com.crop.Repository.*;
public class CropServiceImpl implements CropService
{
	
	CropRepository cropRepo=new CropRepositoryImpl();
	@Override
	public boolean isCropAdded(CropModel cropmodel) 
	{
		// TODO Auto-generated method stub
		return cropRepo.isCropAdded(cropmodel);
	}


	@Override
	public List<CropModel> allCropList() {
		// TODO Auto-generated method stub
		return cropRepo.allCropList();
	}
	

}
