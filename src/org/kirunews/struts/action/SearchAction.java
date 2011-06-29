package org.kirunews.struts.action;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kirunews.struts.form.SearchForm;
import org.kirunews.util.ApplInfo;
import org.kirunews.util.Downloader;
import org.kirunews.util.Languages;
import org.kirunews.util.Logging;
import org.kirunews.util.NamespaceContextImpl;
import org.kirunews.util.Repository;
import org.kirunews.util.XPathHandler;

import org.kirunews.util.XsltTransformator;

/**
 * MyEclipse Struts Creation date: 03-17-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/search" name="searchForm" input="/form/search.jsp"
 *                scope="request" validate="true"
 * @struts.action-forward name="result" path="result.jsp" redirect="true"
 */
public class SearchAction extends Action {

	private static Logger logger = Logging.getLogger();
	private String contextPath;
	
	private static final String OPENSEARCH_URL = "http://a9.com/-/spec/opensearch/1.1/";
	private static final String ATOM_URL       = "http://www.w3.org/2005/Atom";
	private static final List<Repository> REPOS = ApplInfo.getRepositories();

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		System.setProperty("javax.xml.transform.TransformerFactory",
				"net.sf.saxon.TransformerFactoryImpl");

		String xsltDir = servlet.getServletContext().getRealPath("/xslt").replace("\\", "/");

		SearchForm searchForm = (SearchForm) form;
		
		// http://localhost:8150/megarep-ws/search.do
		System.out.println("RequestURL: " + request.getRequestURL());
		String applURL = request.getRequestURL() + "?" + request.getQueryString();
		System.out.println("applURL: " + applURL);
		applURL = applURL.replaceAll("&startIndex=[0-9]+", "");
		System.out.println("applURL: " + applURL);

		// /form/search.jsp
		//System.out.println("InputForward: " + mapping.getInputForward().getPath());

		contextPath = request.getContextPath();
		String uri = request.getRequestURI().substring(
				contextPath.length() + 1, request.getRequestURI().length() - 3);
		// search
		System.out.println("RequestURL: " + uri);
		// /search
		System.out.println("path: " + mapping.getPath());

		searchForm.setBaseURL(uri);
		searchForm.setLanguages(Languages.getLanguages());

		Downloader downloader = new Downloader();
		String queryString = createQuery(searchForm);
		String content;
		searchForm.setQuery(queryString);
		if (queryString.trim().length() > 0) {
			for(Repository repo : REPOS) {
				try {
				StringBuffer url = new StringBuffer();
				url.append(repo.getOpenSearchURL());
				url.append('?');
				url.append("searchTerms=").append(URLEncoder.encode(queryString, "UTF-8"));
				//String baseSearchUrl = url.toString();
				if(searchForm.getStartIndex() > 0) {
					url.append("&startIndex=").append(searchForm.getStartIndex());
				}
				searchForm.addServer(url.toString());
				URL oUrl = new URL(url.toString());
				System.out.println("oUrl: " + oUrl);
				content = downloader.download(oUrl);
				//System.out.println("content: " + content);

				if (content.length() == 0) {
					System.out.println(downloader.getResponseCode() 
							+ " " + downloader.getResponseMessage());
					continue;
				}

				// get header fields
				XPathHandler xpath = getXPath(content);
				try {
					searchForm.setTotalResults(Integer.parseInt(
						xpath.getContent("rss/channel/opensearch:totalResults")));
					searchForm.setStartIndex(Integer.parseInt(
						xpath.getContent("rss/channel/opensearch:startIndex")));
					searchForm.setItemsPerPage(Integer.parseInt(
						xpath.getContent("rss/channel/opensearch:itemsPerPage")));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (XPathExpressionException e) {
					e.printStackTrace();
				}
				int endIndex = searchForm.getStartIndex()
				             + searchForm.getItemsPerPage() - 1;
				if (endIndex > searchForm.getTotalResults()) {
					endIndex = searchForm.getTotalResults();
				}
				searchForm.setEndIndex(endIndex);
				StringBuffer navigationLine = new StringBuffer();
				int current = 1;
				while(current < searchForm.getTotalResults()) {
					if(navigationLine.length() > 0) {
						navigationLine.append("&nbsp;&nbsp;");
					}
					int to = current + searchForm.getItemsPerPage() - 1;
					if(to > searchForm.getTotalResults()) {
						to = searchForm.getTotalResults();
					}
					if(current != searchForm.getStartIndex()) {
						navigationLine.append("<a href=\"")
							.append(applURL)
							.append("&startIndex=").append(current)
							.append("\">").append(current + "&ndash;" + to)
							.append("</a>");
					} else {
						navigationLine.append("<strong>" + current + "&ndash;" + to + "</strong>");
					}
					current += searchForm.getItemsPerPage();
				}
				String oldNav = searchForm.getNavigationLine();
				if(oldNav != null) {
					oldNav += "<br/>";
				} else {
					oldNav = "";
				}
				String link = "<a href=\"" + repo.getURL() + "\">"  + repo.getName() + "</a>: ";
				searchForm.setNavigationLine(
					oldNav + link + navigationLine.toString()
				);

				// transform records
				Map<String, String> params = new HashMap<String, String>();
				String lang = getLocale(request).getLanguage();
				if (!lang.equals("hu") && !lang.equals("fr")
						&& !lang.equals("en")) {
					lang = "en";
				}
				params.put("lang", lang);
				params.put("xsltDir", xsltDir);
				params.put("startIndex", String.valueOf(searchForm.getStartIndex()));
				String result = transform(content, xsltDir + "/megarep.xsl", params, searchForm);
				String oldResult = searchForm.getResults();
				if(oldResult != null) {
					result = oldResult + result;
				}
				searchForm.setResults(result);
				} catch (MalformedURLException e) {
					searchForm.setError(e.getMessage());
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					searchForm.setError(e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return mapping.getInputForward();
	}

	private String createQuery(SearchForm form) {
		StringBuffer query = new StringBuffer();
		if (form.getMeter_qualifier() != null
				&& form.getMeter_qualifier().trim().length() > 0) {
			query.append("meter:").append(form.getMeter_qualifier());
		} else if (form.getMeter() != null
				&& form.getMeter().trim().length() > 0) {
			query.append("meter:").append(form.getMeter());
		}

		addField("segmentation", form.getSegmentation(), query);
		addField("segmentation_qualifier", form.getSegmentation_qualifier(),
				query);
		addField("rhyme", form.getRhyme(), query);
		addField("rhyme_qualifier", form.getRhyme_qualifier(), query);
		addField("rhyme_scheme", form.getRhyme_scheme(), query);
		addField("metrical_scheme", form.getMetrical_scheme(), query);
		addField("declination_line", form.getDeclination_line(), query);
		addField("declination_strophe", form.getDeclination_strophe(), query);
		addField("declination_scheme", form.getDeclination_scheme(), query);
		addField("number_of_lines", form.getNumber_of_lines(), query);
		addField("number_of_strophes", form.getNumber_of_strophes(), query);
		addField("author", form.getAuthor(), query);
		addField("date", form.getDate(), query);
		addField("date_qualifier", form.getDate_qualifier(), query);
		addField("melody", form.getMelody(), query);
		addField("melody_qualifier", form.getMelody_qualifier(), query);
		addField("genre", form.getGenre(), query);
		addField("caesuras", form.getCaesuras(), query);
		addField("language", form.getLanguage(), query);
		addField("language_qualifier", form.getLanguage_qualifier(), query);

		return query.toString();
	}

	private void addField(String fieldName, String content, StringBuffer query) {
		if (content != null && content.trim().length() > 0) {
			if (query.length() > 0)
				query.append(" ");
			query.append(fieldName).append(":").append(content);
		}
	}

	private void addField(String fieldName, int content, StringBuffer query) {
		if (content > 0) {
			if (query.length() > 0)
				query.append(" ");
			query.append(fieldName).append(":").append(content);
		}
	}

	private void addField(String fieldName, String[] content, StringBuffer query) {
		if (content != null) {
			if (query.length() > 0)
				query.append(" ");
			query.append(fieldName).append(":(");
			int i = 0;
			for (String v : content) {
				if (i++ > 0)
					query.append(" OR ");
				query.append(v);
			}
			query.append(")");
		}
	}

	private String transform(String xmlSource, String xsltFileName,
			Map<String, String> params, SearchForm searchForm) {
		// logger.info(xmlSource);
		String fileNameToShow = xsltFileName.substring(xsltFileName
				.lastIndexOf("/") + 1);
		try {
			XsltTransformator t = new XsltTransformator();
			t.setParams(params);
			String output = t.transform(xmlSource, xsltFileName);
			return output.replaceAll("BASE_PATH", contextPath);
		} catch (FileNotFoundException e) {
			searchForm.setError(fileNameToShow + " [File not found error] "
					+ e.getMessage());
		} catch (TransformerConfigurationException e) {
			searchForm.setError(fileNameToShow
					+ " [Transformer configuration error] "
					+ e.getMessageAndLocation());
		} catch (TransformerException e) {
			logger.error(xmlSource);
			searchForm.setError(fileNameToShow + " [Transformer error] "
					+ e.getMessageAndLocation() + xmlSource);
		}
		return "";
	}
	
	private XPathHandler getXPath(String content) {
		NamespaceContextImpl ns = new NamespaceContextImpl();
		ns.addNamespace("opensearch", OPENSEARCH_URL);
		ns.addNamespace("atom",       ATOM_URL);
		XPathHandler xpath = new XPathHandler(content);
		xpath.setNamespaceContext(ns);
		return xpath;
	}

}