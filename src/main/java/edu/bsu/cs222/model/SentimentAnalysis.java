package edu.bsu.cs222.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class SentimentAnalysis {

    public String getSentiment(String text) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("http://api.meaningcloud.com/sentiment-2.1")
                .header("content-type", "application/x-www-form-urlencoded")
                .body("key=d408eb718117f7498ebe1c8faf67ebdf" + "&txt=" + text + "&lang=en")
                .asJson();

        return jsonElementToString(parseResponse(response.getRawBody()));
    }

    private JsonElement parseResponse(InputStream response) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(response);
        return parser.parse(reader);
    }

    private String jsonElementToString(JsonElement element) {
        JsonObject object = element.getAsJsonObject();
        String result = object.get("score_tag").toString();
        //clean up extra ""
        return result.replace("\"", "");
    }
}