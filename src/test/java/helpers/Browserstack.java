package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {

    // curl -u "qaguru_ti9G5S:5yrxu4nFTKkRExUAhqxh" -X GET "https://api.browserstack.com/app-automate/sessions/0359d759d2aaa4f46401dac46bd281b6d9b24943.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                //.auth().basic("alex_qN6X0H", "r9siN8SFjHzuw37LHuDc")
                .auth().basic("maxcong_Gl8qwK", "6BbFx2UPgpeBxozc3esf")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
