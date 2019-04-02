package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageFactory.LinksOnProjectGlassDoc;
import pageFactory.Login;
import util.RunEnvironment;
import util.Utils;

import static org.junit.jupiter.api.Assertions.*;

class LinksOnProjectGlassDocTest {

    WebDriver driver;
    Login login;
    LinksOnProjectGlassDoc linksOnProjectGlassDoc;
    String exampleProjectTitle ="Scrum Example - Project Configuration Documentation";
    String exampleProjectTitleShort= "Scrum Example";

    @BeforeEach
    public void setup() {
        Utils.setupFromNode();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        linksOnProjectGlassDoc = new LinksOnProjectGlassDoc(driver);
        driver.manage().window().setSize(new Dimension(1280, 720));
        login.login();
    }

    @Test
    public void basicSummaryLink_test() {
        linksOnProjectGlassDoc.getExampleProjectPage();
        linksOnProjectGlassDoc.clickOnBasicSummaryLinkIcon();
        linksOnProjectGlassDoc.switchTabFocus(2);
        assertEquals(linksOnProjectGlassDoc.getExampleProjectNameOnDetailsPage(), exampleProjectTitleShort);
    }

    @Test
    public void componentsLink_test() throws InterruptedException {
        linksOnProjectGlassDoc.getExampleProjectPage();
        linksOnProjectGlassDoc.clickOnComponentLinkIcon();
        linksOnProjectGlassDoc.switchTabFocus(2);
        assertEquals(linksOnProjectGlassDoc.getSubTitleOnComponentDetailsPage(), "Components");
    }

    @AfterEach
    public void tearDown() {
        Utils.tearDown();
    }

}