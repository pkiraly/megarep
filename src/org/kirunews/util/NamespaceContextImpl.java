package org.kirunews.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;

/** 
 * Helper class to create namespace context
 * @author Tesuji Magyarország Kft.
 */
public class NamespaceContextImpl implements NamespaceContext {

	/**
	 * Mapping of namespace prefixes and namespace URIs
	 */
	protected Map<String, String> URIs = new HashMap<String, String>();

	public NamespaceContextImpl() {	}
	
	public NamespaceContextImpl(String[] args) {
		addNamespaces(args);
	}

	/**
	 * Get namespace URI by its prefix
	 * @param prefix A namespace prefix
	 * @return Its URI
	 */
	public String getNamespaceURI(String prefix) {
		if (URIs.containsKey(prefix))
			return URIs.get(prefix);
		else
			return null;
	}
	
	/**
	 * Create an iterator of prefixes
	 */
	public Iterator<String> getPrefixes(String prefix) {
		return URIs.keySet().iterator();
	}
	
	/**
	 * Get the prefix of a namespace by its URI
	 * @return the prefix of the namespace or null if its URI isn't registred
	 */
	public String getPrefix(String uri) {
		for (String prefix : URIs.keySet()) {
			if (URIs.get(prefix).equals(uri))
				return prefix;
		}
		return null;
	}
	
	/**
	 * Register a new namespace
	 * @param prefix Namespace preix
	 * @param URI Namespace URI
	 */
	public void addNamespace(String prefix, String URI) {
		URIs.put(prefix, URI);
	}

	/**
	 * Add new namespaces
	 * @param args
	 */
	public void addNamespaces(String[] args) {
		if(args.length % 2 == 0) {
			for(int i=0; i<args.length; i+=2) {
				URIs.put(args[i], args[i+1]);
			}
		}
	}

	/**
	 * Show the registred namespaces
	 * @return a comma separated list of the registred namespaces 
	 */
	public String showNamespaces() {
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;
		for(String key : URIs.keySet()) {
			if(!isFirst) {
				sb.append(", ");
			} else {
				isFirst = false;
			}
			sb.append(key + ":=" + URIs.get(key));
		}
		return sb.toString();
	}
}
