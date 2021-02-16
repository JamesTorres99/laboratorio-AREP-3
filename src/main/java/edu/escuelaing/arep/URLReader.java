package edu.escuelaing.arep;



import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class URLReader {

	public URLReader() {
		super();
	}

	public static void main(String[] args) throws Exception {
		URL google = new URL("http://localhost:36000/miotrositio/foto.png");
		
		String site= "http://localhost:36000/miotrositio/foto.png";
		URL siteURL = new URL(site);
		URLConnection urlConnection = siteURL.openConnection();
		Map<String, List<String>> headers = urlConnection.getHeaderFields();
		Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
		
		for (Map.Entry<String, List<String>> entry : entrySet) {
			String headerName = entry.getKey();
			if(headerName !=null){System.out.print(headerName + ":");}
			List<String> headerValues = entry.getValue();
			for (String value : headerValues) {
			System.out.print(value);
			}
			System.out.println("");
			}
		
		try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
			String inputLine = null;
			while ((inputLine = reader1.readLine()) != null) {
				System.out.println(inputLine);
			}
		}catch (IOException x) {
			System.err.println(x);
		}
		
		System.out.println("leyendo de url:");
		ejer1();
	}
	
	public static void ejer1() throws Exception {
		URL ejer = new URL("http://localhost:36000/ejer1");
		try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(ejer.openStream()))) {
			System.out.println("-------------------");
			System.out.println(ejer.getHost());
			System.out.println(ejer.getProtocol());
			System.out.println(ejer.getAuthority());
			System.out.println(ejer.getPath());
			System.out.println(ejer.getPort());
			System.out.println(ejer.getQuery());
			System.out.println(ejer.getFile());
			System.out.println(ejer.getRef());
			System.out.println("-------------------");
			
		
		}
		catch (IOException x) {
		System.err.println(x);
	}
		
		
		
	}

}
