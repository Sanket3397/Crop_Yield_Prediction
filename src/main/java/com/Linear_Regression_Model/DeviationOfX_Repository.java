package com.Linear_Regression_Model;

import java.util.List;

public interface DeviationOfX_Repository 
{
	public List<Float> getDeviationOfTemp(String cropname);
	public List<Float> getDeviationofRainfall(String cropname);
	public List<Float> getDeviationofpH(String cropname);
	public List<Float> getDeviationofFertilizer(String cropname);
	
	
}
