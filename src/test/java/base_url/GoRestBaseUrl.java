package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.ConfigurationReader;

public class GoRestBaseUrl {
    protected static RequestSpecification spec;
    @Before
    public void SetUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();
    }
}
