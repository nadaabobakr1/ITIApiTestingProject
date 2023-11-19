package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.Label;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LabelEndpoints {


    public static Response createLabel(Label payload){


        Response response =
                given()
                        .pathParam("idBoard", payload.getIdBoard())
                        .pathParam("name", payload.getName())
                        .pathParam("color", payload.getLabelColor())
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                        .when()
                        .post(Routes.post_label_url);

        return response;

    }

    public static Response getLabel(String id){


        Response response =
                given()
                        .pathParam("id",id)
                        .when()
                        .get(Routes.get_label_url);

        return response;

    }

    public static Response updateLabel(String id, Label payload){


        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .pathParam("id",id)
                        .body(payload)
                        .when()
                        .put(Routes.update_label_url);

        return response;

    }

    public static Response deleteLabel(String id){


        Response response =
                given()
                        .pathParam("id",id)
                        .when()
                        .delete(Routes.delete_label_url);

        return response;

    }
}
