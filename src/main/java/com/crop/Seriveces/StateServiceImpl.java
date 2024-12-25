package com.crop.Seriveces;

import java.util.List;
import com.Model.DistModel;
import com.Model.StateModel;
import com.crop.Repository.StateRepository;
import com.crop.Repository.StateRepositoryImpl;
public class StateServiceImpl implements StateService
{
	StateRepository staterepo = new StateRepositoryImpl();
	
	public boolean isAddedNewState(StateModel statemodel) 
	{
		return staterepo.isAddedNewState(statemodel);
	}
	
	
	public List <StateModel> allState()
	{
		return staterepo.allState();
	}

	@Override
	public StateModel getStateByName(String stateName)
	{
		return staterepo.getStateByName(stateName);	
	}


	@Override
	public boolean isDeleteState(String stateName)
	{
		return staterepo.isDeleteState(stateName);
	}

	@Override
	public boolean isUpdateState(String currName, String newName) 
	{
		return staterepo.isUpdateState(currName, newName);
	}


}


