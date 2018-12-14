package com.ankit.accionlabs.services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ankit.accionlabs.entities.Vehicle;

public interface VehicleService {
	
	List<Vehicle> getVheicleList();
	JSONObject addVheicle(JSONObject values);
	JSONObject getVheicleDetails(int id);
	JSONObject deleteVheicle(int id);
	JSONObject updateVheicleDetails(JSONObject vheicleDetails);
	JSONArray doSearchVheicle(String keyword);
	JSONObject deleteRecentVheicle();
}
