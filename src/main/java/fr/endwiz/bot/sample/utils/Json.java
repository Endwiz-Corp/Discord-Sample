package fr.endwiz.bot.sample.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Json {
    public static String read(String directory, String info){
        try (Reader reader = new FileReader(directory)) {

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);
            return (String)jsonObject.get(info);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
