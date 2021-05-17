package server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.json.psi.impl.JsonObjectImpl;
import org.apache.http.HttpStatus;
import server.MainServer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection {

    private static HttpURLConnection connection;

    private static void setupConnect(String method) {
        try {
            URL url = new URL(MainServer.API_URL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public static Response<?> get(String path) {
        setupConnect("GET");
        return readResponse();
    }

    public static Response<?> put(String path, Object o) {
        setupConnect("PUT");
        sendRequest(o);
        return readResponse();
    }


    public static Response<?> post(String path, Object o) {
        setupConnect("POST");
        sendRequest(o);
        return readResponse();
    }


    public static Response<?> delete(String path) {
        setupConnect("DELETE");
        return readResponse();
    }

    public static void sendRequest(Object o) {
        String jsonInputString = ObjectToJson(o);
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Response<?> readResponse() {
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
            return new Response<>(response.toString(), HttpStatus.SC_OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Response<>("failed connection", HttpStatus.SC_NOT_FOUND);
    }

    public static Object JsontoObject(String json, Object o) {
        o = null;
        try {
            o = new ObjectMapper().readValue(json, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public static String ObjectToJson(Object o) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
