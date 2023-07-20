package model;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Class for Http request in currency conversion, it uses an API
 */
public class RequestHttp {
	
	/**
	 * The http request method
	 * @param urlString The API url 
	 * @return An ok response for http request 
	 * @throws IOException IO exception if the response fail
	 */
	public Response makeHttpRequest(String urlString) throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(urlString).get().build();
		
		Response response = client.newCall(request).execute();

		return response;
	}
	
	

}
