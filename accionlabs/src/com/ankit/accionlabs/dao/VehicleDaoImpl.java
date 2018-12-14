package com.ankit.accionlabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ankit.accionlabs.entities.Vehicle;
import com.ankit.accionlabs.entities.VehicleFeature;
import com.ankit.accionlabs.entities.VehicleTypes;
import com.ankit.accionlabs.services.VehicleService;

@Repository
public class VehicleDaoImpl implements VehicleService {
	JdbcTemplate jdbcTemp;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemp = new JdbcTemplate(dataSource);
		int isExist = jdbcTemp.queryForInt("SELECT count(name) FROM sqlite_master WHERE type='table' AND name='Vehicles';");
		if(isExist==0) {
			int isDone = jdbcTemp.update("CREATE TABLE Vehicles(id INTEGER Primary key, " +
				     "name varchar(30) not null,make varchar(20),modal integer(4),modeOfTranport varchar(20)," +
				     "vehicleType varchar(30) not null)");
			//if(isDone>1) {
				isDone = jdbcTemp.update("CREATE TABLE VechicleFeatures(featureID INTEGER Primary key,id INTEGER," +
					     "feature_name varchar(30) not null, " +
					     "feature_value varchar(30) not null,FOREIGN KEY(id) REFERENCES Vehicles(id) ON DELETE CASCADE)");
			//}
			
		}
	}
	
	@Override
	public List<Vehicle> getVheicleList() {
		List<Vehicle> vechileList = jdbcTemp.query("SELECT id,name,make,modal,modeOfTranport,vehicleType FROM Vehicles",new RowMapper<Vehicle>(){  
		      @Override  
		      public Vehicle mapRow(ResultSet rs, int rownumber) throws  SQLException    {  
		    	  Vehicle e=new Vehicle();  
		            e.setId(rs.getInt(1));  
		            e.setName(rs.getString(2));  
		            e.setMake(rs.getString(3));
		            e.setModal(rs.getString(4));
		            e.setModeOfTranport(rs.getString(5));
		            e.setVehicleType(rs.getString(6));
		            
		            List<VehicleFeature> veicheFeature = jdbcTemp.query("SELECT featureID,feature_name,feature_value FROM VechicleFeatures WHERE id = "+e.getId(),
		            		new RowMapper<VehicleFeature>() {

						@Override
						public VehicleFeature mapRow(ResultSet rs1, int rowNum) throws SQLException {
							VehicleFeature vf = new VehicleFeature();
							vf.setFeatureID(rs1.getInt(1));
							vf.setFeatureName(rs1.getString(2));
							vf.setFeatureValue(rs1.getString(3));
							// TODO Auto-generated method stub
							return vf;
						}
					});
		            e.setFeatureList(veicheFeature);
		            
		            return e;  
		          }  
		      });
		
		System.out.println(">>>> ANKIT vechileList "+vechileList);
		
		/*for(int i=0;i<vechileList.length();i++) {
			JSONObject tempObject = vechileList.getJSONObject(i);
			JSONArray featureList = new JSONArray(jdbcTemp.queryForList("SELECT featureID,feature_name,feature_value FROM VechicleFeatures WHERE id = ?",tempObject.getInt("id")));
			tempObject.put("featureList",featureList);
		}*/
		return vechileList;
	}
	@Override
	public JSONObject addVheicle(JSONObject vheicleDetails) {
		
		JSONObject response= new JSONObject();
		try {
			VehicleTypes valueOf = VehicleTypes.valueOf(vheicleDetails.getString("vehicleType"));
		}catch(IllegalArgumentException ie){
			response.put("id",0);
			response.put("message","Veichle Type is not exist.");
			return response;
		}
		String SQL = "SELECT MAX(id) FROM Vehicles";
		int id = jdbcTemp.queryForInt(SQL)+1;
		SQL = "INSERT INTO Vehicles(id,name,make,modal,modeOfTranport,vehicleType) VALUES(?,?,?,?,?,?)";
		int isAdded = jdbcTemp.update(SQL,id,vheicleDetails.getString("name"),vheicleDetails.getString("make"),vheicleDetails.getInt("modal"),
				vheicleDetails.getString("modeOfTranport"),vheicleDetails.getString("vehicleType"));
		if(isAdded>0) {
			JSONArray featureList = vheicleDetails.getJSONArray("featureList");
			if(featureList.length()>0) {
				SQL = "INSERT INTO VechicleFeatures(featureID,id,feature_name,feature_value) VALUES(?,?,?,?)";
				int featureId = jdbcTemp.queryForInt("SELECT MAX(featureID) FROM VechicleFeatures")+1;
				for(int i=0;i<featureList.length();i++) {
					JSONObject tempFeature = featureList.getJSONObject(i);
					jdbcTemp.update(SQL,featureId++,id,tempFeature.getString("feature_name"),tempFeature.getString("feature_value"));
				}
			}
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
		String SQL = "SELECT id,name,category FROM Vehicles WHERE (id LIKE '%"+keyword+"%' OR name LIKE '%"+keyword+"%' OR category LIKE '%"+keyword+"%')";
		JSONArray vheicleList = new JSONArray(jdbcTemp.queryForList(SQL));
		return vheicleList;
	}

	@Override
	public JSONObject getVheicleDetails(int id) {
		JSONObject vheicleDetails = new JSONObject();
		try {
			vheicleDetails = new JSONObject(jdbcTemp.queryForMap("SELECT id,name,category FROM Vehicles WHERE id = ?",id));
		}catch(Exception e) {
			
		}
		return vheicleDetails;
	}
	
	@Override
	public JSONObject updateVheicleDetails(JSONObject vheicleDetails) {
		JSONObject response= new JSONObject();
		String SQL = "UPDATE Vehicles SET name=?,category=? WHERE id = ? ";
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
		int isDeleted = jdbcTemp.update("DELETE FROM Vehicles WHERE id=?",id);
		if(isDeleted>0) {
			response.put("id",id);
		}else {
			response.put("id",0);
			response.put("message","Not able delete record. Try after sometime.");
		}
		return response;
	}
	
	@Override
	public JSONObject deleteRecentVheicle() {
		JSONObject response = new JSONObject();
		int isDeleted = jdbcTemp.update("DELETE FROM Vehicles WHERE id=(SELECT MAX(id) FROM Vehicles)");
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
