package com.api_ontology.convertion.api_ontology.owlApi;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

import com.api_ontology.convertion.api_ontology.dao.CarsFileAccess;
import com.api_ontology.convertion.api_ontology.entity.Vehicle;

public class CarsOntology extends Ontology {
	
	public static final String FILE_PATH= System.getProperty("user.dir")+ File.separator+"onto"+ File.separator+"test.owl";


	public CarsOntology() {
		super();
	}
	
	public static void main(String []args) {
		df = create();
		// Vehicle subClasses : 
		OWLClass vehicle = createClass(df, "Vehicle");
		OWLClass car = createClass(df, "Car");
		OWLClass motorizedBicycle = createClass(df, "MotorizedBicycle");
		OWLClass motorCycle = createClass(df, "MotorCycle");
		addSubClass(df, car, vehicle);
		addSubClass(df, motorizedBicycle, vehicle);
		addSubClass(df, motorCycle, vehicle);
		// Car dataProperties : 
		OWLDataProperty hasComercrcialSpecification = addDataProperty(df, "hasComercrcialSpecification");
		OWLDataProperty hasYear = addDataProperty(df, "hasYear");
		OWLDataProperty hasNvic = addDataProperty(df, "hasNvic");
		OWLDataProperty hasV9Field = addDataProperty(df, "hasV9Field");
		OWLDataProperty hasFolderModel = addDataProperty(df, "hasFolderModel");
		OWLDataProperty hasUtacModel = addDataProperty(df, "hasUTACModel");
		OWLDataProperty hasEngine = addDataProperty(df, "hasEngine");
		OWLDataProperty hasMaximumPower = addDataProperty(df, "hasMaximumPower");
		OWLDataProperty hasAdministrativePower = addDataProperty(df, "hasAdministrativePower");
		OWLDataProperty hasMaxEmptyMassKg = addDataProperty(df, "hasMaxEmptyMassKg");
		OWLDataProperty hasMinEmptyMassKg = addDataProperty(df, "hasMinEmptyMassKg");
		OWLDataProperty hasUrbanConsumptionL100Km = addDataProperty(df, "hasUrbanConsumptionL100Km");
		OWLDataProperty hasExtraUrbanConsumptionL100Km = addDataProperty(df, "hasExtraUrbanConsumptionL100Km");
		OWLDataProperty hasMixedConsumptionL100Km = addDataProperty(df, "hasMixedConsumptionL100Km");
		OWLDataProperty hasCOTypeIGKm = addDataProperty(df, "hasCOTypeIGKm");
		OWLDataProperty hasCO2GKm = addDataProperty(df, "hasCO2GKm");
		OWLDataProperty hasHCNoxGKm = addDataProperty(df, "hasHCNoxGKm");
		OWLDataProperty hasNoxGKm = addDataProperty(df, "hasNoxGKm");
		OWLDataProperty hasParticlesGKm = addDataProperty(df, "hasParticlesGKm");
		
		// Brand : 
		OWLClass brand = createClass(df, "Brand");
		OWLObjectProperty hasBrand = addObjectProperty(df, "hasBrand");
		addDomainRange(df, car, brand, hasBrand);
		// CarRange : 
		OWLClass carRange = createClass(df, "CarRange");
		OWLObjectProperty hasRange = addObjectProperty(df, "hasRange");
		addDomainRange(df, car, carRange, hasRange);
		// Fuel : 
		OWLClass fuel = createClass(df, "Fuel");
		OWLObjectProperty hasFuel = addObjectProperty(df, "hasFuel");
		addDomainRange(df, car, fuel, hasFuel);
		// CarPart subClasses : 
		OWLClass carPart = createClass(df, "CarPart");		
		OWLClass body = createClass(df, "Body");
		OWLClass gearbox = createClass(df, "Gearbox");
		addSubClass(df, body, carPart);
		addSubClass(df, gearbox, carPart);
		OWLObjectProperty hasCarPart = addObjectProperty(df, "hasCarPart");
		addDomainRange(df, car, carPart, hasCarPart);
		OWLObjectProperty hasBody = addObjectProperty(df, "hasBody");
		addDomainRange(df, car, body, hasBody);
		OWLObjectProperty hasGearbox = addObjectProperty(df, "hasGearbox");
		addDomainRange(df, car, gearbox, hasGearbox);
		addSubObjectProperty(df, hasBody, hasCarPart);
		addSubObjectProperty(df, hasGearbox, hasCarPart);		
		
		Collection<Vehicle> vehicules = CarsFileAccess.getCarsJson();
		HashMap<String, OWLIndividual> brandLst = new HashMap<String, OWLIndividual>();
		HashMap<String, OWLIndividual> fuelLst = new HashMap<String, OWLIndividual>();
		HashMap<String, OWLIndividual> carRangeLst = new HashMap<String, OWLIndividual>();
		HashMap<String, OWLIndividual> bodyLst = new HashMap<String, OWLIndividual>();
		HashMap<String, OWLIndividual> gearboxLst = new HashMap<String, OWLIndividual>();

		//ArrayList<String> gearboxLst = new ArrayList<String>();
		//ArrayList<String> bodyLst = new ArrayList<String>();
		vehicules.forEach((x) -> {
			String comersialSpecificationData = ((Vehicle)x).getDesignation_commerciale();
			String fuelData = ((Vehicle)x).getCarburant();
			String brandData = ((Vehicle)x).getMarque().replaceAll(" ", "_");
			String rangeData = ((Vehicle)x).getGamme();
			String gearboxData = ((Vehicle)x).getBoite_de_vitesse();
			String bodyData = ((Vehicle)x).getCarrosserie();
			
			int yearData = Integer.parseInt(((Vehicle)x).getAnnee());
			String folderModelData = ((Vehicle)x).getModele_dossier();
			String utacModelData = ((Vehicle)x).getModele_utac();
			String v9FieldData = ((Vehicle)x).getChamp_v9();
			String nvicData = ((Vehicle)x).getCnit();
			int maxEmptyMasskgData = ((Vehicle)x).getMasse_vide_euro_max_kg();
			int minEmptyMasskgData = ((Vehicle)x).getMasse_vide_euro_min_kg();
			int administrativePowerData = ((Vehicle)x).getPuissance_administrative();
			float maximumPowerData = ((Vehicle)x).getPuissance_maximale();
			String engineData = ((Vehicle)x).getHybride();
			float urbanConsumptionData = ((Vehicle)x).getConsommation_urbaine_l_100km();
			float extraUrbanConsumptionData = ((Vehicle)x).getConsommation_extra_urbaine_l_100km();
			float mixedConsumptionData = ((Vehicle)x).getConsommation_mixte_l_100km();
			float co2GKmData = ((Vehicle)x).getCo2_g_km();
			float coTypeIGKmData = ((Vehicle)x).getCo_type_i_g_km();
			float noxGKmData = ((Vehicle)x).getNox_g_km();
			float hcNoxGKmData = ((Vehicle)x).getHc_nox_g_km();
			float particlesGKmData = ((Vehicle)x).getParticules_g_km();
			
			
			comersialSpecificationData = comersialSpecificationData.replaceAll(" ", "_")
					.replaceAll("\"", "")
					.replaceAll("/", "")
					.replaceAll("\\+", "")
					.replaceAll("\\*", "")
					.replaceAll("-", "")
					.replaceAll("\\.", "")
					.replaceAll("\\)", "")
					.replaceAll("\\(", "")
					.replaceAll("\\[", "_")
					.replaceAll("\\]", "_")
					.replaceAll("\\#", "_")
					.replaceAll(",", "");
			OWLIndividual individual = addIndividual(df, car, comersialSpecificationData);
			
			// Data Properties : 
			insertDataProperty(df, hasComercrcialSpecification, individual, df.getOWLLiteral(comersialSpecificationData, OWL2Datatype.XSD_STRING));
			insertDataProperty(df, hasYear, individual, df.getOWLLiteral((new Integer(yearData)).toString(), OWL2Datatype.XSD_INTEGER));
			insertDataProperty(df, hasFolderModel, individual, df.getOWLLiteral(folderModelData, OWL2Datatype.XSD_STRING));
			insertDataProperty(df, hasUtacModel, individual, df.getOWLLiteral(utacModelData, OWL2Datatype.XSD_STRING));
			if(v9FieldData!=null)
				insertDataProperty(df, hasV9Field, individual, df.getOWLLiteral(v9FieldData, OWL2Datatype.XSD_STRING));
			if(nvicData!=null)
				insertDataProperty(df, hasNvic, individual, df.getOWLLiteral(nvicData, OWL2Datatype.XSD_STRING));
			if(engineData!=null)
				insertDataProperty(df, hasEngine, individual, df.getOWLLiteral(fuelData, OWL2Datatype.XSD_STRING));
			if(administrativePowerData!=0)
				insertDataProperty(df, hasAdministrativePower, individual, df.getOWLLiteral(String.valueOf(administrativePowerData), OWL2Datatype.XSD_INTEGER));
			if(maximumPowerData!=0)
				insertDataProperty(df, hasMaximumPower, individual, df.getOWLLiteral(String.valueOf(maximumPowerData), OWL2Datatype.XSD_FLOAT));
			if(maxEmptyMasskgData!=0)
				insertDataProperty(df, hasMaxEmptyMassKg, individual, df.getOWLLiteral(String.valueOf(maxEmptyMasskgData), OWL2Datatype.XSD_FLOAT));
			if(minEmptyMasskgData!=0)
				insertDataProperty(df, hasMinEmptyMassKg, individual, df.getOWLLiteral(String.valueOf(minEmptyMasskgData), OWL2Datatype.XSD_FLOAT));
			if(urbanConsumptionData!=0)
				insertDataProperty(df, hasUrbanConsumptionL100Km, individual, df.getOWLLiteral(String.valueOf(urbanConsumptionData), OWL2Datatype.XSD_FLOAT));
			if(extraUrbanConsumptionData!=0)
				insertDataProperty(df, hasExtraUrbanConsumptionL100Km, individual, df.getOWLLiteral(String.valueOf(extraUrbanConsumptionData), OWL2Datatype.XSD_FLOAT));
			if(mixedConsumptionData!=0)
				insertDataProperty(df, hasMixedConsumptionL100Km, individual, df.getOWLLiteral(String.valueOf(mixedConsumptionData), OWL2Datatype.XSD_FLOAT));
			if(co2GKmData!=0)
				insertDataProperty(df, hasCO2GKm, individual, df.getOWLLiteral(String.valueOf(co2GKmData), OWL2Datatype.XSD_FLOAT));
			if(coTypeIGKmData!=0)
				insertDataProperty(df, hasCOTypeIGKm, individual, df.getOWLLiteral(String.valueOf(coTypeIGKmData), OWL2Datatype.XSD_FLOAT));
			if(noxGKmData!=0)
				insertDataProperty(df, hasNoxGKm, individual, df.getOWLLiteral(String.valueOf(noxGKmData), OWL2Datatype.XSD_FLOAT));
			if(hcNoxGKmData!=0)
				insertDataProperty(df, hasHCNoxGKm, individual, df.getOWLLiteral(String.valueOf(hcNoxGKmData), OWL2Datatype.XSD_FLOAT));
			if(particlesGKmData!=0)
				insertDataProperty(df, hasParticlesGKm, individual, df.getOWLLiteral(String.valueOf(particlesGKmData), OWL2Datatype.XSD_FLOAT));
			
			
			// Object Properties : 
			if(!brandLst.containsKey(new String(brandData)))
				brandLst.put(new String(brandData), addIndividual(df, brand, brandData));
			insertObjectProperty(df, hasBrand, individual, brandLst.get(brandData));
			if(fuelData!=null) {
				fuelData = fuelData.replaceAll(" ", "_");
				if(!fuelLst.containsKey(new String(fuelData)))
					fuelLst.put(new String(fuelData), addIndividual(df, fuel, fuelData));
				insertObjectProperty(df, hasFuel, individual, fuelLst.get(fuelData));
			}
			if(rangeData!=null) {
				rangeData = rangeData.replaceAll(" ", "_");
				if(!carRangeLst.containsKey(new String(rangeData)))
					carRangeLst.put(new String(rangeData), addIndividual(df, carRange, rangeData));
				insertObjectProperty(df, hasRange, individual, carRangeLst.get(rangeData));
			}
			if(bodyData!=null) {
				bodyData = bodyData.replaceAll(" ", "_");
				if(!bodyLst.containsKey(new String(bodyData)))
					bodyLst.put(new String(bodyData), addIndividual(df, body, bodyData));
				insertObjectProperty(df, hasBody, individual, bodyLst.get(bodyData));
			}
			if(gearboxData!=null) {
				gearboxData = gearboxData.replaceAll(" ", "_");
				if(!gearboxLst.containsKey(new String(gearboxData)))
					gearboxLst.put(new String(gearboxData), addIndividual(df, gearbox, gearboxData));
				insertObjectProperty(df, hasGearbox, individual, gearboxLst.get(gearboxData));
			}
			
			
			
		});

		
		saveToFile(FILE_PATH);
		
	}
	
}
