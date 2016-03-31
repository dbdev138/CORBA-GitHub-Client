/*
 *David Brady
 *x12112267
*/

import APIConnection.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import com.google.gson.*;

import javax.net.ssl.HttpsURLConnection;

class GitHubServant implements GitHubOperations
{

	Gson gson = new com.google.gson.Gson();

      //Below are a list of methods for interacting with the GitHub API
      //The GSON library is used to extract the desired values from the JSON object
      //returned by the HTTP request made to the GitHub API


      //This method retrieves basic GitHub User Data via a HTTP Get Request
   	public void getBasicUserData(String userName, Client callback){
   		try {
   		    String json = sendGet("https://api.github.com/users/"+userName);
             com.google.gson.JsonObject resultObj = gson.fromJson(json, JsonElement.class).getAsJsonObject();
             
             String response = 
             "User Name: " + resultObj.get("login") + "\n" +
             "User URL: " + resultObj.get("html_url") + "\n" +
             "User ID : " + resultObj.get("id") + "\n";

		       callback.receiveBasicUserData(response);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}
   	}

      //This method retrieves details pertaining to a particular GitHUb Repository
   	public void getRepoDetails(String userName, String repo, Client callback){
   		try {
   		    String json = sendGet("https://api.github.com/repos/"+userName+"/"+repo);
             com.google.gson.JsonObject resultObj = gson.fromJson(json, JsonElement.class).getAsJsonObject();

             String response = 
             "Repo Name: " + resultObj.get("name") + "\n" +
             "Description: " + resultObj.get("description") + "\n" +
             "Created On : " + resultObj.get("created_at") + "\n" +
             "Last Push : " + resultObj.get("pushed_at") + "\n";

		    callback.receiveRepoDetails(response);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}

      //This method takes GitHub username and repository name and returns a list of the languages
      //associated with that repository. It achieves this my extracting the keys rather than the values
   	public void getDeveloperLanguages(String userName, String repo, Client callback){
   		try {
   		    List<String> langArray = new ArrayList<String>();

             String json = sendGet("https://api.github.com/repos/"+userName+"/"+repo+"/languages");

             JsonParser parser = new JsonParser();
             JsonElement element = parser.parse(json);
             JsonObject resultObj = element.getAsJsonObject(); 
             Set<Map.Entry<String, JsonElement>> entries = resultObj.entrySet();

             for (Map.Entry<String, JsonElement> entry: entries) {
                langArray.add(entry.getKey());
             }

            String response = 
            "Developer: "+userName+"\n"+
            "Used the following languages: " +langArray.toString()+ "\n" +
            "On the GitHub Project: " + repo + "\n";

   		    callback.receiveDeveloperLanguages(response);	
      		} catch (Exception e){
      		    //e.printStacktrace();
      		}
   	}

      //This method retrieves a count of the number of Public Repositories associated witha given GitHub User
   	public void getRepoCount(String userName, Client callback){
   		try {
   		    String json = sendGet("https://api.github.com/users/"+userName);
             com.google.gson.JsonObject resultObj = gson.fromJson(json, JsonElement.class).getAsJsonObject();
             
             String response = 
            resultObj.get("public_repos") + ": Public Repositories Listed on this account \n";

             callback.receiveBasicUserData(response); 	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}

      //This method retrieves the Clone Url for a given repository
   	public void getCloneUrl(String userName, String repo, Client callback){
   		try {
   		    String json = sendGet("https://api.github.com/repos/"+userName+"/"+repo);
             com.google.gson.JsonObject resultObj = gson.fromJson(json, JsonElement.class).getAsJsonObject();

             String response = 
             "Clone this source code using the following link: "+resultObj.get("clone_url");

		    callback.receiveCloneUrl(response);	
   		} catch (Exception e){
   		    //e.printStacktrace();
   		}

   	}

	private String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

        return response.toString();
	}
}
