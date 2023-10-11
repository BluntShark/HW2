package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.io.FileWriter;
import  org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
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


                String line;
                int i = 0;
                String[] arr = new String[29];
                while((line = in.readLine()) != null){
                    sb.append(line);
                    sb.append("\n");
                    arr[i] = line;
                    i++;
                }

                String[] replStr = new String[arr.length];
                String[] newreplStr = new String[arr.length];


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

                    //System.out.println(replStr[i]);
                }

                Gson gson = new Gson();
                gson.toJson(replStr, new FileWriter("result.json"));

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
                    //System.out.println(newreplStr[k]);
                }
                gson.toJson(newreplStr, new FileWriter("result2.json"));

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
}