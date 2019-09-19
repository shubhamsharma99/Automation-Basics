package Reusable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




@SuppressWarnings("deprecation")
public class HTTPClientFactory{
	
	HTTPClientFactory objHTTPClient = null;
	
	public HTTPClientFactory()
	 {}
	  
	 public HTTPClientFactory getInstance()
	 {
		 if(objHTTPClient == null){
			 objHTTPClient = new HTTPClientFactory();
		 }
		 return objHTTPClient;
	 }
	 
	 
	DefaultHttpClient httpClient = new DefaultHttpClient();
	 HttpGet getRequest=null;
	 HttpResponse response=null;
	
	
	 public void executeRequest(String webserviceURL,String responseType) throws ClientProtocolException, IOException,ConnectException, JSONException
	 {
		 getRequest = new HttpGet(webserviceURL);
         getRequest.addHeader("accept", responseType);
         response = httpClient.execute(getRequest);
         BufferedReader br = new BufferedReader(
         new InputStreamReader((response.getEntity().getContent())));

         String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) 
        {
                System.out.println(output);
        }
        
      /*JSONObject jsonObject = new JSONObject(br);
      //JSONObject restresponse  =jsonObject.getJSONObject("RestResponse");
      String country=jsonObject.getString("country");
      System.out.println(country);*/
        
      
       
       
        
    }   
         

	 
	 public int getStatusCode(String webserviceURL,String responseType) throws ClientProtocolException, IOException
	 {
		 
		 getRequest = new HttpGet(webserviceURL);
         getRequest.addHeader("accept", responseType);
         response = httpClient.execute(getRequest);
         int statusCode=response.getStatusLine().getStatusCode();
         System.out.println("Status code is "+statusCode);
         return statusCode;
         
         
	 }
	public void getJSONParameterValue() throws JSONException
	 {
		
		String jsonString  = "{" + 
	            "   \"MyResponse\": {" + 
	            "       \"count\": 3," + 
	            "       \"listTsm\": [{" + 
	            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
	            "           \"simpleid\": 1," + 
	            "           \"name\": \"vignesh1\"" + 
	            "       }," + 
	            "       {" + 
	            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
	            "           \"simpleid\": 2," + 
	            "           \"name\": \"vignesh2\"" + 
	            "       }," + 
	            "       {" + 
	            "           \"id\": \"b90c6218-73c8-30bd-b532-5ccf435da766\"," + 
	            "           \"simpleid\": 3," + 
	            "           \"name\": \"vignesh3\"" + 
	            "       }]" + 
	            "   }" + 
	            "}";
		 JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject myResponse = jsonObject.getJSONObject("MyResponse");
        JSONArray tsmresponse = (JSONArray) myResponse.get("listTsm");

        ArrayList<String> list = new ArrayList<String>();

        for(int i=0; i<tsmresponse.length(); i++){
            list.add(tsmresponse.getJSONObject(i).getString("name"));
        }

        System.out.println(list);
		
		
		   
		 
	 } 
	 
	public void closeHTTPConnection()
	 {
		 httpClient.getConnectionManager().shutdown();
	 }
	 

	public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
		
		HTTPClientFactory objHTTP = new HTTPClientFactory().getInstance();
		//objHTTP.executeRequest("http://services.groupkt.com/state/get/IND/all","application/json");
		//objHTTP.getStatusCode("http://services.groupkt.com/state/get/IND/all","application/json");
		//objHTTP.getJSONParameterValue();
		//objHTTP.executeRequest("http://localhost:9999/letsknow/index.html#/login","application/json");
		//objHTTP.executeRequest("http://www.w3schools.com/xml/tempconvert.asmx","application/json");
		
		objHTTP.closeHTTPConnection();
	}
		



	}


