package com.ankit.accionlabs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle implements Serializable {

	public Truck(int id,String name,String vehicleType, String make, String modal, String modeOfTranport,List<VehicleFeature> featureList) {
		super(id,name,vehicleType, make, modal, modeOfTranport, featureList);
		// TODO Auto-generated constructor stub
	}
	/*private static final long serialVersionUID = 1L;
	private List ;
	public List getFeatureList() {
		return featureList;
	}
	public void setFeatureList(List featureList) {
		this.featureList = featureList;
	}
	public Truck(String vehicleType,String make,String modal,String modeOfTranport,String carType,String controlType,String numberofWheels,String numberofSeats) {
		super(vehicleType,make,modal,modeOfTranport, featureList);
		
	}*/
}
