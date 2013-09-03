package com.shev.httpclient;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

public class ShevHttpClient {
	SchemeRegistry schemeRegistry = new SchemeRegistry();
	PoolingClientConnectionManager cm;
	public ShevHttpClient() {
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, PlainSocketFactory.getSocketFactory()));
		cm = new PoolingClientConnectionManager(schemeRegistry);
		cm.setMaxTotal(200);
		cm.setDefaultMaxPerRoute(2);
	}
	
	public void registerHost(String hostname, int port) {
		cm.setMaxPerRoute(new HttpRoute(new HttpHost(hostname, port)), 30);
	}
	
	public HttpClient getClient() {
		return new DefaultHttpClient(cm);
	}
}
