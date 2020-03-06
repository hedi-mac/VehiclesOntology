package com.cars.ontology.util;

import org.eclipse.rdf4j.query.*;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;

/**
 * Utility class for evaluating SPARQL queries.
 */
public class QueryUtil {

    public static Query prepareQuery(RepositoryConnection connection, String query)
            throws MalformedQueryException, RepositoryException {
        return connection.prepareQuery(QueryLanguage.SPARQL, query);
    }


    public static TupleQueryResult evaluateSelectQuery(RepositoryConnection connection, String query,
                                                       Binding... bindings)
            throws MalformedQueryException, RepositoryException, QueryEvaluationException {
        // Preparing a new query
        TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, query);

        // Setting any potential bindings (query parameters)
        for (Binding b : bindings) {
            tupleQuery.setBinding(b.getName(), b.getValue());
        }

        // Sending the query to GraphDB, evaluating it and returning the result
        return tupleQuery.evaluate();
    }


    public static GraphQueryResult evaluateConstructQuery(RepositoryConnection connection, String query,
                                                          Binding... bindings)
            throws MalformedQueryException, RepositoryException, QueryEvaluationException {
        // Preparing a new query
        GraphQuery graphdQuery = connection.prepareGraphQuery(QueryLanguage.SPARQL, query);

        // Setting any potential bindings (query parameters)
        for (Binding b : bindings) {
            graphdQuery.setBinding(b.getName(), b.getValue());
        }

        // Sending the query to GraphDB, evaluating it and returning the result
        return graphdQuery.evaluate();
    }


    public static boolean evaluateAskQuery(RepositoryConnection connection, String query, Binding... bindings)
            throws MalformedQueryException, RepositoryException, QueryEvaluationException {
        // Preparing a new query
        BooleanQuery booleanQuery = connection.prepareBooleanQuery(QueryLanguage.SPARQL, query);

        // Setting any potential bindings (query parameters)
        for (Binding b : bindings) {
            booleanQuery.setBinding(b.getName(), b.getValue());
        }

        // Sending the query to GraphDB and evaluating it
        return booleanQuery.evaluate();
    }
}
