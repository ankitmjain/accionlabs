package com.ankit.accionlabs.services;

import org.json.JSONArray;

import org.json.JSONObject;

public interface VehicleAction {
	
	JSONArray getVheicleList();
	JSONObject addVheicle(JSONObject vheicleDetails);
	JSONObject getVheicleDetails(int id);
	JSONObject deleteVheicle(int id);
	JSONObject updateVheicleDetails(JSONObject vheicleDetails);
	JSONArray doSearchVheicle(String keyword);
	JSONObject deleteRecentVheicle();
}
