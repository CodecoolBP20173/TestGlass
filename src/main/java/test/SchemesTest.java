package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageFactory.Login;
import pageFactory.Schemes;
import util.RunEnvironment;
import util.Utils;

public class SchemesTest {

    Login login;
    Schemes schemes;
    WebDriver driver;

    @BeforeEach
    public void setup() {
        Utils.setupFromNode();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        schemes = new Schemes(driver);
        driver.manage().window().setSize(new Dimension(1280, 720));
        login.login();
    }

    @DisplayName("This is a test test")
    @Test
    void schemeNavigationTest() {
        driver.get("https://jira2.codecool.codecanvas.hu/projects/SE?selectedItem=com.codecanvas.glass:glass");
        schemes.openSchemes();
        Assertions.assertEquals("Schemes", schemes.getSchemeTitle(), "Navigation schemes");
        schemes.openSchemeOptions("IssueType");
        driver.switchTo().window(schemes.getWindows().get(1));
        schemes.validatePassword();
        System.out.println("Get title");
        System.out.println(schemes.newWindowTitle());
        System.out.println("Got title");


    }

    /*@AfterEach
    public void tearDown() {
        Utils.tearDown();
    }*/

}
