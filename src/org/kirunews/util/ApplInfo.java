package org.kirunews.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ApplInfo {
	
	private static List<Repository> repositories = new ArrayList<Repository>();
	
	public static void init(File binDir) {
		String configFileName = "megarep.properties";
		File configFile = new File(binDir, configFileName);
		if (!configFile.exists()) {
			System.err.println("Config file " + configFile.getAbsolutePath() + " does not exists");
			return;
		}
		
		PropertiesConfiguration props;
		try {
			try {
				props = new PropertiesConfiguration(configFile);
			}
			catch (ConfigurationException e) {
				System.err.println(e.getMessage());
				return;
			}
			String[] services = (String[]) props.getStringArray("services");
			
			for (String service : services) {
				String openSearchURL = (String)props.getProperty(service + ".openSearchURL");
				String url = (String)props.getProperty(service + ".url");
				Repository repository = new Repository(service, openSearchURL, url);
				System.out.println("Registering service " + repository.getName());
				ApplInfo.repositories.add(repository);
			}
		}
		catch(Exception e) {
			System.err.println("ERROR " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static List<Repository> getRepositories() {
		return repositories;
	}
}
