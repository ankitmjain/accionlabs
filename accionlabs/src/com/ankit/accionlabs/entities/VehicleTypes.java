package com.ankit.accionlabs.entities;

public enum VehicleTypes {
	Car,
	Truck,
	Airplane,
	Drone,
	Amphibian,
	Boat;
	public VehicleTypes getByName(String name){
        for (VehicleTypes st : VehicleTypes.values()) {
            if (st.toString().equals(name)){
                return st;
            }
        }
        return null;
    }
}
