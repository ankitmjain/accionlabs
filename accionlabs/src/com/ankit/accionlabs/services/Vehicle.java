/**
 * 
 */
package com.ankit.accionlabs.services;

import java.io.Serializable;

/**
 * @author ankitjain
 *
 */
public class Vehicle implements Serializable{
	
	private static final long serialVersionUID = -3501772243949297054L;
	
	private int id;
	private String vehicleName; 
	private String vehicleCategory;
	
	public Vehicle(){};
	public Vehicle(int i, String vehicleName,String vehicleCategory){ 
		super(); 
		this.id = i; 
		this.vehicleName = vehicleName;
		this.vehicleCategory = vehicleCategory;
	} 
	
	public int getId(){ 
		return id; 
	} 
	
	public void setId(int id) { 
		this.id = id; 
		
	} 
	
	public String getVehicleName() { 
		return vehicleName; 
	} 
	
	public void setVehicleName(String vehicleName) { 
		this.vehicleName = vehicleName; 
	} 
	
	public String getVehicleCategory() { 
		return vehicleCategory; 
	} 
	
	public void setVehicleCategory(String vehicleCategory) { 
		this.vehicleCategory = vehicleCategory; 
	} 
}
