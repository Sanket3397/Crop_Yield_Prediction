package com.Linear_Regression_Services;
import com.Linear_Regression_Model.GetMinOf_X_Repository;
import com.Linear_Regression_Model.Get_Min_of_X_Repo_Impl;

public class Get_MinService_Impl implements GetMinOfXService {

	GetMinOf_X_Repository getminOfXRepo=  new Get_Min_of_X_Repo_Impl();
	
	public float getMinOfTemp(String cropname)
	{
		return getminOfXRepo.getMinOfTemp(cropname);
	}

	
	public float getMinofRainfall(String cropname) {
		
		return getminOfXRepo.getMinofRainfall(cropname);
	}

	
	public float getMinOfpH(String cropname) {
		// TODO Auto-generated method stub
		return getminOfXRepo.getMinOfpH(cropname);
	}

	
	public float getMinOfFertilizer(String cropname) {
		// TODO Auto-generated method stub
		return getminOfXRepo.getMinOfFertilizer(cropname);
	}



	
	
}