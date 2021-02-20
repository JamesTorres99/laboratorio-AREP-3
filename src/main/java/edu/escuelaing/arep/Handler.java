package edu.escuelaing.arep;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 
 * @author Alexander Torres
 *
 * @param <T> the type of the handler
 */
public interface Handler<T> {
	public T handle(String path, HttpRequest req, HttpResponse res);
}
