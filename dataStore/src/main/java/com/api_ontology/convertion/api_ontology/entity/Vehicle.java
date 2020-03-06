package com.api_ontology.convertion.api_ontology.entity;
 
public class Vehicle {
	
	private String modele_dossier;
	private float co_type_i_g_km; // 
	private float nox_g_km; //
	private int puissance_administrative;
	private String annee;
	private String carburant;
	private String marque;
	private String designation_commerciale;
	private float consommation_mixte_l_100km;
	private float consommation_urbaine_l_100km;
	private float particules_g_km; //
	private int masse_vide_euro_max_kg;
	private String modele_utac;
	private String hybride;
	private String champ_v9;
	private float co2_g_km; //
	private String boite_de_vitesse;
	private int masse_vide_euro_min_kg;
	private String type_variante_version_tvv;
	private String cnit;
	private float consommation_extra_urbaine_l_100km;
	private float hc_nox_g_km; //
	private float puissance_maximale;
	private String carrosserie;
	private String gamme;
	
	public Vehicle(String modele_dossier, float co_type_i_g_km, float nox_g_km, int puissance_administrative,
                   String annee, String carburant, String marque, String designation_commerciale,
                   float consommation_mixte_l_100km, float consommation_urbaine_l_100km, float particules_g_km,
                   int masse_vide_euro_max_kg, String modele_utac, String hybride, String champ_v9, float co2_g_km,
                   String boite_de_vitesse, int masse_vide_euro_min_kg, String type_variante_version_tvv, String cnit,
                   float consommation_extra_urbaine_l_100km, float hc_nox_g_km, float puissance_maximale, String carrosserie,
                   String gamme) {
		super();
		this.modele_dossier = modele_dossier;
		this.co_type_i_g_km = co_type_i_g_km;
		this.nox_g_km = nox_g_km;
		this.puissance_administrative = puissance_administrative;
		this.annee = annee;
		this.carburant = carburant;
		this.marque = marque;
		this.designation_commerciale = designation_commerciale;
		this.consommation_mixte_l_100km = consommation_mixte_l_100km;
		this.consommation_urbaine_l_100km = consommation_urbaine_l_100km;
		this.particules_g_km = particules_g_km;
		this.masse_vide_euro_max_kg = masse_vide_euro_max_kg;
		this.modele_utac = modele_utac;
		this.hybride = hybride;
		this.champ_v9 = champ_v9;
		this.co2_g_km = co2_g_km;
		this.boite_de_vitesse = boite_de_vitesse;
		this.masse_vide_euro_min_kg = masse_vide_euro_min_kg;
		this.type_variante_version_tvv = type_variante_version_tvv;
		this.cnit = cnit;
		this.consommation_extra_urbaine_l_100km = consommation_extra_urbaine_l_100km;
		this.hc_nox_g_km = hc_nox_g_km;
		this.puissance_maximale = puissance_maximale;
		this.carrosserie = carrosserie;
		this.gamme = gamme;
	}

	public String getModele_dossier() {
		return modele_dossier;
	}

	public void setModele_dossier(String modele_dossier) {
		this.modele_dossier = modele_dossier;
	}

	public float getCo_type_i_g_km() {
		return co_type_i_g_km;
	}

	public void setCo_type_i_g_km(float co_type_i_g_km) {
		this.co_type_i_g_km = co_type_i_g_km;
	}

	public float getNox_g_km() {
		return nox_g_km;
	}

	public void setNox_g_km(float nox_g_km) {
		this.nox_g_km = nox_g_km;
	}

	public int getPuissance_administrative() {
		return puissance_administrative;
	}

	public void setPuissance_administrative(int puissance_administrative) {
		this.puissance_administrative = puissance_administrative;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getDesignation_commerciale() {
		return designation_commerciale;
	}

	public void setDesignation_commerciale(String designation_commerciale) {
		this.designation_commerciale = designation_commerciale;
	}

	public float getConsommation_mixte_l_100km() {
		return consommation_mixte_l_100km;
	}

	public void setConsommation_mixte_l_100km(float consommation_mixte_l_100km) {
		this.consommation_mixte_l_100km = consommation_mixte_l_100km;
	}

	public float getConsommation_urbaine_l_100km() {
		return consommation_urbaine_l_100km;
	}

	public void setConsommation_urbaine_l_100km(float consommation_urbaine_l_100km) {
		this.consommation_urbaine_l_100km = consommation_urbaine_l_100km;
	}

	public float getParticules_g_km() {
		return particules_g_km;
	}

	public void setParticules_g_km(float particules_g_km) {
		this.particules_g_km = particules_g_km;
	}

	public int getMasse_vide_euro_max_kg() {
		return masse_vide_euro_max_kg;
	}

	public void setMasse_vide_euro_max_kg(int masse_vide_euro_max_kg) {
		this.masse_vide_euro_max_kg = masse_vide_euro_max_kg;
	}

	public String getModele_utac() {
		return modele_utac;
	}

	public void setModele_utac(String modele_utac) {
		this.modele_utac = modele_utac;
	}

	public String getHybride() {
		return hybride;
	}

	public void setHybride(String hybride) {
		this.hybride = hybride;
	}

	public String getChamp_v9() {
		return champ_v9;
	}

	public void setChamp_v9(String champ_v9) {
		this.champ_v9 = champ_v9;
	}

	public float getCo2_g_km() {
		return co2_g_km;
	}

	public void setCo2_g_km(float co2_g_km) {
		this.co2_g_km = co2_g_km;
	}

	public String getBoite_de_vitesse() {
		return boite_de_vitesse;
	}

	public void setBoite_de_vitesse(String boite_de_vitesse) {
		this.boite_de_vitesse = boite_de_vitesse;
	}

	public int getMasse_vide_euro_min_kg() {
		return masse_vide_euro_min_kg;
	}

	public void setMasse_vide_euro_min_kg(int masse_vide_euro_min_kg) {
		this.masse_vide_euro_min_kg = masse_vide_euro_min_kg;
	}

	public String getType_variante_version_tvv() {
		return type_variante_version_tvv;
	}

	public void setType_variante_version_tvv(String type_variante_version_tvv) {
		this.type_variante_version_tvv = type_variante_version_tvv;
	}

	public String getCnit() {
		return cnit;
	}

	public void setCnit(String cnit) {
		this.cnit = cnit;
	}

	public float getConsommation_extra_urbaine_l_100km() {
		return consommation_extra_urbaine_l_100km;
	}

	public void setConsommation_extra_urbaine_l_100km(float consommation_extra_urbaine_l_100km) {
		this.consommation_extra_urbaine_l_100km = consommation_extra_urbaine_l_100km;
	}

	public float getHc_nox_g_km() {
		return hc_nox_g_km;
	}

	public void setHc_nox_g_km(float hc_nox_g_km) {
		this.hc_nox_g_km = hc_nox_g_km;
	}

	public float getPuissance_maximale() {
		return puissance_maximale;
	}

	public void setPuissance_maximale(float puissance_maximale) {
		this.puissance_maximale = puissance_maximale;
	}

	public String getCarrosserie() {
		return carrosserie;
	}

	public void setCarrosserie(String carrosserie) {
		this.carrosserie = carrosserie;
	}

	public String getGamme() {
		return gamme;
	}

	public void setGamme(String gamme) {
		this.gamme = gamme;
	}
	
	@Override
	public String toString() {/*
		return "Vehicle [modele_dossier=" + modele_dossier + ", co_type_i_g_km=" + co_type_i_g_km + ", nox_g_km="
				+ nox_g_km + ", puissance_administrative=" + puissance_administrative + ", annee=" + annee
				+ ", carburant=" + carburant + ", marque=" + marque + ", designation_commerciale="
				+ designation_commerciale + ", consommation_mixte_l_100km=" + consommation_mixte_l_100km
				+ ", consommation_urbaine_l_100km=" + consommation_urbaine_l_100km + ", particules_g_km="
				+ particules_g_km + ", masse_vide_euro_max_kg=" + masse_vide_euro_max_kg + ", modele_utac="
				+ modele_utac + ", hybride=" + hybride + ", champ_v9=" + champ_v9 + ", co2_g_km=" + co2_g_km
				+ ", boite_de_vitesse=" + boite_de_vitesse + ", masse_vide_euro_min_kg=" + masse_vide_euro_min_kg
				+ ", type_variante_version_tvv=" + type_variante_version_tvv + ", cnit=" + cnit
				+ ", consommation_extra_urbaine_l_100km=" + consommation_extra_urbaine_l_100km + ", hc_nox_g_km="
				+ hc_nox_g_km + ", puissance_maximale=" + puissance_maximale + ", carrosserie=" + carrosserie
				+ ", gamme=" + gamme + "]";*/
		return " -> "+designation_commerciale; 
	}	

	  
	
}
