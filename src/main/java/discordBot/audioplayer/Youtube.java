package discordBot.audioplayer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class Youtube {
	
	
	private Youtube() {
		
	}
	
	
	private  static Youtube INSTANCE;
	public static synchronized Youtube getInstance() { 
		if (INSTANCE == null) {
			INSTANCE = new Youtube();
		}
		return INSTANCE;
	}
	
	  public List<JSONObject> searchForVideo(String search) throws IOException {
	        // Create request
	        Request request = new Request.Builder()
	                .url("https://www.googleapis.com/youtube/v3/search?" +
	                        "&part=id" +
	                        "&part=snippet" +
	                        "&type=video" + // Only search for videos
	                        "&q=" + search + // Search for the given keyword
	                        "&key=" + "AIzaSyD48VANgIZJttehyTKGU0T8h2WNuEHZHnk" // Provide my youtube key
	                )
	                .build();
	        //Execute call
	        OkHttpClient client = new OkHttpClient();
	        
	        String channelOutput = client.newCall(request).execute().body().string(); //검색결과 

	        final List<JSONObject> videos = new ArrayList<>(); // Create list
	        final JSONArray items = new JSONObject(channelOutput).getJSONArray("items"); // Create Json object

	        // Add all videos to the list
	        for (Object videoInfo : items) {
	            final JSONObject video = (JSONObject) videoInfo; // Parse Object to JSONObject
	            
	            videos.add(video); // Add video to list
	        }

	        return videos;
	    }

	  
	
}
