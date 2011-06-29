package org.kirunews.util;

/**
 * Bean for repository. A repository is a megarep opensearch implementator.
 * It has an URL for the OpenSearch service and a name, plus an URL for
 * the web site.
 * @author kiru
 *
 */
public class Repository {

	private String name;
	private String URL;
	private String openSearchURL;
	
	public Repository(String name, String openSearchURL, String url) {
		super();
		this.name = name;
		this.openSearchURL = openSearchURL;
		this.URL = url;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		URL = url;
	}

	/**
	 * @param openSearchURL the openSearchURL to set
	 */
	public void setOpenSearchURL(String openSearchURL) {
		this.openSearchURL = openSearchURL;
	}

	/**
	 * @return the openSearchURL
	 */
	public String getOpenSearchURL() {
		return openSearchURL;
	}
}
