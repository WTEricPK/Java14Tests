package org.example.loadtest;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.example.loadtest.APIDetails.JAVASCRIPT_API_ID;

/**
 * https://www.loadtest4j.org/
 */
public class CreateUserLoadTest {

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

    private static ApiRequestTestHelper HELPER = new ApiRequestTestHelper();

    @Test
    public void createUserJs(){
        HELPER.test(JAVASCRIPT_API_ID, "javascript", "javascript", "user", USER_BODY, NUMBER_REQUESTS);
    }

    public void createUserPlaneJavaJvm(){}
    public void createUserPlaneJavaGraalVm(){}
    public void createUserQuarkusJvm(){}
    public void createUserQuarkusGraalVm(){}
    public void createUserSpringJvm(){}
    public void createUserSpringGraalVm(){}
    public void createUserMicronautJvm(){}
    public void createUserMicronautGraalVm(){}


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
