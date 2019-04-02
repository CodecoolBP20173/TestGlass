package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageFactory.Login;
import util.RunEnvironment;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login;
    WebDriver driver;

    @BeforeEach
    public void setup() {
        Utils.setupFromNode();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @Test
    void testLogin() {
        login.login();
        Assertions.assertTrue(login.isLoggedIn());
    }

    @AfterEach
    public void tearDown() {
        Utils.tearDown();
    }
}
