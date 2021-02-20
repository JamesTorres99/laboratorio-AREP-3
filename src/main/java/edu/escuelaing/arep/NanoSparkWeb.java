package edu.escuelaing.arep;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class NanoSparkWeb {

	public NanoSparkWeb() {
		// TODO Auto-generated constructor stub
	}
	
	public static void get(String path, BiFunction<HttpRequest, HttpResponse, String> bifunction) {
		NanoSparkServer nanosvr = NanoSparkServer.getInstance();
		nanosvr.get(path,bifunction);
	}
	
	public static void startServer() {
		NanoSparkServer nanosvr = NanoSparkServer.getInstance();
		nanosvr.startServer();
	}
}
