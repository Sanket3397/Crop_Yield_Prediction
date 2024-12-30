package com.crop.Seriveces;

import java.util.List;
import com.crop.Repository.*;
import com.Model.CropModel;

public class Filter_Data_Impl implements Filter_Data
{
 Filter_Data_Repo filterrepo=new Filter_Data_Repo_Impl();
	@Override
	public List<CropModel> filterbyCropName(String cropname) {
		// TODO Auto-generated method stub
		return filterrepo.filterbyCropName(cropname);
	}

	@Override
	public List<CropModel> filterCropBySeason(String season) {
		// TODO Auto-generated method stub
		return filterrepo.filterCropBySeason(season);
	}

}
