package com.Linear_Regression_Model;

import java.util.*;

import com.crop.Repository.DBState;

public class DeviationOf_X_Repository_Impl extends DBState implements DeviationOfX_Repository 
{

	GetMinOf_X_Repository getminOfX = new Get_Min_of_X_Repo_Impl();
	GetMinOf_X_Repository getMinOfX_rainfal = new Get_Min_of_X_Repo_Impl();
	
	@Override
	public List<Float> getDeviationOfTemp(String cropname) {
	    List<Float> deviations = new ArrayList<>();
	    try {
	        // Get the mean temperature for the crop
	        float meanOfTemp = getminOfX.getMinOfTemp(cropname);
	        //System.out.println("The Mean of X is: " + meanOfTemp);

	       
	        stmt = conn.prepareStatement("select temp from olddataset where cropname = ?");
	        stmt.setString(1, cropname);
	        rs = stmt.executeQuery();

	       
	        while (rs.next()) {
	            int temp = rs.getInt("temp");
	            //System.out.println("The temp is: " + temp);

	            float deviation = temp - meanOfTemp;
	            deviations.add(deviation);

	         //   System.out.println("Deviation of X: " + deviation);
	        }

	        return deviations; 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return deviations; 
	}
	
	
	@Override
	public List<Float> getDeviationofRainfall(String cropname) {
		
		 List<Float> deviations = new ArrayList<>();
		    try {
		        // Get the mean temperature for the crop
		        float meanOfRainfall = getminOfX.getMinofRainfall(cropname);
		       // System.out.println("The Mean of X is: " + meanOfRainfall);

		       
		        stmt = conn.prepareStatement("select rainfall from olddataset where cropname = ?");
		        stmt.setString(1, cropname);
		        rs = stmt.executeQuery();

		       
		        while (rs.next()) {
		            int rainfall = rs.getInt("rainfall");
		           // System.out.println("The Rainfall is: " + rainfall);

		            float deviation = rainfall - meanOfRainfall;
		            deviations.add(deviation);

		            //System.out.println("Deviation of X Rainfall : " + deviation);
		        }

		        return deviations; 

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return deviations; 
		}
	
	@Override
	public List<Float> getDeviationofpH(String cropname) {
		List<Float> deviations = new ArrayList<>();
	    try {
	        // Get the mean temperature for the crop
	        float meanOfpH = getminOfX.getMinOfpH(cropname);
	       // System.out.println("The Mean of X  Pis: " + meanOfpH);

	       
	        stmt = conn.prepareStatement("select pH from olddataset where cropname = ?");
	        stmt.setString(1, cropname);
	        rs = stmt.executeQuery();

	       
	        while (rs.next()) {
	            int pH = rs.getInt("pH");
	            
	        //    System.out.println("The pH is: " + pH);

	            float deviation = pH - meanOfpH;
	            deviations.add(deviation);

	           // System.out.println("Deviation of X Rainfall : " + deviation);
	        }

	        return deviations; 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return deviations; 
	}
	
	@Override
	public List<Float> getDeviationofFertilizer(String cropname) {
		
		List<Float> deviations = new ArrayList<>();
	    try {
	        // Get the mean temperature for the crop
	        float meanOfFertilizer = getminOfX.getMinOfFertilizer(cropname);
	      //  System.out.println("The Mean of X  Fertilizer  " + meanOfFertilizer);

	       
	        stmt = conn.prepareStatement("select Fertilizer from olddataset where cropname = ?");
	        stmt.setString(1, cropname);
	        rs = stmt.executeQuery();

	       
	        while (rs.next()) {
	            int Fertilizer = rs.getInt("Fertilizer");
	            
	          //  System.out.println("The fertilizer is: " + Fertilizer);

	            float deviation = Fertilizer - meanOfFertilizer;
	            deviations.add(deviation);

	          //  System.out.println("Deviation of X Rainfall : " + deviation);
	        }

	        return deviations; 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return deviations; 
	}
}
