package main.java.de.zalando;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.omg.CORBA.portable.OutputStream;

public class main {
	
	public void prgm(){
		
		
		
	}

	public main(){
		
		
		// sending URL with parameters
	String tErrorString = "";  
	 
	 HttpURLConnection httpCon = null;  

    try{  
        URL url = new URL("http://localhost:8080/swagger-ui");  
        httpCon = (HttpURLConnection) url.openConnection();  
        httpCon.setRequestMethod("POST"); 
        httpCon.setDoOutput(true);
        httpCon.setDoInput(true);
        httpCon.setUseCaches(false);
        httpCon.setAllowUserInteraction(false);
        httpCon.setRequestProperty("Content-Type",
            "application/xml");

        OutputStream out = (OutputStream) httpCon.getOutputStream();
        Writer writer = new OutputStreamWriter(out, "UTF-8");
        writer.write("content");
        writer.write("=");
        writer.write(URLEncoder.encode("Code/Url", "UTF-8"));
        writer.close();
        out.close(); 
        httpCon.connect(); 
        
} catch (Exception e) {  
        tErrorString = e.getMessage();  
    }  


       }
	
	public static String httpPost(String urlStr, String[] paramName,
			String[] paramVal) throws Exception {
			  URL url = new URL(urlStr);
			  HttpURLConnection conn =
			      (HttpURLConnection) url.openConnection();
			  conn.setRequestMethod("POST");
			  conn.setDoOutput(true);
			  conn.setDoInput(true);
			  conn.setUseCaches(false);
			  conn.setAllowUserInteraction(false);
			  conn.setRequestProperty("Content-Type",
			      "application/x-http://localhost:8080/swagger-ui");

			  // Create the form content
			  OutputStream out = (OutputStream) conn.getOutputStream();
			  Writer writer = new OutputStreamWriter(out, "UTF-8");
			  for (int i = 0; i < paramName.length; i++) {
			    writer.write(paramName[i]);
			    writer.write("=");
			    writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
			    writer.write("&");
			  }
			  writer.close();
			  out.close();

			  if (conn.getResponseCode() != 200) {
			    throw new IOException(conn.getResponseMessage());
			  }

			  // Buffer the result into a string
			  BufferedReader rd = new BufferedReader(
			      new InputStreamReader(conn.getInputStream()));
			  StringBuilder sb = new StringBuilder();
			  String line;
			  while ((line = rd.readLine()) != null) {
			    sb.append(line);
			  }
			  rd.close();

			  conn.disconnect();
			  return sb.toString();
			}
	//getting response from server and react to this response
	

	public static String httpGet(String urlStr) throws IOException {
		  URL url = new URL(urlStr);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  return sb.toString();
		}



}
