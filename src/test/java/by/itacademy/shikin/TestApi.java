package by.itacademy.shikin;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class TestApi {

    @Test
    public void testGetLogin() {
        given().when().get("https://id.devby.io/@/hello").
                then().log().body();
    }

    @Test
    public void testWithCorrectEmailandPassword() {
        String body = "{\"user\":{\"login\":\"test@gmail.com\",\"password\":\"1234\"}}";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://id.devby.io");
        headers.put("Referer", "https://id.devby.io/@/hello");

        RestAssured.urlEncodingEnabled = false;

        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"error\":{\"message\":\"Неверный логин или пароль.\"}}"));
    }
    @Test
    public void testWithAnyEmailandEmptyPassword() {
        String body = "{\"user\":{\"login\":\"test@gmail.com\",\"password\":\"\"}}";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://id.devby.io");
        headers.put("Referer", "https://id.devby.io/@/hello");

        RestAssured.urlEncodingEnabled = false;

        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"error\":{\"message\":\"Неверный логин или пароль.\"}}"));
    }
    @Test
    public void testWithEmptyEmailandAnyPassword() {
        String body = "{\"user\":{\"login\":\"\",\"password\":\"1234\"}}";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://id.devby.io");
        headers.put("Referer", "https://id.devby.io/@/hello");

        RestAssured.urlEncodingEnabled = false;

        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"error\":{\"message\":\"Неверный логин или пароль.\"}}"));
    }
    @Test
    public void testWithActualCredentials() {
        String body = "{\"user\":{\"login\":\"taftestproject@gmail.com\",\"password\":\"Password1234\"}}";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://id.devby.io");
        headers.put("Referer", "https://id.devby.io/@/hello");

        RestAssured.urlEncodingEnabled = false;

        given().when().headers(headers).body(body).post("https://id.devby.io/@/hello").then()
                .assertThat().body(containsString("{\"success\":{\"redirect_url\":\"https://devby.io\",\"action\":null,\"message\":null,\"bad_phone\":null}}"));
    }
}
