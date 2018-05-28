package Parser;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Parser_URL_Input extends Component {
    @SuppressWarnings("unchecked")

    public List<String> file_input() throws Exception {

        final JFileChooser fc = new JFileChooser();
        File file = new File(System.getProperty("user.dir"));
        fc.setCurrentDirectory(file);
        fc.showOpenDialog(Parser_URL_Input.this);
        file = fc.getSelectedFile();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file.getPath()));
        JSONArray ja = (JSONArray) jsonObject.get("routes");
        List<String> list_url = new ArrayList<>();
        for (int i = 0; i < ja.size(); i++) {
            JSONObject tempJsonObj = (JSONObject) ja.get(i);
            list_url.add(tempJsonObj.get("url").toString());
            System.out.println(String.format("ID: %s", tempJsonObj.get("id").toString()));
            System.out.println(String.format("URL: %s", tempJsonObj.get("url").toString()));
            System.out.println(String.format("Flag-Home: %s", tempJsonObj.get("home")));
        }
        return list_url;
    }
}
