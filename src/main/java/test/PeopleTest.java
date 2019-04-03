package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageFactory.Login;
import pageFactory.People;
import util.RunEnvironment;
import util.Utils;

public class PeopleTest {
    Login login;
    WebDriver driver;
    People people;

    @BeforeEach
    public void setup() {
        Utils.setup();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        people = new People(driver);
        driver.manage().window().setSize(new Dimension(800, 600));
        login.login();
    }

    @DisplayName("Test if People tab is present in GlassDoc view of a project.")
    @Test
    void testPeopleTabIsPresent() {
        Assertions.assertTrue(people.getPeopleTab());
    }

    @DisplayName("Click People tab and get panel.")
    @Test
    void testPeoplePanel() throws InterruptedException {
        Assertions.assertTrue(people.getPeoplePanel());
    }

//    @AfterEach
//    public void tearDown() {
//        Utils.tearDown();
//    }
}
