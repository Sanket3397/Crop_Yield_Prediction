package com.crop.Seriveces;

import java.util.List;

import com.Model.CustModel;
import com.Model.DistModel;
import com.Model.StateModel;
import com.crop.Repository.StateRepository;
import com.crop.Repository.StateRepositoryImpl;
public class StateServiceImpl implements StateService
{
	StateRepository stateRepo=new StateRepositoryImpl();

	@Override
	public boolean isAddNewState(StateModel model) 
	{
	
		return stateRepo.isAddNewState(model);
	}

	@Override
	public boolean AddDataCust(CustModel cmodel) 
	{
	
		return stateRepo.AddDataCust(cmodel);
	}

	@Override
	public List<StateModel> allState() 
	{
		
		return stateRepo.allState();
	}

	@Override
	public List<CustModel> getCustName(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
//	public boolean isAddNewDist(DistModel dmodel) 
//	{
//		
//		return stateRepo.isAddNewDist(dmodel);
//	}
//
//	@Override
//	public List<CustModel> getCustName(String str)
//	{
//		return stateRepo.getCustName(str);
//		
//	}
//
//	@Override
//	public boolean isAddStateDist(String stateName, String distName) 
//	{
//		
//		return stateRepo.isAddStateDist(stateName, distName);
//	}
	
	
}


