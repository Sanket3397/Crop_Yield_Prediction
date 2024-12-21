package com.Model;

import java.sql.PreparedStatement;

public class StateModel
{
	private int stateid;
	private String statename;
	public StateModel()
	{
		
	}
	public StateModel(int stateid,String sname)
	{
		this.stateid=stateid;
		this.statename=statename;
	}
	public int getSid() {
		return stateid;
	}
	public void setSid(int stateid) {
		this.stateid = stateid;
	}
	public String getSname() {
		return statename;
	}
	public void setSname(String statename) {
		this.statename = statename;
	}
	
	
}
