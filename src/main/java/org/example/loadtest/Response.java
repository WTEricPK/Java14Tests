package org.example.loadtest;

public class Response {

    private final int responseCode;

    private final String body;

    private final long requestDuration;

    public Response(final int responseCode, final String body, final long requestDuration) {
        this.responseCode = responseCode;
        this.body = body;
        this.requestDuration = requestDuration;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getBody() {
        return body;
    }

    public long getRequestDuration() {
        return requestDuration;
    }

}
