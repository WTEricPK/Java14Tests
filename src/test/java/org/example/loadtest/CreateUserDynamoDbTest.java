package org.example.loadtest;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.example.loadtest.APIDetails.*;
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

    private static final int NUMBER_REQUESTS = 100;

    private static final ApiRequestTestHelper HELPER = new ApiRequestTestHelper();


    private static final String PATH = "user-dynamodb";


    @Test
    public void createUserJs(){
        HELPER.test(JAVASCRIPT_API_ID, NODEJS, NODEJS, PATH, USER_BODY, NUMBER_REQUESTS);
    }

    @Test
    public void createUserPlaneJavaJvm(){
        HELPER.test(PLANE_JAVA_API_ID, PLAIN_JAVA, JVM, PATH, USER_BODY, NUMBER_REQUESTS);
    }
    @Test
    public void createUserPlaneJavaGraalVm(){
        HELPER.test(PLANE_JAVA_API_ID, PLAIN_JAVA, GRAALVM, PATH, USER_BODY, NUMBER_REQUESTS);
    }

    @Test
    public void createUserQuarkusJvm(){
        HELPER.test(QUARQUS_API_ID, QUARKUS, JVM, PATH, USER_BODY, NUMBER_REQUESTS);
    }

    @Test
    public void createUserQuarkusGraalVm(){
        HELPER.test(QUARQUS_API_ID, QUARKUS, GRAALVM, PATH, USER_BODY, NUMBER_REQUESTS);
    }
    @Test
    public void createUserSpringJvm(){
        HELPER.test(SPRING_API_ID, SPRING, JVM, PATH, USER_BODY, NUMBER_REQUESTS);
    }
//    public void createUserSpringGraalVm(){
//        HELPER.test(PLANE_JAVA_API_ID, QUARKUS, GRAALVM, PATH, USER_BODY, NUMBER_REQUESTS);
//    }
    @Test
    public void createUserMicronautJvm(){
        HELPER.test(MICRONAUT_API_ID, MICRONAUT, JVM, PATH, USER_BODY, NUMBER_REQUESTS);
    }

    @Test
    public void createUserMicronautGraalVm(){
        HELPER.test(MICRONAUT_API_ID, MICRONAUT, GRAALVM, PATH, USER_BODY, NUMBER_REQUESTS);
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

