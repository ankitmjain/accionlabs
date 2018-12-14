package com.ankit.accionlabs.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankit.accionlabs.entities.Vehicle;
import com.ankit.accionlabs.services.VehicleService;

@Component
@Path("/VehicleService")
public class VehicleController {
 
	@Autowired
	VehicleService action;
	  
	@GET @Path("/List")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public List<Vehicle> getVheicleList() throws JSONException{
		List<Vehicle> vheicleList = action.getVheicleList();
		return vheicleList;
	  }
	
	
	@GET @Path("/{id}")
	 @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Response getVheicleDetailById(@PathParam("id") int id) throws JSONException {
		JSONObject vheicleDetails = action.getVheicleDetails(id);
		return Response.status(200).entity(vheicleDetails.toString()).build();
	  }
	
	@GET @Path("/Search")
	 @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Response doSearchVheicle(@QueryParam("keyword") String keyword) throws JSONException {
		JSONArray vheicleDetails = action.doSearchVheicle(keyword);
		return Response.status(200).entity(vheicleDetails.toString()).build();
	  }
	@DELETE @Path("/{id}")
	 @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Response deleteVheicle(@PathParam("id") int id) throws JSONException {
		JSONObject vheicleDetails = action.deleteVheicle(id);
		return Response.status(200).entity(vheicleDetails.toString()).build();
	  }
	@DELETE @Path("/DeleteRecent")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Response deleteRecentVheicle() throws JSONException {
		JSONObject vheicleDetails = action.deleteRecentVheicle();
		return Response.status(200).entity(vheicleDetails.toString()).build();
	  }
	
	@POST @Path("/AddVheicle")
	 @Consumes({MediaType.APPLICATION_JSON})
	 @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Response addVheicleDetails(String values) throws JSONException {
		JSONObject vheicleDetails = action.addVheicle(new JSONObject(values));
		return Response.status(200).entity(vheicleDetails.toString()).build();
	  } 
	@PUT @Path("/UpdateVheicle")
	@Consumes({MediaType.APPLICATION_JSON})
	 @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Response updateVheicleDetails(String values) throws JSONException {
		JSONObject vheicleDetails = action.updateVheicleDetails(new JSONObject(values));
		return Response.status(200).entity(vheicleDetails.toString()).build();
	  }
}