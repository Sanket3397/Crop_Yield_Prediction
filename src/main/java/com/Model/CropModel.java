package com.Model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropModel 
{
	private int cropid;
	private String cropname;
	private int fertilizer;
	private String temp;
	private float pH;
	private float rainfall;
	private int stateId;
	private int distId;
	private int cityId;
	private int Area;
	private String season;
	
	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public CropModel() {
		// TODO Auto-generated constructor stub
	}
	
	public CropModel(int cropid, String cropname, int fertilizer, String temp, float pH, int rainfall, int stateId, int distId,
			int cityId, int Area, String season) 
	{
		this.cropid=cropid;
		this.cropname=cropname;
		this.fertilizer=fertilizer;
		this.temp=temp;
		this.pH=pH;
		this.rainfall=rainfall;
		this.stateId=stateId;
		this.distId=distId;
		this.cityId=cityId;
		this.Area=Area;
		this.season=season;
	}
	public int getCropid() 
	{
		return cropid;
	}
	public void setCropid(int cropid) {
		this.cropid = cropid;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public int getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(int fertilizer) {
		this.fertilizer = fertilizer;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public float getpH() {
		return pH;
	}
	public void setpH(float pH) {
		this.pH = pH;
	}
	public float getRainfall() {
		return rainfall;
	}
	public void setRainfall(float rainfall) {
		this.rainfall = rainfall;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getDistId() {
		return distId;
	}
	public void setDistId(int distId) {
		this.distId = distId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getArea() {
		return Area;
	}
	public void setArea(int area) {
		Area = area;
	}
}
