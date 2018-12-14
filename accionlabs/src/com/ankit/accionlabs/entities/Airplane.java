package com.ankit.accionlabs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Airplane extends Vehicle implements Serializable {
	public Airplane(int id,String name,String vehicleType, String make, String modal, String modeOfTranport,
			List<VehicleFeature> featureList) {
		super(id, vehicleType, make, modal, modeOfTranport, modeOfTranport, featureList);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	/*private List featureList;
	public List getFeatureList() {
		return featureList;
	}
	public void setFeatureList(List<String> featureList) {
		this.featureList = featureList;
	}
	public Airplane(String vehicleType,String make,String modal,String modeOfTranport,String planType,int numberofEngine,int numberofSeats) {
		super(vehicleType,make,modal,modeOfTranport);
		this.featureList = new ArrayList();
		this.featureList.add(planType);
		this.featureList.add(numberofEngine);
		this.featureList.add(numberofSeats);
	}*/
}
