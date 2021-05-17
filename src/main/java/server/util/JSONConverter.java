package server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.json.psi.impl.JsonObjectImpl;
import server.MainServer;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONConverter {

    private static HttpURLConnection connection;
    private static URL url;

    private static void setupConnect(String method) {
        try {
            url = new URL(MainServer.API_URL);
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

    public static Response<?> put(String path) {
        setupConnect("PUT");
        return null;
    }


    public static Response<?> post(String path) {
        setupConnect("POST");
        return null;
    }


    public static Response<?> delete(String path) {
        setupConnect("DELETE");
        return null;
    }


    public static Object URLToObject(String url) {
        Object o = null;
        try {
            o = new ObjectMapper().readValue(new URL(url), Object.class);
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
