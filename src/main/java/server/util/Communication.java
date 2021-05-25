package server.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.Test;
import server.model.TestCase;
import server.model.TestCaseCatalog;
import server.model.Tester;

import java.util.List;

public class Communication {

    public static Tester authenticate(String email, String password) {
        String jsonString = String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password);
        String path = HttpConnection.API_URL + "/tester/auth";
        Response<String> response = HttpConnection.post(path, jsonString);
        if(response.getStatus() != 200) {
            return null;
        }

        JsonNode node = null;
        try {
            System.out.println(response.getBody());
            node = Json.parse(response.getBody());
            Tester tester = Json.fromJson(node, Tester.class);
            return tester;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadTestCases(Tester tester) {
        TestCaseCatalog testCaseCatalog = new TestCaseCatalog();
        
    }

}
