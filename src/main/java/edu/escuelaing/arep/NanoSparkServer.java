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

/**
 * Clase NanoSparkServer 
 * @author Alexander Torres
 *
 */
public class NanoSparkServer implements Handler<String>{
	private static NanoSparkServer theInstance = new NanoSparkServer();
	private HttpServer hserver = new HttpServer();
	
	/**
	 * metodo que retorna la instancia
	 * @return la instancia
	 */
	public static NanoSparkServer getInstance() {
		return theInstance;
	}

	private Map<String, BiFunction<HttpRequest, HttpResponse, String>>bodyMap= new HashMap();
	
	/**
	 * metodo nanoSparkServer
	 */
	private NanoSparkServer() {
			hserver.registerHandler(this,"/Apps");
	}

	/**
	 * metodo get
	 * @param path ruta
	 * @param body cuerpo de pagina
	 */
	public void get(String path, BiFunction<HttpRequest, HttpResponse, String> body) {
		bodyMap.put(path, body);
	}
	
	/***
	 * metodo get value retorna el valor 
	 * @param path ruta 
	 * @param req request
	 * @param res response
	 * @return
	 */
	public String getValue(String path, HttpRequest req, HttpResponse res ) {
		return bodyMap.get(path).apply(req, res);
	}
	
	@Override
	public String handle(String path, HttpRequest req, HttpResponse res) {
		return getValue(path, req, res);
	}
	
	
	/**
 	*Inicia el servidor  
 	*/
	public void startServer() {
		try {
			hserver.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
