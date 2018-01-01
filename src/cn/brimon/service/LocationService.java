package cn.brimon.service;

import java.util.List;

import cn.brimon.dao.LocationDao;
import cn.brimon.dao.LocationDaoFactory;
import cn.brimon.model.*;

public class LocationService {
	public void setOrderLocation(Order order,Location location){
		LocationDao ld = LocationDaoFactory.getDao();
		ld.setLocationByOrder(order, location);
	}
	
	public List<Location> getOrderLocationByOrder(Order order){
		LocationDao ld = LocationDaoFactory.getDao();
		return ld.getLocationByOrder(order);
	}
}
