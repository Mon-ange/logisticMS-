package cn.brimon.model;

import java.util.Date;

public class Location {
	private String locationName = new String();
	private User handleUser;
	private Double distance = new Double(0);
	private Date timestamps = new Date();
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public User getHandleUser() {
		return handleUser;
	}
	public void setHandleUser(User handleUser) {
		this.handleUser = handleUser;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Date getTimestamps() {
		return timestamps;
	}
	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}
	
	
}
