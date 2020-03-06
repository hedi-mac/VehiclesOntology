package com.cars.ontology.util;

import org.eclipse.rdf4j.query.*;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;

/**
 * Utility methods for executing updates.
 */
public class UpdateUtil {

    public static void executeUpdate(RepositoryConnection repositoryConnection, String update, Binding... bindings)
            throws MalformedQueryException, RepositoryException, UpdateExecutionException {
        Update preparedUpdate = repositoryConnection.prepareUpdate(QueryLanguage.SPARQL, update);
        // Setting any potential bindings (query parameters)
        for (Binding b : bindings) {
            preparedUpdate.setBinding(b.getName(), b.getValue());
        }
        preparedUpdate.execute();
    }

    public static void executeUpdateInTransaction(RepositoryConnection repositoryConnection, String update,
                                                  Binding... bindings)
            throws MalformedQueryException, RepositoryException, UpdateExecutionException {
        repositoryConnection.begin();

        executeUpdate(repositoryConnection, update, bindings);

        repositoryConnection.commit();
    }

}
