package com.crop.Seriveces;

import java.util.*;

import com.Model.CityModel;
import com.crop.Repository.CityRepositoryImpl;

public class CityServiceImpl implements CityService{

	CityRepositoryImpl cityRepo=new CityRepositoryImpl();
	
	@Override
	public boolean isCityAdded(CityModel citymodel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CityModel> cityList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
