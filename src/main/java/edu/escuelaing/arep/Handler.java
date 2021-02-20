package edu.escuelaing.arep;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase Handler
 * @author Alexander Torres
 *
 * @param <T> the type of the handler
 */
public interface Handler<T> {
	/**
	 * metodo handle
	 * @param path ruta
	 * @param req request
	 * @param res response
	 * @return t handle
	 */
	public T handle(String path, HttpRequest req, HttpResponse res);
}
