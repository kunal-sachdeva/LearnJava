import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class StreamChallenge5{
    public static void main(String[] args) throws IOException {
        StringBuffer output = new StringBuffer();
        String urlForCall="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=335051&date=11-05-2021";
        try {
            StringBuffer paramStr = new StringBuffer();
            URL url = new URL(urlForCall);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
            conn.setRequestProperty("CONTENT-TYPE", "application/json");
            //conn.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIwMDJiYzJjYy05MDQ4LTRmNjYtODhiZC0yNTBjOWU2ZTVmMTEiLCJ1c2VyX2lkIjoiMDAyYmMyY2MtOTA0OC00ZjY2LTg4YmQtMjUwYzllNmU1ZjExIiwidXNlcl90eXBlIjoiQkVORUZJQ0lBUlkiLCJtb2JpbGVfbnVtYmVyIjo5ODg4MTYxODg5LCJiZW5lZmljaWFyeV9yZWZlcmVuY2VfaWQiOjU1MjQxNDQ5ODg0MzkwLCJzZWNyZXRfa2V5IjoiYjVjYWIxNjctNzk3Ny00ZGYxLTgwMjctYTYzYWExNDRmMDRlIiwidWEiOiJNb3ppbGxhLzUuMCAoTWFjaW50b3NoOyBJbnRlbCBNYWMgT1MgWCAxMF8xNV83KSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvOTAuMC40NDMwLjkzIFNhZmFyaS81MzcuMzYiLCJkYXRlX21vZGlmaWVkIjoiMjAyMS0wNS0xMVQxODo0NDoxMi43MTNaIiwiaWF0IjoxNjIwNzU4NjUyLCJleHAiOjE2MjA3NTk1NTJ9.K4VoPKR2J_sfbbrpMJhQa5aOuaz67ypCnQiouf2tRyY");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String res;
            while ((res = br.readLine()) != null) {
                output.append(res);
            }
            br.close();
            JSONParser jp=new JSONParser();
            JSONArray listOfCenters = (JSONArray) ((JSONObject) jp.parse(output.toString())).get("centers");
            JSONObject myCenter= (JSONObject) listOfCenters.stream().filter(obj-> ((JSONObject)obj).get("center_id")=="697764");
            JSONArray sessions1= (JSONArray) ((JSONObject) myCenter).get("sessions");






            for(Object center:listOfCenters){
                if(((JSONObject) center).get("center_id")=="697764"){
                    System.out.println("center found!! Now finding slot.....");
                    JSONArray sessions= (JSONArray) ((JSONObject) center).get("sessions");
                    for(Object session:sessions){
                        if((((JSONObject) session).get("min_age_limit") == "18")
                                && Integer.parseInt((String) ((JSONObject) session).get("available_capacity")) > 0){
                            System.out.println("Slot is open!!");
                        } else{
                            System.out.println("Slot is not open!!");
                        }
                    }
                } else {
                    System.out.println("No center found");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("got exception"+e);
        }



        /*OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://cdn-api.co-vin.in/api/v2/appointment/sessions/calendarByPin?center_id=697764&pincode=335051&date=12-05-2021")
                .method("GET", null)
                .addHeader("CONTENT-TYPE", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiIwMDJiYzJjYy05MDQ4LTRmNjYtODhiZC0yNTBjOWU2ZTVmMTEiLCJ1c2VyX2lkIjoiMDAyYmMyY2MtOTA0OC00ZjY2LTg4YmQtMjUwYzllNmU1ZjExIiwidXNlcl90eXBlIjoiQkVORUZJQ0lBUlkiLCJtb2JpbGVfbnVtYmVyIjo5ODg4MTYxODg5LCJiZW5lZmljaWFyeV9yZWZlcmVuY2VfaWQiOjU1MjQxNDQ5ODg0MzkwLCJzZWNyZXRfa2V5IjoiYjVjYWIxNjctNzk3Ny00ZGYxLTgwMjctYTYzYWExNDRmMDRlIiwidWEiOiJNb3ppbGxhLzUuMCAoTWFjaW50b3NoOyBJbnRlbCBNYWMgT1MgWCAxMF8xNV83KSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvOTAuMC40NDMwLjkzIFNhZmFyaS81MzcuMzYiLCJkYXRlX21vZGlmaWVkIjoiMjAyMS0wNS0xMVQxMzowMjozMC4xMDJaIiwiaWF0IjoxNjIwNzM4MTUwLCJleHAiOjE2MjA3MzkwNTB9.blGKBIqgwHVp5WmLABC3AQruU8vo-XH6IpxVNvXgzPQ")
                .build();
        int count=0;
        while(count!=1) {
            Response response = client.newCall(request).execute();
            count++;
            System.out.println(response.body().string());
        }*/
    }

}
