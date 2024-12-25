package com.crop.Seriveces;

import java.util.*;

import com.Model.CityModel;

public interface CityService {

	public boolean isCityAdded(String distName,String ctyName);
	public List<CityModel> getAllCity();
}
