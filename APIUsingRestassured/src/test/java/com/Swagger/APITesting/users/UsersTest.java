package com.Swagger.APITesting.users;

import com.Swagger.APITesting.Users;
import com.Swagger.APITesting.UsersPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersTest {
    private UsersPage userPage;
    private Users users;
    private Users editUserInfo;

    @BeforeClass
    public void setup() {

        userPage = new UsersPage();
        users = new Users(10, "User 1", "Password1");
        editUserInfo=new Users(20, "User 20", "Password20");
    }

    @Test(priority = 1)
    public void testPostUser() {
        Response response = userPage.postUser(users);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
        //System.out.println("POST Response: " + response.asString());
        long startTime = System.currentTimeMillis();
        long responseTime = System.currentTimeMillis() - startTime;
        System.out.println("Response Time: " + responseTime + " ms");
        assert (responseTime < 200);
    }

    @Test(priority = 2)
    public void getUserWithQueryParam() {
        Response response = userPage.getUserWithQueryParam(10);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
        long startTime = System.currentTimeMillis();
        long responseTime = System.currentTimeMillis() - startTime;
        System.out.println("Response Time: " + responseTime + " ms");
        assert (responseTime < 200);
    }

    @Test(priority = 3)
    public void testPUTtUser() {
        Response response = userPage.putUser(20, editUserInfo);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
        long startTime = System.currentTimeMillis();
        long responseTime = System.currentTimeMillis() - startTime;
        System.out.println("Response Time: " + responseTime + " ms");
        assert (responseTime < 200);
    }

    @Test(priority = 5)
    public void testDeleteActivity() {
        Response response = userPage.deleteUser(10);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200 for successful deletion");
        System.out.println("DELETE Response:" + response.asString());
    }

    @Test(priority = 4)
    public void testGetUsers() {
        Response response =userPage.TestgetUser();
       // Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
        Assert.assertTrue(response.contentType().contains("application/json"), "Response content type should be application/json");
        System.out.println("GET users : " + response.asString());
}

}