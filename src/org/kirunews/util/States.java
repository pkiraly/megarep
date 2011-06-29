package org.kirunews.util;

import java.util.Map;
import java.util.TreeMap;

public class States {
	private static Map<String, String> states = new TreeMap<String, String>();
	
	static {
		states.put("AK", "Alaska");
		states.put("AL", "Alabama");
		states.put("AR", "Arkansas");
		states.put("AZ", "Arizona");
		states.put("CA", "California");
		states.put("CO", "Colorado");
		states.put("CT", "Connecticut");
		states.put("DC", "District of Columbia");
		states.put("DE", "Delaware");
		states.put("FL", "Florida");
		states.put("GA", "Georgia");
		states.put("HI", "Hawaii");
		states.put("IA", "Iowa");
		states.put("ID", "Idaho");
		states.put("IL", "Illinois");
		states.put("IN", "Indiana");
		states.put("KS", "Kansas");
		states.put("KY", "Kentucky");
		states.put("LA", "Louisiana");
		states.put("MA", "Massachusetts");
		states.put("MD", "Maryland");
		states.put("ME", "Maine");
		states.put("MI", "Michigan");
		states.put("MN", "Minnesota");
		states.put("MO", "Missouri");
		states.put("MS", "Mississippi");
		states.put("MT", "Montana");
		states.put("NC", "North Carolina");
		states.put("ND", "North Dakota");
		states.put("NE", "Nebraska");
		states.put("NH", "New Hampshire");
		states.put("NJ", "New Jersey");
		states.put("NM", "New Mexico");
		states.put("NV", "Nevada");
		states.put("NY", "New York");
		states.put("OH", "Ohio");
		states.put("OK", "Oklahoma");
		states.put("OR", "Oregon");
		states.put("PA", "Pennsylvania");
		states.put("RI", "Rhode Island");
		states.put("SC", "South Carolina");
		states.put("SD", "South Dakota");
		states.put("TN", "Tennessee");
		states.put("TX", "Texas");
		states.put("UT", "Utah");
		states.put("VA", "Virginia");
		states.put("VT", "Vermont");
		states.put("WA", "Washington");
		states.put("WI", "Wisconsin");
		states.put("WV", "West Virginia");
		states.put("WY", "Wyoming");
	}
	
	public static String getName(String key) {
		if(states.containsKey(key)) {
			return states.get(key);
		}
		return "";
	}
	
	public static boolean exists(String key) {
		return states.containsKey(key);
	}
	
	public static Map<String, String> getStates() {
		return states;
	}

}
