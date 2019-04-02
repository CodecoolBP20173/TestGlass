package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Schemes extends PageObject{

    @FindBy(id = "aui-uid-3")
    WebElement schemeButton;

    @FindBy(xpath = "//*[@id='glass-general-schemes-panel']//span[text()='Schemes ']")
    WebElement schemeTitle;

    @FindBy(xpath = "//*[@id='glass-general-schemes-panel']//table[@class='aui aui-table-sortable']//a[contains(@href,'listDetails.do')]")
    WebElement table;

    public Schemes(WebDriver driver) {
        super(driver);
    }

    public void openSchemes() {
        schemeButton.click();
    }

    public String getSchemeTitle() {
        return schemeTitle.getText();
    }

}
