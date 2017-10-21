package edu.bsu.cs222.model;

import java.util.Arrays;
import java.util.List;

public class ResponseParser {
    public List<String> splitResponse(Response response) {
        return Arrays.asList(response.getResponseText().split(" "));
    }
}