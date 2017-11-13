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

public class KeywordParser {

    public KeywordList extractKeywords(String text) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("http://api.cortical.io:80/rest/text/keywords?retina_name=en_associative")
                .header("api-key: 84d21ef0-c509-11e7-9586-f796ac0731fb", "Content-Type: application/json")
                .body(text)
                .asJson();
        return convertJsonToKeywordList(parseJson(response.getRawBody()));
    }

    private JsonElement parseJson(InputStream response) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(response);
        return parser.parse(reader);
    }

    private KeywordList convertJsonToKeywordList(JsonElement element) {
        KeywordList words = new KeywordList();
        JsonArray array = element.getAsJsonArray();
        for (JsonElement i : array) {
            words.add(new Keyword(i.getAsString()) );
        }
        return words;
    }
}