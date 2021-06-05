package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    protected Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com/";
    }
}
