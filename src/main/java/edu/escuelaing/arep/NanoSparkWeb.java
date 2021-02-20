package edu.escuelaing.arep;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * clase de nanosparkweb
 * @author Alexander Torres
 *
 */
public class NanoSparkWeb {

	/**
	 * Constructor de la clase NanoSparkWEB
	 */
	public NanoSparkWeb() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * netodo get
	 * @param path ruta
	 * @param bifunction bifuncion 
	 */
	public static void get(String path, BiFunction<HttpRequest, HttpResponse, String> bifunction) {
		NanoSparkServer nanosvr = NanoSparkServer.getInstance();
		nanosvr.get(path,bifunction);
	}
	
	/**
	 * Metodo que inicia server
	 */
	public static void startServer() {
		NanoSparkServer nanosvr = NanoSparkServer.getInstance();
		nanosvr.startServer();
	}
}
