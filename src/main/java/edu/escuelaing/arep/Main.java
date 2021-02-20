package edu.escuelaing.arep;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
			try {
				HttpServerReto hserver =new HttpServerReto();
				hserver.startServer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
