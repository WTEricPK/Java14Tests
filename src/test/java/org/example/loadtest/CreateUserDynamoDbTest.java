package org.example.loadtest;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.example.loadtest.APIDetails.JAVASCRIPT_API_ID;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateUserDynamoDbTest  {

    private static final String FIRST_NAME = "firstName";
    private static final String SURNAME = "surname";
    private static final String EMAIL_ADDRESS = "emailAddress";
    private static final String DOB = "dob";
    private static final String PASSWORD = "password";

    private static final String ID = "id";
    private static final String FIRST_NAME_VALUE = "John";
    private static final String SURNAME_VALUE = "Smith";
    private static final String EMAIL_ADDRESS_VALUE = "johnsmith@email.com";
    private static final String DOB_VALUE = "01011970";
    private static final String PASSWORD_VALUE = "password123";
    private static final JSONObject USER_BODY =  createUserBody();

    private static final int NUMBER_REQUESTS = 20;

    private final AWSTestUrl.Builder urlBuilder = new AWSTestUrl.Builder().setPath("user");

    @Test
    public void createUserDynamoDbTestJs() throws Exception {

        // Given
        final String url = urlBuilder.setApiId(JAVASCRIPT_API_ID).setFramework("javascript").setRuntime("javascript").build().url();
        // When
        final List<Response> responses = testRunner(url, USER_BODY, NUMBER_REQUESTS);
        // Then
        assertResults(responses);
    }


    private void assertResults(final List<Response> responses) {
        final Map<String, Object> stats = ResponseStats.aggregateResponseCodes(responses);
        System.out.println(stats);
        assertTrue(((Map)stats.get("counts")).containsKey("200"), "No requests were successful.");
    }

    private List<Response> testRunner(final String url, final JSONObject body, final int nRequests) throws Exception {
        final Map<String, String> headers = Map.of("Content-Type", "application/json");
        final List<Response> responses = new ArrayList<>();
        for(int i = 0; i < nRequests; i++) {
            final Response response = StaticRequests.sendPOST(url, body.toString(), headers);
            responses.add(response);
        }
        return responses;
    }

    private static JSONObject createUserBody() {
        final JSONObject requestBody = new JSONObject();
        requestBody.put(FIRST_NAME, FIRST_NAME_VALUE);
        requestBody.put(SURNAME, SURNAME_VALUE);
        requestBody.put(EMAIL_ADDRESS, EMAIL_ADDRESS_VALUE);
        requestBody.put(DOB, DOB_VALUE);
        requestBody.put(PASSWORD, PASSWORD_VALUE);
        return requestBody;
    }

}

