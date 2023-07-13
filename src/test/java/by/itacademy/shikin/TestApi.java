package by.itacademy.shikin;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class TestApi {

    @Test
    public void testGetSearch() {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("filter[search]", "software engineer");
        given().queryParams(queryParams).when().get("https://jobs.devby.io").
                then().assertThat().body(containsString("software engineer"));
    }

    @Test
    public void testWithCorrectEmailandPassword() {
        PageApi page = new PageApi();
        String body = "{\"user\":{\"login\":\"test@gmail.com\",\"password\":\"1234\"}}";
        HashMap<String, String> headers = page.getHeaders();
        RestAssured.urlEncodingEnabled = false;
        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"error\":{\"message\":\"Неверный логин или пароль.\"}}"));
    }

    @Test
    public void testWithAnyEmailandEmptyPassword() {
        String body = "{\"user\":{\"login\":\"test@gmail.com\",\"password\":\"\"}}";
        PageApi page = new PageApi();
        HashMap<String, String> headers = page.getHeaders();
        RestAssured.urlEncodingEnabled = false;
        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"error\":{\"message\":\"Неверный логин или пароль.\"}}"));
    }

    @Test
    public void testWithEmptyEmailandAnyPassword() {
        String body = "{\"user\":{\"login\":\"\",\"password\":\"1234\"}}";
        PageApi page = new PageApi();
        HashMap<String, String> headers = page.getHeaders();
        RestAssured.urlEncodingEnabled = false;
        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"error\":{\"message\":\"Неверный логин или пароль.\"}}"));
    }

    @Test
    public void testWithActualCredentials() {
        String body = "{\"user\":{\"login\":\"taftestproject@gmail.com\",\"password\":\"Password1234\"}}";
        PageApi page = new PageApi();
        HashMap<String, String> headers = page.getHeaders();
        RestAssured.urlEncodingEnabled = false;
        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"success\":{\"redirect_url\":\"https://devby.io\",\"action\":null,\"message\":null,\"bad_phone\":null}}"));
    }
}
