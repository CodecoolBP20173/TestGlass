package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LinksOnProjectGlassDoc extends PageObject {

    String exampleProjectURL = "https://jira2.codecool.codecanvas.hu/" +
            "projects/SE?selectedItem=com.codecanvas.glass:glass";

    @FindBy(xpath = "//*[@id='glass-general-panel']/div[1]/div[1]/div/h2/a")
    WebElement basicSummaryLinkIcon;

    @FindBy(xpath = "//*[@id='project-edit']//div[contains(@class, 'field-group')]/input")
    WebElement exampleProjectNameOnDetailsPage;

    public LinksOnProjectGlassDoc(WebDriver driver) {
        super(driver);
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

    public String getExampleProjectNameOnDetailsPage() {
        return exampleProjectNameOnDetailsPage.getAttribute("value");
    }


}
