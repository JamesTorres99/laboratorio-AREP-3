package edu.escuelaing.arep;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NanoSparkServer implements Handler<String>{
	private static NanoSparkServer theInstance = new NanoSparkServer();
	private HttpServer hserver = new HttpServer();
	
	public static NanoSparkServer getInstance() {
		return theInstance;
	}

	private Map<String, BiFunction<HttpRequest, HttpResponse, String>>bodyMap= new HashMap();
	
	private NanoSparkServer() {
			hserver.registerHandler(this,"/Apps");
	}

	public void get(String path, BiFunction<HttpRequest, HttpResponse, String> body) {
		bodyMap.put(path, body);
	}
	
	public String getValue(String path, HttpRequest req, HttpResponse res ) {
		return bodyMap.get(path).apply(req, res);
	}
	
	@Override
	public String handle(String path, HttpRequest req, HttpResponse res) {
		return getValue(path, req, res);
	}

	public void startServer() {
		try {
			hserver.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
