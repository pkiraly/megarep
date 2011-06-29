package org.kirunews.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import org.kirunews.util.Logging;

public class Downloader {
	
	private static Logger logger = Logging.getLogger();

	private static final int timeout = 500;
	private int responseCode;
	private String responseMessage;
	private Exception error;

	public String download(URL url) {
		InputStream contentStream = null;
		HttpURLConnection httpConn = null;
		try {
			if (url.getHost() == null || url.getHost().trim().length() == 0) {
				return "";
			}
			
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(timeout);
			
			if(url.getProtocol().equals("http")) {
				httpConn = (HttpURLConnection)conn;
				httpConn.setReadTimeout(timeout * 1000);
				httpConn.setRequestMethod("POST");

				responseCode = -1;
				responseCode = httpConn.getResponseCode();
				responseMessage = httpConn.getResponseMessage();
				
				if(responseCode != 200) {
					logger.error("responseCode: " + responseCode);
					return "";
				}
				
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				
				StringBuffer content = new StringBuffer();
				
				String line;
				while((line = bufferedReader.readLine()) != null) {
					content.append(line).append("\n");
				}
				bufferedReader.close();
				return content.toString();
			} else {
				throw new ProtocolException("unhandled protocol: " + url.getProtocol() + " - " + url);
			}

			
			/*
			contentStream = new BufferedInputStream(conn.getInputStream());
			contentStream.mark(Integer.MAX_VALUE);
			if(responseHeader == null) {
				responseHeader = conn.getHeaderFields();
			}
			
			contentCreator.addContent(contentStream, document, 
					responseHeader);
					*/
			
		} catch (UnknownHostException e) {
			logger.info("Unknown host: " + url);
			this.error = e;
		} catch (ConnectException e) {
			logger.info("Connect Exception: " + url);
			this.error = e;
		} catch (SocketTimeoutException e) {
			logger.info("Timeout: " + url);
			this.error = e;
		} catch (SocketException e) {
			logger.error("Socket Exception: " + url, e);
			//e.printStackTrace();
			this.error = e;
		} catch (ProtocolException e){
			logger.info("Protocol Exception: " + url);
			//e.printStackTrace();
			this.error = e;
		} catch (IOException e) {
			logger.error("IOException at " + url, e);
			this.error = e;
		/*
		} catch (ParseException e) {
			logger.error("ParseException at " + url, e);
			this.error = e;
		*/
		} finally {
			try {
				if(contentStream != null) {
					contentStream.close();
				}
			} catch (Exception e) {
				logger.error("Error in closing input stream. ", e);
			}
			try {
				if(httpConn != null) {
					httpConn.disconnect();
				}
			} catch (Exception e) {
				logger.error("Error in closing http connection. ", e);
			}
		}
		return "";
	}

	public int getResponseCode() {
		return responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public Exception getError() {
		return error;
	}
}
