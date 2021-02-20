package edu.escuelaing.arep;

import java.io.IOException;

/**
 * Clase main que inicializa el servidor. 
 * @author Alexander Torres
 *
 */
public class Main {

	/**
	 * Crea una instancia de HttpServer y inicia el server
	 * @param args necesario para iniciar main
	 */
	public static void main(String[] args) {
			try {
				HttpServerReto hserver =new HttpServerReto();
				hserver.startServer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
