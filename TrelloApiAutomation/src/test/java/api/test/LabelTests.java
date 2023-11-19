package api.test;

import api.endpoints.LabelEndpoints;
import api.payload.Label;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class LabelTests {

    Label labelPayload;

    @BeforeClass
    public void setUpData() {


        labelPayload = new Label();


        labelPayload.setIdBoard("6558855098b10c285dc71d91");
        labelPayload.setId("6558dc8698fe6f8b99925aa8");
        labelPayload.setName("ITI");
        labelPayload.setColor("red");
        System.out.println(labelPayload.getIdBoard());
        System.out.println(labelPayload.getName());
        System.out.println(labelPayload.getLabelColor());

    }

    @Test(priority =1)
    public void testPostCard() {
        //testing on element of third list

        Response response = LabelEndpoints.createLabel(labelPayload);
        Assert.assertEquals(response.getStatusCode(), 200);
        response.then()
                .body("idBoard", equalTo("6558855098b10c285dc71d91"));

    }

    @Test(priority =2)
    public void testGetLabelByID() {
        //testing on first element of second list

        Response response = LabelEndpoints.getLabel("6558dc8698fe6f8b99925aa8");
        response.then().log().all()
                .body("id", equalTo("6558dc8698fe6f8b99925aa8"))
                .body("idBoard", equalTo("6558855098b10c285dc71d91"))
                .body("name", equalTo("ITI"));
    }

    @Test(priority =3)
    public void testUpdateLabelById() {

        this.labelPayload.setName("ITI Testing");

        Response response =
                LabelEndpoints.updateLabel(this.labelPayload.getId(), labelPayload);
        response.then().log().body()
                .body("name", equalTo("ITI Testing"));
        Assert.assertEquals(response.getStatusCode(), 200);






    }

    @Test(priority = 4)
    public void testDeleteLabelById() {
        Response response =
                LabelEndpoints.deleteLabel("6558dc8698fe6f8b99925aa8");
        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
