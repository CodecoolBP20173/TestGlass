package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Schemes extends PageObject{

    @FindBy(xpath = "/*[@id='glass-general-panel']//div//ul//li//*[@id='aui-uid-3']")
    WebElement schemeButton;

    @FindBy(xpath = "//*[@id='glass-general-schemes-panel']//span[text()='Schemes ']")
    WebElement schemeTitle;

    @FindBy(id = "login-form-authenticatePassword")
    WebElement passwordField;

    @FindBy(id = "login-form-submit")
    WebElement submitPassword;

    @FindBy(xpath = "//*[@id='glass-general-schemes-panel']//table[@class='aui aui-table-sortable']//a[contains(@href,'')]")
    List<WebElement> optionButtons;

    public Schemes(WebDriver driver) {
        super(driver);
    }

    public void navigationToGlassDocumentation() {
        driver.get("https://jira2.codecool.codecanvas.hu/projects/SE?selectedItem=com.codecanvas.glass:glass");
    }

    public void openSchemes() {
        wait.until(ExpectedConditions.visibilityOf(schemeButton));
        schemeButton.click();
    }

    public String getSchemeTitle() {
        return schemeTitle.getText();
    }

    public void openSchemeOptions(String schemeName) {
        driver.findElement(By.xpath("//*[@id='glass-general-schemes-panel']//table[@class='aui aui-table-sortable']//a[contains(@href,'"+ schemeName +"')]")).click();
    }

    public boolean openSchemeOptionVisible() {
        if (optionButtons.size() == 0) {
            return true;
        }else {
            return false;
        }
    }

    public String getNewWindowTitle() {
        return driver.getTitle();
    }

    public List<String> getWindows() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        return browserTabs;
    }

    public void validatePassword() {
        passwordField.sendKeys(System.getenv("password"));
        submitPassword.click();
    }

}
