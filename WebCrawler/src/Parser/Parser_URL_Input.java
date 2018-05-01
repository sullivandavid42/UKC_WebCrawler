package Parser;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Parser_URL_Input
{
    @SuppressWarnings("unchecked")

    public void file_input(){

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\Sullivan\\IdeaProjects\\UKC_WebCrawler\\WebCrawler\\Websites.json"));
            JSONObject jsonobj = (JSONObject)obj;


            String urltest = (String) jsonobj.get("url");
            System.out.println(urltest);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
