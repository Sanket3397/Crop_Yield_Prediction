package com.crop.Seriveces;

import java.util.*;

import com.Model.CityModel;

public interface CityService {

	public boolean isCityAdded(CityModel citymodel);
	public List<CityModel> cityList();
}
