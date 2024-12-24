package com.crop.Seriveces;

import java.util.List;

import com.Model.OldDataSetModel;

public interface OldDataSetService {
	public boolean isOldDataSetAdded(OldDataSetModel olddataset);
	public List<OldDataSetModel> olddataset();
}
