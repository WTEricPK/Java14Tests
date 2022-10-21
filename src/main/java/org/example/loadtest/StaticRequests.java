package org.example.loadtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class StaticRequests {

    public static Response sendPOST(final String url, final String body, final Map<String, String> headers) throws IOException {

        long start = System.currentTimeMillis();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "JavaClient");

        for(Map.Entry<String, String> entry : headers.entrySet()) {
            con.setRequestProperty(entry.getKey(), entry.getValue());
        }

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();

        String responseBody;
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            final StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            responseBody = response.toString();
        } else {
            responseBody = null;
        }
        long stop = System.currentTimeMillis();
        long timeMillis = (stop - start);

        return new Response(responseCode, responseBody, timeMillis);
    }

}
