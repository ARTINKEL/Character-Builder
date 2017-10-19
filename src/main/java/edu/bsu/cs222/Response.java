package edu.bsu.cs222;

public class Response {

    private enum SENTIMENT_RESPONSE {
        PPlus, P, Neu, N, NPlus, NONE
    }

    private String responseText;
    SENTIMENT_RESPONSE sentimentResponse;

    public Response(String responseText, SENTIMENT_RESPONSE sentimentResponse) {
        this.responseText = responseText;
        this.sentimentResponse = sentimentResponse;
    }
}
