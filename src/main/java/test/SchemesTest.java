package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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

    @DisplayName("Open scheme options from Glass")
    @ParameterizedTest
    @CsvFileSource(resources = "/schemes/scheme-types.csv")
    void schemeNavigationTest(String selectedScheme, String SchemeTitle) {
        driver.get("https://jira2.codecool.codecanvas.hu/projects/SE?selectedItem=com.codecanvas.glass:glass");
        schemes.openSchemes();
        Assertions.assertEquals("Schemes", schemes.getSchemeTitle(), "Navigation schemes");
        schemes.openSchemeOptions(selectedScheme);
        driver.switchTo().window(schemes.getWindows().get(1));
        schemes.validatePassword();
        Assertions.assertEquals(SchemeTitle, schemes.getNewWindowTitle(), "The link redirect to the right page");
    }

    @AfterEach
    public void tearDown() {
        Utils.tearDown();
    }

}
