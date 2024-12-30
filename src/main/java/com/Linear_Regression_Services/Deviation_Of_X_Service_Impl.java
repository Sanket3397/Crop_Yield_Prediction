package com.Linear_Regression_Services;
import java.util.*;

import com.Linear_Regression_Model.DeviationOfX_Repository;
import com.Linear_Regression_Model.DeviationOf_X_Repository_Impl;
public class Deviation_Of_X_Service_Impl implements Deviation_Of_X_Service {

	DeviationOfX_Repository devRepo= new DeviationOf_X_Repository_Impl();
	
	
	
	@Override
	public List<Float> getDeviationOfTemp(String cropname) {
		
		return devRepo.getDeviationOfTemp(cropname);
	}

	@Override
	public List<Float> getDeviationofRainfall(String cropname) {
		
		return devRepo.getDeviationofRainfall(cropname);
	}

	@Override
	public List<Float> getDeviationofpH(String cropname) {
		
		return devRepo.getDeviationofpH(cropname);
	}

	@Override
	public List<Float> getDeviationofFertilizer(String cropname) {
		
		return devRepo.getDeviationofFertilizer(cropname);
	}
}