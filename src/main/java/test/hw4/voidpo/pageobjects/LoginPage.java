package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractMainPageObject;

public class LoginPage extends AbstractMainPageObject {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        usernameField.sendKeys(username);
        loginButton.click();
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
