package model;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestHttp {

	public Response makeHttpRequest(String urlString) throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(urlString).get().build();
		
		Response response = client.newCall(request).execute();

		return response;
	}
	
	

}
