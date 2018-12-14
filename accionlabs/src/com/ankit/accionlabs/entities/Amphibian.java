package com.ankit.accionlabs.entities;

import java.io.Serializable;
import java.util.List;

public class Amphibian extends Vehicle implements Serializable {
	public Amphibian(int id, String name,String vehicleType, String make, String modal, String modeOfTranport,
			List<VehicleFeature> featureList) {
		super(id,name,vehicleType, make, modal, modeOfTranport, featureList);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	/*private List<String> featureList;
	public List<String> getFeatureList() {
		return featureList;
	}
	public void setFeatureList(List<String> featureList) {
		this.featureList = featureList;
	}
	public Amphibian(String vehicleType,String make,String modal,String modeOfTranport,String carType,String controlType,String numberofWheels,String numberofSeats) {
		super(vehicleType,make,modal,modeOfTranport);
		this.featureList = new ArrayList<>();
		this.featureList.add(carType);
		this.featureList.add(controlType);
		this.featureList.add(numberofWheels);
		this.featureList.add(numberofSeats);
	}*/
}
