package org.example.loadtest;


import java.util.List;
import java.util.Objects;

public class AWSTestUrl {

    private String url;

    private AWSTestUrl(final String url) {
        this.url = url;
    }


    public String url() {
        return url;
    }

    public static class Builder {

        private String http = "https://";

        private String apiId;
        private String awsUrl;
        private String runtime;
        private String framework;
        private String path;

        public Builder() {
            awsUrl = ".execute-api.eu-west-2.amazonaws.com/";
        }

        public Builder setApiId(final String apiId) {

            this.apiId = apiId;

            return this;
        }

        public Builder setRuntime(final String runtime) {
            assertTrue(List.of("java", "graalvm", "javascript").contains(runtime), "Invalid runtime value: " + runtime + ".");
            this.runtime = runtime;

            return this;
        }

        public Builder setFramework(final String framework) {
            this.framework = framework;

            return this;
        }

        public Builder setPath(final String path) {
            this.path = path;

            return this;
        }

        public AWSTestUrl build()
        {
            Objects.requireNonNull(awsUrl, "An AWS url is required.");
            Objects.requireNonNull(runtime, "A runtime value is required.");
            Objects.requireNonNull(framework, "A Framework is required.");
            Objects.requireNonNull(path, "A path is required.");
            Objects.requireNonNull(apiId, "An API ID is required.");

            return new AWSTestUrl( http + apiId + awsUrl + framework + "/" + runtime + "/" + path);
        }


        private void assertTrue(boolean value, final String message) {
            if(!value) {
                throw new IllegalArgumentException(message);
            }
        }
    }

}
