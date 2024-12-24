package com.crop.Seriveces;

import java.util.List;

import com.Model.DistModel;

public interface DistService {
	public abstract boolean isDistrictAdd(DistModel distmodel);

	public abstract List<DistModel> districtList();
}
