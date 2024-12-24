package com.crop.Repository;

import java.util.List;

import com.Model.OldDataSetModel;

public interface OldDataSetRepository {
	public boolean isOldDataSetAdded(OldDataSetModel olddataset);
	public List <OldDataSetModel> olddataset(); 
}
