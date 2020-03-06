package com.cars.ontology.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.json.JSONObject;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.UpdateExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cars.ontology.service.TestService;

@RequestMapping("api/test")
@RestController
public class TestController {
	
	private final TestService testService;
	
	@Autowired
	public TestController(TestService testService) {
		this.testService = testService;
	}
	
	@GetMapping
	public HashMap<String, Object> test() throws RepositoryException, QueryEvaluationException, MalformedQueryException {
		return testService.test();
	}
	
	@PostMapping("addCar")
	public void insertCar(@RequestParam("car") String car) throws RepositoryException, QueryEvaluationException, MalformedQueryException, UpdateExecutionException {
		testService.insertCar(car);
	}
	
	@PostMapping("addBrand")
	public void insertBrand(@RequestParam("brand") String brand) throws RepositoryException, QueryEvaluationException, MalformedQueryException, UpdateExecutionException {
		testService.insertBrand(brand);
	}
	
	@PostMapping("addBrandCar")
	public void addBrandToCar(@RequestParam("car") String car, @RequestParam("brand") String brand) throws RepositoryException, QueryEvaluationException, MalformedQueryException, UpdateExecutionException {
		testService.addBrandToCar(brand, car);
	}
	
}
