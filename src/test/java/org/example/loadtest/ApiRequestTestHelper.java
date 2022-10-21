package org.example.loadtest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiRequestTestHelper {


    public ApiRequestTestHelper() {

    }

    public void test(final String apiId, final String framework, final String runtime, final String path, final JSONObject body, final int nRequests) {
        final String currentTest = "Test with: apiId: " + apiId + ", framework: " + framework + ", runtime: " + runtime + ", path: " + path + ".";
        System.out.println(currentTest);
        // Given
        final String url = new AWSTestUrl.Builder().setApiId(apiId).setFramework(framework).setRuntime(runtime).setPath(path).build().url();
        try {
            // When
            final List<Response> responses = requestRunner(url, body, nRequests);
            // Then
            assertResults(responses);
        } catch (Exception ex) {
            assertTrue(false, ex.getMessage());
        }
    }


    public void assertResults(final List<Response> responses) {
        final Map<String, Object> stats = ResponseStats.aggregateResponseCodes(responses);
        System.out.println(stats);
        assertTrue(((Map)stats.get("counts")).containsKey("200"), "No requests were successful.");
    }


    public List<Response> requestRunner(final String url, final JSONObject body, final int nRequests) throws Exception {
        final Map<String, String> headers = Map.of("Content-Type", "application/json");
        final List<Response> responses = new ArrayList<>();
        for(int i = 0; i < nRequests; i++) {
            final Response response = StaticRequests.sendPOST(url, body.toString(), headers);
            responses.add(response);
        }
        return responses;
    }

}
