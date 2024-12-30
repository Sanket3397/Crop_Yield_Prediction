package com.Model;

public class DistModel {
	private int districtid;
	private String districtname;

	public DistModel() {

	}

	public DistModel(int int1, String string)
	{
		this.districtid=int1;
		this.districtname=string;
	}

	public int getDistrictid() {
		return districtid;
	}

	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

}
