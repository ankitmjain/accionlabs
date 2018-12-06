package com.ankit.accionlabs.services;

import java.sql.Connection;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sun.research.ws.wadl.Response;


@Repository
public class VheicleServiceImpl implements VehicleAction {
	JdbcTemplate jdbcTemp;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemp = new JdbcTemplate(dataSource);
		int isExist = jdbcTemp.queryForInt("SELECT count(name) FROM sqlite_master WHERE type='table' AND name='Vheicles';");
		if(isExist==0) {
			jdbcTemp.execute("CREATE TABLE Vheicles(id INTEGER Primary key, " +
				     "name varchar(30) not null, " +
				     "category varchar(30) not null)");
		}
	}
	
	@Override
	public JSONArray getVheicleList() {
		JSONArray vheicleList = new JSONArray(jdbcTemp.queryForList("SELECT id,name,category FROM Vheicles"));
		// TODO Auto-generated method stub
		return vheicleList;
	}
	@Override
	public JSONObject addVheicle(JSONObject vheicleDetails) {
		JSONObject response= new JSONObject();
		String SQL = "SELECT MAX(id) FROM Vheicles";
		int id = jdbcTemp.queryForInt(SQL)+1;
		SQL = "INSERT INTO Vheicles(id,name,category) VALUES(?,?,?)";
		int isAdded = jdbcTemp.update(SQL,id,vheicleDetails.getString("name"),vheicleDetails.getString("category"));
		if(isAdded>0) {
			response.put("id",id);
			response.put("message","Record added successfully.");
		}else {
			response.put("id",0);
			response.put("message","Record adding failed. Try after sometime.");
		}
		return response;
	}
	
	@Override
	public JSONArray doSearchVheicle(String keyword) {
		String SQL = "SELECT id,name,category FROM Vheicles WHERE (id LIKE '%"+keyword+"%' OR name LIKE '%"+keyword+"%' OR category LIKE '%"+keyword+"%')";
		JSONArray vheicleList = new JSONArray(jdbcTemp.queryForList(SQL));
		return vheicleList;
	}

	@Override
	public JSONObject getVheicleDetails(int id) {
		JSONObject vheicleDetails = new JSONObject();
		try {
			vheicleDetails = new JSONObject(jdbcTemp.queryForMap("SELECT id,name,category FROM Vheicles WHERE id = ?",id));
		}catch(Exception e) {
			
		}
		return vheicleDetails;
	}
	
	@Override
	public JSONObject updateVheicleDetails(JSONObject vheicleDetails) {
		JSONObject response= new JSONObject();
		String SQL = "UPDATE Vheicles SET name=?,category=? WHERE id = ? ";
		int isAdded = jdbcTemp.update(SQL,vheicleDetails.getString("name"),vheicleDetails.getString("category"),vheicleDetails.getInt("id"));
		if(isAdded>0) {
			response.put("id",vheicleDetails.getInt("id"));
			response.put("message","Record updated successfully.");
		}else {
			response.put("id",0);
			response.put("message","Record update failed. Try after sometime.");
		}
		return response;
	}
	
	@Override
	public JSONObject deleteVheicle(int id) {
		JSONObject response = new JSONObject();
		int isDeleted = jdbcTemp.update("DELETE FROM Vheicles WHERE id=?",id);
		if(isDeleted>0) {
			response.put("id",id);
			response.put("message","Record deleted successfully.");
		}else {
			response.put("id",0);
			response.put("message","Not able delete record. Try after sometime.");
		}
		return response;
	}
	
	@Override
	public JSONObject deleteRecentVheicle() {
		JSONObject response = new JSONObject();
		int isDeleted = jdbcTemp.update("DELETE FROM Vheicles WHERE id=(SELECT MAX(id) FROM Vheicles)");
		if(isDeleted>0) {
			response.put("id",1);
			response.put("message","Recent Record deleted successfully.");
		}else {
			response.put("id",0);
			response.put("message","Not able delete record. Try after sometime.");
		}
		return response;
	}

}
