package by.itacademy.shikin.api;

import java.util.HashMap;

public class PageApi {

    public HashMap<String, String> getHeaders(){
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("Origin", "https://id.devby.io");
        headers.put("Referer", "https://id.devby.io/@/hello");
        return headers;
    }
}
