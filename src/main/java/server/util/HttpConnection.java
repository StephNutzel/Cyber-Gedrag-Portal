package server.util;

import org.apache.commons.httpclient.HttpStatus;

import java.io.*;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {

    public static final String API_URL;

    public static Response<String> get(String path, String authenticator) {
        HttpURLConnection connection = setupConnect("GET", path, authenticator);
        return readResponse(connection);
    }

    public static Response<String> put(String path, String jsonString, String authenticator) {
        HttpURLConnection connection = setupConnect("PUT", path, authenticator);
        sendRequest(jsonString, connection);
        return readResponse(connection);
    }


    public static Response<String> post(String path, String jsonString, String authenticator) {
        HttpURLConnection connection = setupConnect("POST", path, authenticator);
        sendRequest(jsonString, connection);
        return readResponse(connection);
    }


    public static Response<String> delete(String path, String authenticator) {
        return readResponse(setupConnect("DELETE", path, authenticator));
    }

    private static HttpURLConnection setupConnect(String method, String path, String authenticator) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod(method);
            if(authenticator != null) {
                connection.setRequestProperty("Authorization", "Bearer " + authenticator);
            }
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void sendRequest(String jsonString, HttpURLConnection connection) {
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Response<String> readResponse(HttpURLConnection connection) {
        StringBuilder response = new StringBuilder();
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return new Response<>(response.toString(), HttpStatus.SC_OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Response<>("failed connection", HttpStatus.SC_NOT_FOUND);
    }

    static {
        API_URL = "http://40.113.140.15:8080";
    }
}
