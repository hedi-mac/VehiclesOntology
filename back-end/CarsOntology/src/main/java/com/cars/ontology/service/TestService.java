package com.cars.ontology.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cars.ontology.util.ConnectionUtil;
import com.cars.ontology.util.QueryUtil;
import com.cars.ontology.util.UpdateUtil;

import java.util.List;
import java.util.Map;

import org.eclipse.rdf4j.model.impl.SimpleLiteral;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.UpdateExecutionException;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.impl.SimpleBinding;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.json.JSONObject;

@Service
public class TestService {
	
    private IRI formatUri(String car) {
        return SimpleValueFactory.getInstance().createIRI("http://www.carontology.com/test#" + car);
    }
	
	@GetMapping
	public HashMap<String, Object> test() throws RepositoryException, QueryEvaluationException, MalformedQueryException {
		return this.listBrandOfCars();
	}
	
    public HashMap<String, Object> listBrandOfCars() throws RepositoryException, MalformedQueryException, QueryEvaluationException {
        HashMap<String, Object> map = new HashMap<String, Object>(); 
        List tab = new ArrayList();
        TupleQueryResult result = QueryUtil.evaluateSelectQuery(ConnectionUtil.getInstance().getRepositoryConnection(),
        		"SELECT * WHERE {"+
        		"   ?car rdf:type <http://www.carontology.com/test#Car>."+
        		"   ?car <http://www.carontology.com/test#hasBrand> ?brand ."+ 
        		"	?brand rdf:type <http://www.carontology.com/test#Brand> . "+
        		"} ", 
        		new SimpleBinding("", formatUri("")));
        while (result.hasNext()) {
            BindingSet bindingSet = result.next();
            IRI carDes = (IRI) bindingSet.getBinding("car").getValue();
            IRI brand = (IRI) bindingSet.getBinding("brand").getValue();
            Map<String, Object> car = new HashMap<String, Object>();
            car.put("ComercialDesignation", carDes.getLocalName());
            car.put("Brand", brand.getLocalName());
            tab.add(car);
        }
        map.put("Car", tab);
        result.close();
        return map;
    }
    
	@PostMapping
	public void insertCar(String car) throws MalformedQueryException, RepositoryException, UpdateExecutionException {
        IRI carURI = formatUri(car);
        ConnectionUtil.getInstance().getRepositoryConnection().begin();
        UpdateUtil.executeUpdate(ConnectionUtil.getInstance().getRepositoryConnection(),
                String.format(
                		"PREFIX : <http://www.carontology.com/test#>"+
                		"INSERT DATA"+
                		        "{"+
                		              "GRAPH <http://www.carontology.com/test> "+
                		              "{"+
                		                	"<%s> rdf:type :Car ."+
                		              "}"+
                		        "}", carURI));
        ConnectionUtil.getInstance().getRepositoryConnection().commit();
    }
    
	@PostMapping
	public void insertBrand(String brand) throws MalformedQueryException, RepositoryException, UpdateExecutionException {
        IRI brandURI = formatUri(brand);
        ConnectionUtil.getInstance().getRepositoryConnection().begin();
        UpdateUtil.executeUpdate(ConnectionUtil.getInstance().getRepositoryConnection(),
                String.format(
                		"PREFIX : <http://www.carontology.com/test#>"+
                		"INSERT DATA"+
                		        "{"+
                		              "GRAPH <http://www.carontology.com/test> "+
                		              "{"+
                		                	"<%s> rdf:type :Brand ."+
                		              "}"+
                		        "}", brandURI));
        ConnectionUtil.getInstance().getRepositoryConnection().commit();
    }  
    
	@PostMapping
	public void addBrandToCar(String brand, String car) throws MalformedQueryException, RepositoryException, UpdateExecutionException {
        IRI carURI = formatUri(brand);
        ConnectionUtil.getInstance().getRepositoryConnection().begin();
        UpdateUtil.executeUpdate(ConnectionUtil.getInstance().getRepositoryConnection(),
                String.format(
                		"PREFIX : <http://www.carontology.com/test#>"+
                		"INSERT DATA"+
                			"{"+
                		    	"<%s> :hasBrand <%s>"+
                		    "}", formatUri(car), formatUri(brand)));
        ConnectionUtil.getInstance().getRepositoryConnection().commit();
    } 
	
}
