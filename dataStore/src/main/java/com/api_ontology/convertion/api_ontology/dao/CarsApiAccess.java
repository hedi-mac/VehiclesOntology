package com.api_ontology.convertion.api_ontology.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class CarsApiAccess {
	
	public static void main(String []args) {
		try {
			getCarsJson();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static final String URL = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=vehicules-commercialises&rows=3360";
	
	public static void getCarsJson() throws IOException, ParseException {
		URL obj = new URL(CarsApiAccess.URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
	     con.setRequestMethod("GET");
	     //add request header 
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + URL);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     JSONParser parser = new JSONParser();
	     JSONObject myResponse = (JSONObject)parser.parse(response.toString());
	     
	     
	     JSONArray jArray = (JSONArray)(myResponse.get("records"));
	     //System.out.println(jArray);

	     try {
		     
		     Iterator<JSONObject> iterator = ((JSONArray) jArray).iterator();
		     while (iterator.hasNext()) {
		     	JSONObject jsonObject = (JSONObject)iterator.next();
		     	
		     	Gson gson = new GsonBuilder().setPrettyPrinting().create();
		     	Gson g = new Gson();		     	
		     	System.out.println(gson.toJson(jsonObject.get("fields")));
		     }
	     }catch (Exception e) {
	         e.printStackTrace();
	     } 
	     
	}
	
	
}
