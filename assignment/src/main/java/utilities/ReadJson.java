package utilities;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static JSONObject readJsonData(String fileName) throws IOException, ParseException {


        JSONParser jsonParser = new JSONParser();
       // JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("testdata//"+fileName));
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(System.getProperty("user.dir")+"//src//test//java//testdata//"+fileName));

        return jsonObject;
       //  JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(System.getProperty("user.dir")+"//src//test//java//testdata//"+fileName));


    }
}
