package com.Model;

public class CustModel 
{
	private int custid;
	private String custname;
	private String custemail;
	
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	public CustModel()
	{
		
	}
	public CustModel(int custid, String custname,String custemail) 
	{
		this.custid=custid;
		this.custname=custname;
		this.custemail=custemail;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "CustModel [custid=" + custid + ", custname=" + custname + ", custemail=" + custemail + "]";
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	

}
