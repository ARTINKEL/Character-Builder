package edu.bsu.cs222.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class KeywordParser {

    public ArrayList<String> extractKeywords(String text) throws UnirestException, UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("http://api.cortical.io:80/rest/text/keywords?retina_name=en_associative")
                .header("api-key: 84d21ef0-c509-11e7-9586-f796ac0731fb", "Content-Type: application/json")
                .body(text)
                .asJson();
        return convertJsonToArrayList( parseJson(response.getRawBody()) );
    }

    private JsonElement parseJson(InputStream response) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(response);
        return parser.parse(reader);
    }

    private ArrayList<String> convertJsonToArrayList(JsonElement element) {
        ArrayList<String> words = new ArrayList<>();

        JsonArray array = element.getAsJsonArray();
        for (JsonElement i : array) {
            words.add(i.getAsString());
        }
        return words;
    }
}