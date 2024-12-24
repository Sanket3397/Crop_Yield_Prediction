package com.crop.Seriveces;

import java.util.List;
import com.Model.DistModel;
import com.Model.StateModel;

public interface StateService 
{
	public abstract  boolean isAddedNewState(StateModel statemodel);
	public List<StateModel> allState();
	public StateModel getStateByName(String stateName);
	public boolean isDeleteState(String stateName);
	public boolean isUpdateState(String currName,String newName);
}
