package com.crop.Repository;

import java.util.List;

import com.Model.CropModel;

public interface CropRepository {
	public boolean isCropAdded(CropModel cropmodel);
	public List<CropModel> allCropList();
}
