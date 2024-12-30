package com.Linear_Regression_Services;

import java.util.List;

public interface Deviation_Of_X_Service 
{

	public List<Float> getDeviationOfTemp(String cropname);
	public List<Float> getDeviationofRainfall(String cropname);
	public List<Float> getDeviationofpH(String cropname);
	public List<Float> getDeviationofFertilizer(String cropname);
	
}
