package com.crop.Seriveces;

import java.util.List;

import com.Model.CropModel;

public interface CropService {
	public boolean isCropAdded(CropModel cropmodel);
	public List<CropModel> allCropList();
}
