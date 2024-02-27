package ru.gosuslugi.api.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.junit.Assert;
import com.google.gson.*;

public class LkApiSteps {

    public Response getOrderStatus(String token, String orderId) {
        Response response = given().baseUri("http://p00svcdevpgulkapinlb.m9.egov.local/")
                .cookie("acc_t", token)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .get("/api/lk/v1/orders/{id}/result", orderId);

        String jsonResponse = response.getBody().asString();
        //System.out.println("Response: " + jsonResponse);

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

        JsonObject order = jsonObject.getAsJsonObject("order");
        JsonArray statuses = order.getAsJsonArray("statuses");
        boolean statusId21Found = false;
        for (JsonElement status : statuses) {
            JsonObject statusObject = status.getAsJsonObject();
            if (statusObject.has("statusId")) {
                int statusId = statusObject.get("statusId").getAsInt();
                if (statusId == 21) {
                    System.out.println("statusId: " + statusId);
                    statusId21Found = true;
                }
            }
        }
        Assert.assertTrue("statusId: 21 не найден", statusId21Found);

        return response;
    }
}
