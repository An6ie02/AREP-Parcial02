package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static int serverIndex = 0;
    private static final String[] SERVERS = new String[] { "ec2-54-91-215-220.compute-1.amazonaws.com:4568/", "ec2-54-91-215-220.compute-1.amazonaws.com:4568/"};

    public static String invoke(String operation, String list, String value) throws IOException {
        String GET_URL = SERVERS[serverIndex] + operation + "?numbers=" + list + "&number=" + value;
        System.out.println("GET URL: " + GET_URL);
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        changeServer();
        System.out.println("Server changed to: " + serverIndex);
        return response.toString();
    }

    private static void changeServer() {
        serverIndex = (serverIndex + 1) % SERVERS.length;
    }

}
