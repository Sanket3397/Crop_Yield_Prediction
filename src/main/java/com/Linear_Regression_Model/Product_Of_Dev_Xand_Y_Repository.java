package com.Linear_Regression_Model;

import java.util.List;

public interface Product_Of_Dev_Xand_Y_Repository
{
	List<Float> product_of_Dev_X_and_Y( String cropname);
	List<Float> product_of_Dev_X_rainfall_and_Y( String cropname);
	List<Float> product_of_Dev_X_pH_and_Y( String cropname);
	List<Float> product_of_Dev_X__fertilizerand_Y( String cropname);
}
