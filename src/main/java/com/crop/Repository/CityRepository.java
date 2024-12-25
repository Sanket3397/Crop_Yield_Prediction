package com.crop.Repository;

import java.util.List;

import com.Model.CityModel;

public interface CityRepository 
{
	public boolean isAddDistCity(String distName,String cityName);
	public List<CityModel> getAllCity();
}
