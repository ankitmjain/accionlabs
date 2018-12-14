/**
 * 
 */
package com.ankit.accionlabs.entities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ankitjain
 *
 */
@XmlRootElement(name = "vehicle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle {
	private int id;
	private String name;
	private String vehicleType;
	private String make;
	private String modal;
	private String modeOfTranport;
	protected List<VehicleFeature> featureList;

	public Vehicle() {

	}

	public Vehicle(int id, String name, String vehicleType, String make, String modal, String modeOfTranport,
			List<VehicleFeature> featureList) {
		this.id = id;
		this.name = name;
		this.vehicleType = vehicleType;
		this.make = make;
		this.modal = modal;
		this.modeOfTranport = modeOfTranport;
		this.featureList = featureList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}

	public String getModeOfTranport() {
		return modeOfTranport;
	}

	public void setModeOfTranport(String modeOfTranport) {
		this.modeOfTranport = modeOfTranport;
	}

	public List<VehicleFeature> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(List<VehicleFeature> featureList) {
		this.featureList = featureList;
	}

	@Override
	public String toString() {
		return "id: " + id + "\n" + "name: " + name + "\n" + "make: " + make + "\n" + "modal: " + modal + "\n"
				+ "modeOfTranport: " + modeOfTranport + "\n" + "vehicleType: " + vehicleType + "\n\n";
	}
}
