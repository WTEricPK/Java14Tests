package org.example.loadtest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class ResponseStats {

    public static Map<String, Object> aggregateResponseCodes(final List<Response> responses) {

        final Map<String, Integer> count = responses.stream().collect(groupingBy(response -> "" + response.getResponseCode(), summingInt(res -> 1)));

        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = 0;
        for(final Response response : responses) {
            sum += response.getRequestDuration();
            min = Math.min(response.getRequestDuration(), min);
            max = Math.max(response.getRequestDuration(), max);
        }

        long mean = sum / (long) responses.size();
        return Map.of("counts", count, "max", max, "min", min, "mean" , mean);
    }
}
