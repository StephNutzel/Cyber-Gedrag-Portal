package server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpStatus;
import server.MainServer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpConnection {

    public static Response<String> get(String path) {
        HttpURLConnection connection = setupConnect("GET");
        return readResponse(connection);
    }

    public static Response<String> put(String path, Object o) {
        HttpURLConnection connection = setupConnect("PUT");
        sendRequest(o, connection);
        return readResponse(connection);
    }


    public static Response<String> post(String path, Object o) {
        HttpURLConnection connection = setupConnect("POST");
        sendRequest(o, connection);
        return readResponse(connection);
    }


    public static Response<String> delete(String path) {
        return readResponse(setupConnect("DELETE"));
    }

    private static HttpURLConnection setupConnect(String method) {
        HttpURLConnection connection = null;
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
        return connection;
    }

    public static void sendRequest(Object o, HttpURLConnection connection) {
        String jsonInputString = ObjectToJson(o);
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Response<String> readResponse(HttpURLConnection connection) {
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

    public static <T> List<T> jsonToObjectArray(String json, Class<T> o) {
        List<T> objects = new ArrayList<>();
        try {
            objects = new ObjectMapper().readValue(json, new TypeReference<>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objects;
    }

    public static <T> T JsonToObject(String json, Class<T> o) {
        try {
            o = new ObjectMapper().readValue(json, o.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) o;
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
