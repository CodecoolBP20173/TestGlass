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

import static org.junit.jupiter.api.Assertions.assertTrue;

class LinksOnProjectGlassDocTest {

    WebDriver driver;
    Login login;
    LinksOnProjectGlassDoc linksOnProjectGlassDoc;

    @BeforeEach
    public void setup() {
        Utils.setupFromNode();
        driver = RunEnvironment.getWebDriver();
        login = new Login(driver);
        linksOnProjectGlassDoc = new LinksOnProjectGlassDoc(driver);
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @Test
    public void basicSummaryLink_test() {
        login.login();
        linksOnProjectGlassDoc.getExampleProjectPage();
        linksOnProjectGlassDoc.clickOnBasicSummaryLinkIcon();
        linksOnProjectGlassDoc.switchTabFocus(2);
        String exampleProjectNameOnBasicSummaryPage = linksOnProjectGlassDoc.getSubTitleOnBasicSummaryDetailsPage();
        assert(exampleProjectNameOnBasicSummaryPage.contains("Details"));
    }

    @Test
    public void componentsLink_test() {
        login.login();
        linksOnProjectGlassDoc.getExampleProjectPage();
        linksOnProjectGlassDoc.clickOnComponentLinkIcon();
        linksOnProjectGlassDoc.switchTabFocus(2);
        String subTitleOnComponentDetailsPage = linksOnProjectGlassDoc.getSubTitleOnComponentDetailsPage();
        assert(subTitleOnComponentDetailsPage.contains("Components"));
    }

    @Test
    public void peopleLink_test() {
        login.login();
        linksOnProjectGlassDoc.getExampleProjectPage();
        linksOnProjectGlassDoc.clickOnPeopleLinkIcon();
        linksOnProjectGlassDoc.switchTabFocus(2);
        String subTitleOnPeopleDetailsPage = linksOnProjectGlassDoc.getSubTitleOnPeopleDetailsPage();
        assert(subTitleOnPeopleDetailsPage.contains("Users and roles"));
    }

    @Test
    public void basicSummaryLinkWithNoPermission_test() {
        login.loginWithDashboard(System.getenv("username2"), System.getenv("password2"));
        linksOnProjectGlassDoc.getExampleProjectPage();
        assertTrue(linksOnProjectGlassDoc.checkIfBasicSummaryIconIsAvailable());
    }

    @AfterEach
    public void tearDown() {
        Utils.tearDown();
    }

}