package server.controller;

import org.apache.http.HttpStatus;
import server.model.TestUser;
import server.service.TestUserService;
import server.util.Response;

import java.util.Collection;

public class TestUserController {

    private TestUserService testUserService;

    public Response<?> createTestUser(TestUser testUser) {
        String path = "/testusers/" + testUser.getId();
        // turn to json with post
        testUserService.create(testUser);
        return new Response<>("Updated user success", HttpStatus.SC_OK);
    }

    public Response<?> updateTestUser(Long id) {
        String path = "/testusers/" + id;
        // turn to json with put
        testUserService.update(id);
        return new Response<>("Updated user success", HttpStatus.SC_OK);
    }

    public Response<?> deleteTestUser(Long id) {
        String path = "/testusers/" + id;
        // turn to json with delete
        testUserService.delete(id);
        return new Response<>("Updated user success", HttpStatus.SC_OK);
    }

    public Response<?> getTestUsers() {
        String path = "/testusers";
        return new Response<>(testUserService.getCollection(), HttpStatus.SC_OK);
    }

    public Response<?> getTestUsersFromTestCase(Long id) {
        String path = "testcase/" + id + "/testusers";
        return new Response<>(testUserService.getCollection(), HttpStatus.SC_OK);
    }
}
