package com.crop.Seriveces;

import java.util.List;

import com.Model.OldDataSetModel;
import com.crop.Repository.OldDataSetRepositoryImpl;

public class OldDataSetServiceImpl implements OldDataSetService 
{
	OldDataSetRepositoryImpl olddataRepo=new OldDataSetRepositoryImpl();
	
	@Override
	public boolean isOldDataSetAdded(OldDataSetModel olddataset) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OldDataSetModel> olddataset() {
		// TODO Auto-generated method stub
		return null;
	}

}
