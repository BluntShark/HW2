package org.example;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainNew {
    public static void main(String[] args){
        String query = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/data.json";
        HttpURLConnection connection = null;

/*
        JSONArray c = (JSONArray) new JSONParser().parse((new FileReader("replacement.json")));
        for (int i = 0; i < c.size(); i++) {
            JSONObject object = (JSONObject) c.get(i);
            System.out.println(object.get("replacement"));
            System.out.println(object.get("source"));
        }
*/

        try{
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.connect();

            StringBuilder sb = new StringBuilder();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line = null;
                int i = 0;
                String[] arr = new String[29];
                WritingLines(line, sb, in, arr, i);

                for(int j = 0; j <= arr.length - 1; j++){
                    System.out.println(arr[j]);
                }

                String[] replStr = new String[arr.length];
                String[] newreplStr = new String[arr.length];
                Gson gson = new Gson();

                //ReplaceRows(replStr, arr, i);
                ReplaceRowsNew(replStr, arr, i, gson, newreplStr);

                //gson.toJson(replStr, new FileWriter("result.json"));
/*

                JSONArray c = (JSONArray) new JSONParser().parse((new FileReader("replacement.json")));

                for (int k = 0; k < arr.length; k++){
                    for (int j = 0; j < c.size(); j++) {
                        JSONObject object = (JSONObject) c.get(j);
                        replStr[k] = arr[k].replace(String.valueOf(object.get("replacement")),String.valueOf(object.get("source")));
                        if(replStr [k] != arr[k]){
                            break;
                        }
                    }
                    newreplStr[k] = replStr[k];
                }
                gson.toJson(newreplStr, new FileWriter("result2.json"));


 */

/*
                JSONObject object = (JSONObject) c.get(4);
                String replacement = String.valueOf(object.get("replacement"));
                String source = String.valueOf(object.get("source"));


                replStr[1] = arr[1].replace(replacement,source);

                System.out.println("------------");
                System.out.println(arr[1]);
                System.out.println(replStr[1]);

                if(replStr1 [1] != arr[1]){
                    System.out.println("Замена произошла!");
                }
                System.out.println("res = " + replStr[1]);
                */

            }
            else{
                System.out.println("error");
            }

        }
        catch(Throwable cause){
            cause.printStackTrace();
        }
        finally{
            if(connection != null){
                connection.disconnect();
            }
        }
    }
    public static void ReplaceRows(String[] replStr, String[] arr, int i){
        for (i = 0; i < arr.length; i++){
            replStr[i] = arr[i].replace("Ha-haaa, hacked you", "I doubted if I should ever come back")
                    .replace("sdshdjdskfm sfjsdif jfjfidjf", "Somewhere ages and ages hence:")
                    .replace("1", "l")
                    .replace("Emptry... or NOT!", "")
                    .replace("dl2324344rgg6f5g6gdf2ddjf,", "wood")
                    .replace("Random text, yeeep", "took")
                    .replace("Bla-bla-bla-blaaa, just some RANDOM tExT", "")
                    .replace("parentheses - that is a smart word", "the better claim")
                    .replace("sdshdjdskfm sfjsdif jfjfidjf", "Somewhere ages and ages hence:")
                    .replace("Emptry... or NOT!", "Had worn")
                    .replace("Skooby-dooby-doooo", "knowing how way leads on")
                    .replace("sdshdjdskfm sfjsdif jfjfidjf", "Somewhere ages and ages hence:")
                    .replace("An other text", "")
                    .replace("Skooby-dooby-doooo", "knowing how way");

        }
    }
    public static void ReplaceRowsNew(String[] replStr, String[] arr, int i, Gson gson, String[] newreplStr){
        JSONArray c = null;
        try {
            c = (JSONArray) new JSONParser().parse((new FileReader("replacement.json")));
            for (int k = 0; k < arr.length; k++){
                for (int j = 0; j < c.size(); j++) {
                    JSONObject object = (JSONObject) c.get(j);
                    replStr[k] = arr[k].replace(String.valueOf(object.get("replacement")),String.valueOf(object.get("source")));
                    if(replStr [k] != arr[k]){
                        break;
                    }
                }
                newreplStr[k] = replStr[k];
            }
            gson.toJson(newreplStr, new FileWriter("result3.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
    public static void WritingLines(String line, StringBuilder sb, BufferedReader in, String[] arr, int i){
        try {
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
                arr[i] = line;
                i++;
            }
        }
        catch (IOException io){
            System.out.println(io);
        }
    }

}
