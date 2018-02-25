package com.toysrus.automation.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiHelper {
	
	 public String get(String endPointURL, String body) {
	        Map<String, String> listOfHeaders = new HashMap<String, String>();
	        listOfHeaders.put("content-type", "application/json");
	        Response response = RestAssured.given().headers(listOfHeaders).body(body).when().get(endPointURL);
	        String stringResponse = response.asString();
	        int statusCode = response.getStatusCode();
	        Assert.assertTrue("Response code:" + response.getStatusCode() + "Message: " +
	                stringResponse, statusCode == 200);
	        return stringResponse;
	    }

	    public String post(String endPointURL, String body) {
	        Map<String, String> listOfHeaders = new HashMap<String, String>();
	        listOfHeaders.put("content-type", "application/json");
	        Response response = RestAssured.given().headers(listOfHeaders).body(body).when().post(endPointURL);
	        String stringResponse = response.asString();
	        int statusCode = response.getStatusCode();
	        Assert.assertTrue("Response code:" + response.getStatusCode() + "Message: " +
	                stringResponse, statusCode == 200);
	        return stringResponse;
	    }

	    public String put(String endPointURL, String body) {
	        Map<String, String> listOfHeaders = new HashMap<String, String>();
	        listOfHeaders.put("content-type", "application/json");
	        Response response = RestAssured.given().headers(listOfHeaders).body(body).when().put(endPointURL);
	        String stringResponse = response.asString();
	        int statusCode = response.getStatusCode();
	        Assert.assertTrue("Response code:" + response.getStatusCode() + "Message: " +
	                stringResponse, statusCode == 200);
	        return stringResponse;
	    }

	    public List<String> getValues(String response, String jsonKey) {
	        return JsonPath.with(response).get(jsonKey);
	    }

	    public String updateJsonFileAndReturnStringForBody(String filePath, String infoToUpdate) throws
	            FileNotFoundException {
	        String fileContent = "";
	        File file = new File(filePath);
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            fileContent = fileContent + String.format(line, infoToUpdate);
	        }
	        return fileContent;
	    }
	}



