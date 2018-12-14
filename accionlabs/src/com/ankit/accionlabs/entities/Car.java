package com.ankit.accionlabs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Car extends Vehicle implements Serializable {
	
	public Car(int id,String name,String vehicleType, String make, String modal, String modeOfTranport, List<VehicleFeature> featureList) {
		super(id,name,vehicleType, make, modal, modeOfTranport, featureList);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private List featureList;
	public List getFeatureList() {
		return featureList;
	}
	/*public void setFeatureList(List<String> featureList) {
		this.featureList = featureList;
	}
	public Car(String vehicleType,String make,String modal,String modeOfTranport,String carType,String controlType,int numberofWheels,int numberofSeats) {
		super(vehicleType,make,modal,modeOfTranport);
		this.featureList = new ArrayList();
		HashMap featureMap = new HashMap();
		featureMap.put("CarType",carType);
		this.featureList.add(featureMap);
		featureMap = new HashMap();
		featureMap.put("ControlType",controlType);
		this.featureList.add(featureMap);
		featureMap = new HashMap();
		featureMap.put("NumberofWheels",numberofWheels);
		this.featureList.add(featureMap);
		featureMap = new HashMap();
		featureMap.put("NumberofSeats",numberofSeats);
		this.featureList.add(featureMap);
	}*/
}
