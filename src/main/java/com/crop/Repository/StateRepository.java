package com.crop.Repository;

import java.util.*;


import com.Model.DistModel;
import com.Model.StateModel;

public interface StateRepository 
{
	public abstract boolean isAddedNewState(StateModel statemodel);
	public  abstract List<StateModel> allState();
	public StateModel getStateByName(String stateName);
	public boolean isDeleteState(String stateName);
	public boolean isUpdateState(String currName,String newName);
	
}
