package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends PageObject {

    @FindBy(id = "login-form-username")
    WebElement userName;

    @FindBy(id = "login-form-password")
    WebElement password;

    @FindBy(id = "login-form-submit")
    WebElement loginBtn;

    @FindBy(id = "user-options")
    WebElement userOptions;

    @FindBy(id = "log_out")
    WebElement logoutBtn;

    @FindBy(xpath = "//*[@id='login-form']//div[@class='aui-message error']")
    WebElement errorMessage;

    @FindBy(id = "data-displayname")
    WebElement logCheck;

    @FindBy(xpath = "//*[@id='content']//h1[text(), 'Logout']")
    WebElement logoutSign;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void login() {
        driver.navigate().to("https://jira2.codecool.codecanvas.hu/login.jsp");
        userName.sendKeys(System.getenv("username"));
        password.sendKeys(System.getenv("password"));
        loginBtn.click();
    }

    public boolean isLoggedIn() {
        return !userOptions.getText().equals("Log In");
    }

    public void logout() {
        userOptions.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log_out")));
        logoutBtn.click();
    }

    public boolean wrongLogin() {
        return errorMessage.isDisplayed();
    }

}
