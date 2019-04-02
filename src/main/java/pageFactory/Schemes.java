package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Schemes extends PageObject{

    @FindBy(id = "aui-uid-3")
    WebElement schemeButton;

    @FindBy(xpath = "//*[@id='glass-general-schemes-panel']//span[text()='Schemes ']")
    WebElement schemeTitle;

    @FindBy(id = "login-form-authenticatePassword")
    WebElement passwordField;

    @FindBy(id = "login-form-submit")
    WebElement submitPassword;
    
    public Schemes(WebDriver driver) {
        super(driver);
    }

    public void openSchemes() {
        schemeButton.click();
    }

    public String getSchemeTitle() {
        return schemeTitle.getText();
    }

    public void openSchemeOptions(String schemeName) {
        driver.findElement(By.xpath("//*[@id='glass-general-schemes-panel']//table[@class='aui aui-table-sortable']//a[contains(@href,"+ schemeName +")]")).click();
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
