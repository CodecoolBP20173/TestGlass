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

    @FindBy(xpath = "//*[@id='project-edit']//div[contains(@class, 'field-group')]/input")
    WebElement exampleProjectNameOnDetailsPage;

    @FindBy(xpath = "//*[@id='glass-general-components-panel']/div/h2/a")
    WebElement componentsLinkIcon;

    @FindBy(xpath = "//*[@id='content']/div[2]/div/section/header/div/div[2]/h2")
    WebElement subTitleOnComponentDetailsPage;

    public LinksOnProjectGlassDoc(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    public void switchTabFocus(int tabNumberToFocusOn) {
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(tabNumberToFocusOn - 1));
    }

    public void getExampleProjectPage() {
        driver.get(exampleProjectURL);
    }

    public void clickOnBasicSummaryLinkIcon() {
        basicSummaryLinkIcon.click();
    }

    public void clickOnComponentLinkIcon() {
        componentsLinkIcon.click();
    }

    public String getExampleProjectNameOnDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(exampleProjectNameOnDetailsPage));
        return exampleProjectNameOnDetailsPage.getAttribute("value");
    }

    public String getSubTitleOnComponentDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(subTitleOnComponentDetailsPage));
        return subTitleOnComponentDetailsPage.getText();
    }

}
