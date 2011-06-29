package org.kirunews.struts.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 03-17-2009
 * 
 * XDoclet definition:
 * @struts.form name="searchForm"
 */
public class SearchForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 526527393974497510L;
	
	private String baseURL;

	/** meter property */
	private String meter;

	/** metrikaIdomertekes property */
	private String meter_qualifier;

	/** segmentation property */
	private String segmentation;

	/** segmentation_qualifier property */
	private String segmentation_qualifier;

	/** rhyme property */
	private String rhyme;

	/** rhyme_qualifier property */
	private String rhyme_qualifier;

	/** rhyme_scheme property */
	private String rhyme_scheme;

	/** metrical_scheme property */
	private String metrical_scheme;

	private String declination_line;
	private String declination_strophe;
	private String declination_scheme;
	
	private int number_of_lines;
	private int number_of_strophes;
	
	private String author;
	private String date;
	private String date_qualifier;
	private String melody;
	private String melody_qualifier;

	private String genre;
	private String caesuras;
	private String[] language;
	private String language_qualifier;
	private String refrain;
	private String refrain_qualifier;

	private String interior_generic_designation;
	private String exterior_contemporary_generic_designation;
	private String[] interstrophical_relations_level1;
	private String interstrophical_relations_level1_note;
	private String[] interstrophical_relations_level2;
	private String interstrophical_relations_level2_note;
	
	private String query;
	private String results;
	private String error;
	private int totalResults;
	private int startIndex = 1;
	private int endIndex;
	private int itemsPerPage;
	private List<String> servers = new ArrayList<String>();
	private String navigationLine;
	
	private Map<String, String> languages;
	
	/*
	 * Generated Methods
	 */

	public String getDeclination_line() {
		return declination_line;
	}

	public void setDeclination_line(String declination_line) {
		this.declination_line = declination_line;
	}

	public String getDeclination_strophe() {
		return declination_strophe;
	}

	public void setDeclination_strophe(String declination_strophe) {
		this.declination_strophe = declination_strophe;
	}

	public String getDeclination_scheme() {
		return declination_scheme;
	}

	public void setDeclination_scheme(String declination_scheme) {
		this.declination_scheme = declination_scheme;
	}

	public int getNumber_of_lines() {
		return number_of_lines;
	}

	public void setNumber_of_lines(int number_of_lines) {
		this.number_of_lines = number_of_lines;
	}

	public int getNumber_of_strophes() {
		return number_of_strophes;
	}

	public void setNumber_of_strophes(int number_of_strophes) {
		this.number_of_strophes = number_of_strophes;
	}

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the segmentation_qualifier.
	 * @return String
	 */
	public String getSegmentation_qualifier() {
		return segmentation_qualifier;
	}

	/** 
	 * Set the segmentation_qualifier.
	 * @param segmentation_qualifier The segmentation_qualifier to set
	 */
	public void setSegmentation_qualifier(String segmentation_qualifier) {
		this.segmentation_qualifier = segmentation_qualifier;
	}

	/** 
	 * Returns the meter_qualifier.
	 * @return String
	 */
	public String getMeter_qualifier() {
		return meter_qualifier;
	}

	/** 
	 * Set the meter_qualifier.
	 * @param meter_qualifier The meter_qualifier to set
	 */
	public void setMeter_qualifier(String meter_qualifier) {
		this.meter_qualifier = meter_qualifier;
	}

	/** 
	 * Returns the metrical_scheme.
	 * @return String
	 */
	public String getMetrical_scheme() {
		return metrical_scheme;
	}

	/** 
	 * Set the metrical_scheme.
	 * @param metrical_scheme The metrical_scheme to set
	 */
	public void setMetrical_scheme(String metrical_scheme) {
		this.metrical_scheme = metrical_scheme;
	}

	/** 
	 * Returns the rhyme.
	 * @return String
	 */
	public String getRhyme() {
		return rhyme;
	}

	/** 
	 * Set the rhyme.
	 * @param rhyme The rhyme to set
	 */
	public void setRhyme(String rhyme) {
		this.rhyme = rhyme;
	}

	/** 
	 * Returns the meter.
	 * @return String
	 */
	public String getMeter() {
		return meter;
	}

	/** 
	 * Set the meter.
	 * @param metrika The meter to set
	 */
	public void setMeter(String meter) {
		this.meter = meter;
	}

	/** 
	 * Returns the rhyme_qualifier.
	 * @return String
	 */
	public String getRhyme_qualifier() {
		return rhyme_qualifier;
	}

	/** 
	 * Set the rhyme_qualifier.
	 * @param rhyme_qualifier The rhyme_qualifier to set
	 */
	public void setRhyme_qualifier(String rhyme_qualifier) {
		this.rhyme_qualifier = rhyme_qualifier;
	}

	/** 
	 * Returns the segmentation.
	 * @return String
	 */
	public String getSegmentation() {
		return segmentation;
	}

	/** 
	 * Set the segmentation.
	 * @param segmentation The segmentation to set
	 */
	public void setSegmentation(String segmentation) {
		this.segmentation = segmentation;
	}

	/** 
	 * Returns the rhyme_scheme.
	 * @return String
	 */
	public String getRhyme_scheme() {
		return rhyme_scheme;
	}

	/** 
	 * Set the rhyme_scheme.
	 * @param rhyme_scheme The rhyme scheme to set
	 */
	public void setRhyme_scheme(String rhyme_scheme ) {
		this.rhyme_scheme = rhyme_scheme;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate_qualifier() {
		return date_qualifier;
	}

	public void setDate_qualifier(String date_qualifier) {
		this.date_qualifier = date_qualifier;
	}

	public String getMelody() {
		return melody;
	}

	public void setMelody(String melody) {
		this.melody = melody;
	}
	
	public String getMelody_qualifier() {
		return melody_qualifier;
	}

	public void setMelody_qualifier(String melody_qualifier) {
		this.melody_qualifier = melody_qualifier;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCaesuras() {
		return caesuras;
	}

	public void setCaesuras(String caesuras) {
		this.caesuras = caesuras;
	}

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}

	public Map<String, String> getLanguages() {
		return languages;
	}

	public void setLanguages(Map<String, String> languages) {
		this.languages = languages;
	}

	public String getLanguage_qualifier() {
		return language_qualifier;
	}

	public void setLanguage_qualifier(String language_qualifier) {
		this.language_qualifier = language_qualifier;
	}
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	public void addServer(String server) {
		this.servers.add(server);
	}

	public String getNavigationLine() {
		return navigationLine;
	}

	public void setNavigationLine(String navigationLine) {
		this.navigationLine = navigationLine;
	}

	/**
	 * @param interior_generic_designation the interior_generic_designation to set
	 */
	public void setInterior_generic_designation(
			String interior_generic_designation) {
		this.interior_generic_designation = interior_generic_designation;
	}

	/**
	 * @return the interior_generic_designation
	 */
	public String getInterior_generic_designation() {
		return interior_generic_designation;
	}

	public String getExterior_contemporary_generic_designation() {
		return exterior_contemporary_generic_designation;
	}

	public void setExterior_contemporary_generic_designation(
			String exterior_contemporary_generic_designation) {
		this.exterior_contemporary_generic_designation = exterior_contemporary_generic_designation;
	}

	/**
	 * @param refrain the refrain to set
	 */
	public void setRefrain(String refrain) {
		this.refrain = refrain;
	}

	/**
	 * @return the refrain
	 */
	public String getRefrain() {
		return refrain;
	}

	/**
	 * @param refrain_qualifier the refrain_qualifier to set
	 */
	public void setRefrain_qualifier(String refrain_qualifier) {
		this.refrain_qualifier = refrain_qualifier;
	}

	/**
	 * @return the refrain_qualifier
	 */
	public String getRefrain_qualifier() {
		return refrain_qualifier;
	}

	/**
	 * @param interstrophical_relations_level1 the interstrophical_relations_level1 to set
	 */
	public void setInterstrophical_relations_level1(
			String[] interstrophical_relations_level1) {
		this.interstrophical_relations_level1 = interstrophical_relations_level1;
	}

	/**
	 * @return the interstrophical_relations_level1
	 */
	public String[] getInterstrophical_relations_level1() {
		return interstrophical_relations_level1;
	}

	/**
	 * @param interstrophical_relations_level1_note the interstrophical_relations_level1_note to set
	 */
	public void setInterstrophical_relations_level1_note(
			String interstrophical_relations_level1_note) {
		this.interstrophical_relations_level1_note = interstrophical_relations_level1_note;
	}

	/**
	 * @return the interstrophical_relations_level1_note
	 */
	public String getInterstrophical_relations_level1_note() {
		return interstrophical_relations_level1_note;
	}

	/**
	 * @param interstrophical_relations_level2 the interstrophical_relations_level2 to set
	 */
	public void setInterstrophical_relations_level2(
			String[] interstrophical_relations_level2) {
		this.interstrophical_relations_level2 = interstrophical_relations_level2;
	}

	/**
	 * @return the interstrophical_relations_level2
	 */
	public String[] getInterstrophical_relations_level2() {
		return interstrophical_relations_level2;
	}

	/**
	 * @param interstrophical_relations_level2_note the interstrophical_relations_level2_note to set
	 */
	public void setInterstrophical_relations_level2_note(
			String interstrophical_relations_level2_note) {
		this.interstrophical_relations_level2_note = interstrophical_relations_level2_note;
	}

	/**
	 * @return the interstrophical_relations_level2_note
	 */
	public String getInterstrophical_relations_level2_note() {
		return interstrophical_relations_level2_note;
	}
}