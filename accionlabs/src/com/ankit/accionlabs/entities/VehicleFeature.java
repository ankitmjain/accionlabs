package com.ankit.accionlabs.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicleFeature")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleFeature {
	
	private int featureID;
	private String featureName;
	private String featureValue;
	
	public int getFeatureID() {
		return featureID;
	}
	public void setFeatureID(int featureID) {
		this.featureID = featureID;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getFeatureValue() {
		return featureValue;
	}
	public void setFeatureValue(String featureValue) {
		this.featureValue = featureValue;
	}
	
	@Override
	public String toString() {
		return "featureID: " + featureID + "\n" + "featureName: " + featureName + "\n" + "featureValue" + featureValue+"\n\n";
	}

}
