package com.cars.ontology.util;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.http.HTTPRepository;


public class ConnectionUtil {

	  // GraphDB 
	  private static ConnectionUtil INSTANCE = null;
	  private static final String GRAPHDB_SERVER = "http://localhost:7200/";
	  private static final String REPOSITORY_ID = "CarRepository";
	  private RepositoryConnection connection = null;
	  
	  public RepositoryConnection getRepositoryConnection() {
		  return this.connection;
	  }
	  
	  public static ConnectionUtil getInstance() {
		  if(INSTANCE == null) {
			  synchronized(ConnectionUtil.class) {
				  if(INSTANCE == null)
					  INSTANCE = new ConnectionUtil();
			  }
		  }
		  return INSTANCE;
	  }
	  
	  private ConnectionUtil() {
		  this.connect();
	  }
	  
	  private void connect() {
		  Repository repository = new HTTPRepository(GRAPHDB_SERVER, REPOSITORY_ID);
		  repository.initialize();
		  this.connection = repository.getConnection();  
	  }
	  
}
