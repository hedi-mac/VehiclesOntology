package com.api_ontology.convertion.api_ontology.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.api_ontology.convertion.api_ontology.entity.Vehicle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class CarsFileAccess {
	
	public static void main(String []args) {
		getCarsJson();
	}
	
	public static final String PATH = "C:\\\\Users\\\\hedim\\\\OneDrive\\\\Bureau\\\\NLP\\\\_Working_here_\\\\api-ontology\\\\res\\\\vehicules-commercialises.json";
	
	public static ArrayList<Vehicle> getCarsJson() {
		ArrayList<Vehicle> vehicules = new ArrayList<Vehicle>();
		JSONParser parser = new JSONParser();
	    try (Reader reader = new FileReader(PATH)) {
	    	JSONArray jsonArray = (JSONArray) parser.parse(reader);
	        Iterator iterator = jsonArray.iterator();
	        while (iterator.hasNext()) {
	        	JSONObject jsonObject = (JSONObject)iterator.next();
	        	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        	String prettyJson = gson.toJson(jsonObject.get("fields"));
	        	//System.out.println(prettyJson);
            	
	        	Gson g = new Gson();
            	Vehicle v = g.fromJson(gson.toJson(jsonObject.get("fields")), Vehicle.class);
            	//System.out.println(v);
            	vehicules.add(v);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return vehicules;
	}
	
	
	
}
