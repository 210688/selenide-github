package souptests;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class SoupTest {
    @Test
    void getCountriesTest() {
        String request;
        InputStream is = SoupTest.class.getClassLoader().getResourceAsStream("getCountryRequest.xml");
    }
}
