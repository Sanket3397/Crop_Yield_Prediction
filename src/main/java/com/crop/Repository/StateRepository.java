package com.crop.Repository;

import java.util.*;

import com.Model.CustModel;
import com.Model.DistModel;
import com.Model.StateModel;

public interface StateRepository 
{
	public boolean AddDataCust(CustModel cmodel);
	public List<CustModel> getCustName(String str);
	public boolean isAddNewState(StateModel model);
	public  abstract List<StateModel> allState();
	
	

}
