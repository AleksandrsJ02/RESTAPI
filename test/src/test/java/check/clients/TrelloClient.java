package check.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static check.constants.ProjectConstants.API_KEY;
import static check.constants.ProjectConstants.API_TOKEN;

public class TrelloClient {

    public static Response getBoardInfo(String boardId) {
        return RestAssured.
                given().
                contentType(ContentType.JSON).
                queryParam("key", API_KEY).
                queryParam("token", API_TOKEN).
                when().
                get("https://api.trello.com/1/boards/" + boardId).
                then().
                statusCode(200).
                extract().response();
    }

    public static  Response changeBoardName(String name, String boardId) {
        return RestAssured.
                given().
                contentType(ContentType.JSON).
                queryParam("key", API_KEY).
                queryParam("token", API_TOKEN).
                queryParam("name", name).
                when().
                put("https://api.trello.com/1/boards/" + boardId).
                then().log().all().
                statusCode(200).
                extract().response();
    }

    public static Response createList(String name, String boardId) {
        return RestAssured.
                given().
                contentType(ContentType.JSON).
                queryParam("key", API_KEY).
                queryParam("token", API_TOKEN).
                queryParam("name", name).
                queryParam("idBoard", boardId).
                when().
                post("https://api.trello.com/1/lists?= " + name + "&" + boardId).
                then().log().all().
                statusCode(200).
                extract().response();
    }

    public static Response deleteList(String id) {
        return RestAssured.
                given().
                contentType(ContentType.JSON).
                queryParam("key", API_KEY).
                queryParam("token", API_TOKEN).
                queryParam("closed", true).
                when().
                put("https://api.trello.com/1/lists/" + id).
                then().log().all().
                statusCode(200).
                extract().response();
    }
}
