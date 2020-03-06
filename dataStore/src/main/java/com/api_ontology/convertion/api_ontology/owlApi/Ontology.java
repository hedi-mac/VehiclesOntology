package com.api_ontology.convertion.api_ontology.owlApi;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;


public class Ontology {
	
	public static final String iriString = "http://www.carontology.com/test";
	public static final IRI iri = IRI.create(iriString);
	public static OWLDataFactory df;
	public static OWLOntology o;
	public static OWLOntologyManager man;
	
	public static OWLDataFactory create() {
		man = OWLManager.createOWLOntologyManager();
		try {
			o = man.createOntology();
			return o.getOWLOntologyManager().getOWLDataFactory();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void saveToFile(String filePath) {
		OWLOntologyManager man = OWLManager.createOWLOntologyManager();
		File file = new File(filePath);
		try {
			man.setOntologyFormat(o, o.getFormat());
			man.saveOntology(o, IRI.create(file.toURI()));
			System.out.println("Axioms : "+o.getAxiomCount()+", \nFormat : "+man.getOntologyFormat(o));
		} catch (OWLOntologyStorageException e) {
			e.printStackTrace();
		}
	}
	
	public static OWLClass createClass(OWLDataFactory df, String name) {
		OWLClass c = df.getOWLClass(iri+"#"+name);
		OWLDeclarationAxiom dec = df.getOWLDeclarationAxiom(c);
		man.addAxiom(o, dec);
		return c;
	}
	
	public static OWLObjectProperty createObjectProperty(OWLDataFactory df, String name) {
		OWLObjectProperty p = df.getOWLObjectProperty(iri+"#"+name);
		OWLDeclarationAxiom dec = df.getOWLDeclarationAxiom(p);
		man.addAxiom(o, dec);
		return p;
	}
	
	public static void addDomainRange(OWLDataFactory df, OWLClass domain, OWLClass range, OWLObjectProperty property) {
		OWLObjectPropertyDomainAxiom domainAxiom = df.getOWLObjectPropertyDomainAxiom(property, domain);
        OWLObjectPropertyRangeAxiom   rangeAxiom = df.getOWLObjectPropertyRangeAxiom( property, range);
		man.addAxiom(o, domainAxiom);
		man.addAxiom(o, rangeAxiom);
	}
	
	public static void addSubClass(OWLDataFactory df, OWLClass x, OWLClass y) {
    	OWLSubClassOfAxiom ax = df.getOWLSubClassOfAxiom(x, y);
		man.addAxiom(o,ax);
	}

	public static OWLIndividual addIndividual(OWLDataFactory df, OWLClass x, String ind) {
		OWLIndividual individual = df.getOWLNamedIndividual(IRI.create(iriString+"#"+ind));
		OWLClassAssertionAxiom assertion = df.getOWLClassAssertionAxiom(x, individual);
		man.addAxiom(o,assertion);
		return individual;
	}
	
	public static OWLDataProperty addDataProperty(OWLDataFactory df, String name) {
		OWLDataProperty dataProperty = df.getOWLDataProperty(iri+"#"+name);
		OWLAxiom a = df.getOWLDeclarationAxiom(dataProperty);
		man.addAxiom(o,a);
		return dataProperty;
	}
	
	public static OWLObjectProperty addObjectProperty(OWLDataFactory df, String name) {
		OWLObjectProperty objectProperty = df.getOWLObjectProperty(IRI.create(iriString+"#"+name));
		OWLAxiom a = df.getOWLDeclarationAxiom(objectProperty);
		man.addAxiom(o,a);
		return objectProperty;
	}
	
	public static void assignObjectAllValuesFrom(OWLDataFactory df, OWLObjectPropertyExpression p, OWLClass a, OWLClass b) {
		OWLClassExpression definition = df.getOWLObjectAllValuesFrom(p, b);
		OWLSubClassOfAxiom ax = df.getOWLSubClassOfAxiom(a, definition);
		man.addAxiom(o,ax);
	}

	public static void assignObjectSomeValuesFrom(OWLDataFactory df, OWLObjectPropertyExpression p, OWLClass a, OWLClass b) {
		OWLClassExpression definition = df.getOWLObjectSomeValuesFrom(p, b);
		OWLSubClassOfAxiom ax = df.getOWLSubClassOfAxiom(a, definition);
		man.addAxiom(o,ax);
	}
	
	public static void addSubObjectProperty(OWLDataFactory df, OWLObjectPropertyExpression a, OWLObjectPropertyExpression b) {
		OWLSubObjectPropertyOfAxiom ax = df.getOWLSubObjectPropertyOfAxiom(a, b);
		man.addAxiom(o,ax);
	}
	
	public static void insertDataProperty(OWLDataFactory df, OWLDataProperty dataProperty, OWLIndividual individual, OWLLiteral label) {
		OWLDataPropertyAssertionAxiom dataPropertyAssertion = df.getOWLDataPropertyAssertionAxiom(dataProperty, individual, label);
		man.addAxiom(o, dataPropertyAssertion);
	}
	
	public static void insertObjectProperty(OWLDataFactory df, OWLObjectProperty objectProperty, OWLIndividual individual, OWLIndividual object) {
		OWLObjectPropertyAssertionAxiom objectPropertyAssertion = df.getOWLObjectPropertyAssertionAxiom(objectProperty, individual, object);
		man.addAxiom(o, objectPropertyAssertion);
	}
	
}
