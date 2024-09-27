package com.Swagger.APITesting.activity;

import com.Swagger.APITesting.Activity;
import com.Swagger.APITesting.ActivityPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ActivityTest {
    private ActivityPage activityAPI;
    private Activity testActivity;

    @BeforeClass
    public void setUp() {
        activityAPI = new ActivityPage();
        testActivity = new Activity(0, "Test Activity", "2024-09-10T15:10:53.471Z", true);
    }

    @Test
    public void testPostActivity() {
        Response response = activityAPI.postActivity(testActivity);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
        System.out.println("POST Response: " + response.asString());
    }

    @Test(dependsOnMethods = "testPostActivity")
    public void testGetActivity() {
        Response response = activityAPI.getActivity(1); // Assuming the ID is 1

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

        // Assert response time
        Assert.assertTrue(response.time()< 500, "Response time should be less than 500 ms");
        Assert.assertTrue(response.contentType().contains("application/json"), "Response content type should be application/json");
        // Assert response body contains the expected string
        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("Activity 1"), "Response body should contain 'Activity 1'");

        System.out.println("GET Response: " + response.asString());

    }



    @Test(dependsOnMethods = "testPostActivity")
    public void testPutActivity() {
        Activity updatedActivity = new Activity(1, "Updated Activity", "2024-10-10T15:10:53.471Z", false);

        Response response = activityAPI.putActivity(1, updatedActivity); // Assuming the ID is 1

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
        Assert.assertTrue(response.time()< 700, "Response time should be less than 500 ms");
        System.out.println("PUT Response:" + response.asString());


    }

    @Test(dependsOnMethods = "testPostActivity")
    public void testDeleteActivity() {
        Response response = activityAPI.deleteActivity(1); // Assuming the ID is 1
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200 for successful deletion");
        System.out.println("DELETE Response:" + response.asString());

    }


    @Test
    public void testGetActivitiesWithQueryParams() {
        Response response = activityAPI.getActivitiesWithQueryParams(2); // Example query param

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
        Assert.assertTrue(response.contentType().contains("application/json"), "Response content type should be application/json");
        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("Title"), "Response body should contain 'Title'");

        // Get the response body as a string
        System.out.println("***********GET with Query Params Response: ********" + response.asString());

    }
}
