package com.Linear_Regression_Services;
import com.Linear_Regression_Model.Get_Value_Of_M_Repository;
import com.Linear_Regression_Model.Get_Value_of_M_Repository_Impl;
public class Crop_Yield_Prediction_Using_Linear_Regression_Impl  implements Crop_Yield_Prediction_Using_Linear_Regression{

	Get_Value_Of_M_Repository getMinRepo= new Get_Value_of_M_Repository_Impl();
	
	Get_ValueOf_M_Services  getValue_M = new Get_Value_of_M_Services_Impl();
	Get_Value_B_Intercept_Service getValueOfB  = new Get_Value_B_Intercept_Service__Impl();
	
	
	@Override
	public float getCropYield(String cropname, float temp, float rainfall, float pH, float Fertilizer) {
		
		float m_temp = getValue_M.get_M_of_Temp(cropname);
		float m_rainfall = getValue_M.get_M_of_Rainfall(cropname);
		float m_pH = getValue_M.get_M_of_Soil_pH(cropname);
		float m_fertilizer = getValue_M.get_M_of_Fertilizer(cropname);
		
		float valueOfB= getValueOfB.valueOfB_Intercept(cropname);
		
		float cropYield = (m_temp * temp)+(m_rainfall * rainfall)+(m_pH*pH)+ (m_fertilizer *Fertilizer) + valueOfB;
		
		
		return cropYield/1000;
	}

}
