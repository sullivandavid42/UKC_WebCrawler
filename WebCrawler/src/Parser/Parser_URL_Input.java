package Parser;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class Parser_URL_Input
{
    @SuppressWarnings("unchecked")

    public void file_input() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\Sullivan\\IdeaProjects\\UKC_WebCrawler\\WebCrawler\\Websites.json"));
        JSONArray ja = (JSONArray) jsonObject.get("routes");

        for(int i=0;i<ja.size() ; i++){
            JSONObject tempJsonObj = (JSONObject) ja.get(i);
            System.out.println(String.format("ID: %s", tempJsonObj.get("id").toString()));
            System.out.println(String.format("URL: %s", tempJsonObj.get("url").toString()));
            System.out.println(String.format("Flag-Home: %s", tempJsonObj.get("home")));
        }


    }


}
