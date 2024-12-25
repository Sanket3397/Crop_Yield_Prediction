package com.crop.Seriveces;

import java.util.*;

import com.Model.CityModel;
import com.crop.Repository.CityRepositoryImpl;

public class CityServiceImpl implements CityService{

	CityRepositoryImpl cityRepo=new CityRepositoryImpl();
	
	@Override
	public boolean isCityAdded(String distName,String cityName)
	{
		
		return cityRepo.isAddDistCity(distName, cityName);
	}

	@Override
	public List<CityModel> getAllCity() 
	{
		return cityRepo.getAllCity();
	}
	
}
