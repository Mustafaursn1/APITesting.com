package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.ConfigurationReader;

public class DummyRestApiBaseUrl {
    protected static RequestSpecification spec;
    @Before
    public void SetUp() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("https://dummy.restapiexample.com/api/v1")).build();
    }
}
