package edu.bsu.cs222;

public class Response {

    private String responseText;
    private String sentimentResponse;

    public Response(String responseText, String sentimentResponse) {
        this.responseText = responseText;
        this.sentimentResponse = sentimentResponse;
    }

    public String getResponseText() {
        return responseText;
    }

    public String getSentimentResponse() { return sentimentResponse; }
}