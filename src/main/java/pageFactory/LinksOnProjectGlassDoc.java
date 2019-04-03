package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LinksOnProjectGlassDoc extends PageObject {

    WebDriverWait wait;
    private static final int TIMEOUT = 7;
    private static final int POLLING = 100;

    String exampleProjectURL = "https://jira2.codecool.codecanvas.hu/" +
            "projects/SE?selectedItem=com.codecanvas.glass:glass";

    @FindBy(xpath = "//*[@id='glass-general-panel']/div[1]/div[1]/div/h2/a")
    WebElement basicSummaryLinkIcon;

    @FindBy(xpath = "//*[@id=\"project-edit\"]/div[1]/h2")
    WebElement subTitleOnBasicSummaryDetailsPage;

    @FindBy(xpath = "//*[@id='glass-general-components-panel']/div/h2/a")
    WebElement componentsLinkIcon;

    @FindBy(xpath = "//*[@id='content']/div[2]/div/section/header/div/div[2]/h2")
    WebElement subTitleOnComponentDetailsPage;

    @FindBy(xpath = "//*[@id='glass-people-nav']/a")
    WebElement peopleSubMenu;

    @FindBy(xpath = "//*[@id='glass-people-panel']/div/h2/a/span")
    WebElement peopleLinkIcon;

    @FindBy(xpath = "//*[@id='project-config-panel-roles']/div[1]/div/div[1]/h2")
    WebElement subTitleOnPeopleDetailsPage;

    List<WebElement> clickableIcons = new ArrayList<>();

    List<WebElement> validationFieldsForLinkIcons = new ArrayList<>();

    public List<WebElement> getClickableIcons() {
        return clickableIcons;
    }

    public List<WebElement> getValidationFieldsForLinkIcons() {
        return validationFieldsForLinkIcons;
    }

    public LinksOnProjectGlassDoc(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        addItemsToLists();
    }

    public void addItemsToLists() {
        clickableIcons.add(basicSummaryLinkIcon);
        clickableIcons.add(componentsLinkIcon);

        validationFieldsForLinkIcons.add(subTitleOnBasicSummaryDetailsPage);
        validationFieldsForLinkIcons.add(subTitleOnComponentDetailsPage);
    }

    public void switchTabFocus(int tabNumberToFocusOn) {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(tabNumberToFocusOn - 1));
    }

    public void getExampleProjectPage() {
        driver.get(exampleProjectURL);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void clickOnBasicSummaryLinkIcon() {
        basicSummaryLinkIcon.click();
    }

    public void clickOnComponentLinkIcon() {
        componentsLinkIcon.click();
    }

    public void clickOnPeopleLinkIcon() {
        wait.until(ExpectedConditions.visibilityOf(peopleSubMenu));
        peopleSubMenu.click();
        wait.until(ExpectedConditions.visibilityOf(peopleLinkIcon));
        peopleLinkIcon.click();
    }

    public String getSubTitleOnBasicSummaryDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(subTitleOnBasicSummaryDetailsPage));
        return subTitleOnBasicSummaryDetailsPage.getText();
    }

    public String getSubTitleOnComponentDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(subTitleOnComponentDetailsPage));
        return subTitleOnComponentDetailsPage.getText();
    }

    public String getSubTitleOnPeopleDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(subTitleOnPeopleDetailsPage));
        return subTitleOnPeopleDetailsPage.getText();
    }

    //TODO: versions, schemes links testing -> +1 step: click on versions/schemes before clicking on the link icon

    //TODO: notifications, permissions

}
