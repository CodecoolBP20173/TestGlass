package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class People {

    protected final int WAIT_TIMEOUT = 20;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public People(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, this.WAIT_TIMEOUT);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@id=\"glass-people-nav\"]/a")
    WebElement peopleTab;

    @FindBy(id = "glass-people-panel")
    WebElement peoplePanel;

    public boolean getPeopleTab() {
        driver.get("https://jira2.codecool.codecanvas.hu/projects/SE?selectedItem=com.codecanvas.glass:glass");
        return peopleTab.isDisplayed();
    }

    public boolean getPeoplePanel() throws InterruptedException {
        getPeopleTab();
        peopleTab.click();
        return peoplePanel.isDisplayed();
    }
}
