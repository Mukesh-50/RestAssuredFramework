package base;

import java.util.Map;

import org.testng.annotations.BeforeClass;

import config.ConfigManager;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import specs.RequestSpec;

public class BaseClass {
	RequestSpecification requestSpec;

	@BeforeClass
	public void setup() {
		System.out.println("******* Running Setup *********");

		requestSpec = RequestSpec.spec();
		
		generateAndStoreToken();

	}

	public void generateAndStoreToken() {
		// Wrapper Class

		// String - Integer

		// String - Double

		// String - Boolean

		boolean regenrate = Boolean.parseBoolean(ConfigManager.getPropertyFromConfig("regerate"));

		String currentToken = ConfigManager.getPropertyFromConfig("token");

		if (regenrate || currentToken == null || currentToken.equals("null") || currentToken.isEmpty()) 
		{

			RequestSpecification spec = RequestSpec.spec().basePath("/auth")
					.body("{\n" + "    \"username\" : \"admin\",\n" + "    \"password\" : \"password123\"\n" + "}");

			Response resp = given().spec(spec).post();

			String tokenValue = resp.jsonPath().getString("token");

			if (tokenValue != null) {
				ConfigManager.updatePropertyfile("token", tokenValue);

			} else {
				System.out.println("Failed to generate new token");
			}

		} else {
			System.out.println("Token Present In Config file - Reusing The Same");
		}

	}

	protected Response sendRequest(String method, String resourceName, Object payload,
			Map<String, Object> headersForAPI, Map<String, Object> queryParameterForAPI, String authtoken) {

		RequestSpecification req = given().spec(requestSpec);

		if (headersForAPI != null) {
			req.headers(headersForAPI);
		}

		if (queryParameterForAPI != null) {
			req.queryParams(queryParameterForAPI);
		}

		if (payload != null) {
			req.body(payload);
		}

		if (authtoken != null) {
			req.auth().preemptive().oauth2(authtoken);
		}

		// Get, GET, get
		switch (method.toUpperCase()) {
		case "GET":
			return req.when().get(resourceName);

		case "POST":
			return req.when().post(resourceName);

		case "PUT":
			return req.when().put(resourceName);

		case "PATCH":
			return req.when().patch(resourceName);

		case "DELETE":
			return req.when().delete(resourceName);

		default:
			throw new IllegalArgumentException(
					"Sorry current we dont support " + method + " Please use GET,POST,PUT,PATCH,DELETE ");

		}

	}

	public Response sendRequest(String method, String resourceName, Object payload) {
		return sendRequest(method, resourceName, payload, null, null, null);
	}

	public Response sendRequest(String method, String resourceName, Object payload, Map<String, Object> headers) {
		return sendRequest(method, resourceName, payload, headers, null, null);
	}

	public Response sendRequest(String method, String resourceName, Object payload, Map<String, Object> headers,
			Map<String, Object> query) {
		return sendRequest(method, resourceName, payload, headers, query, null);
	}

}
