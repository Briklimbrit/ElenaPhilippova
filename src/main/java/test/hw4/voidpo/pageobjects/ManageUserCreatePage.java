package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractPageObject;

public class ManageUserCreatePage extends AbstractPageObject {

    @FindBy(id = "user-username")
    protected WebElement userName;

    @FindBy(id = "user-realname")
    protected WebElement realName;

    @FindBy(id = "email-field")
    protected WebElement email;

    @FindBy(id = "user-password")
    protected WebElement password;

    @FindBy(id = "user-verify-password")
    protected WebElement passwordVerify;

    @FindBy(xpath = "//*[@id='user-access-level']")
    protected WebElement accessLevel;

    @FindBy(xpath = "//input[@value='Create User']")
    protected WebElement someBtn;

    public ManageUserCreatePage(WebDriver driver) {
        super(driver);
    }

    public void addUsername(String name){
        userName.sendKeys(name);
    }

    public void addRealname(String name){
        realName.sendKeys(name);
    }
    public void setAccessLevel(String name){
        accessLevel.click();

    }

    public void addPassword(String name){
        password.sendKeys(name);
    }

    public void addEmail(String name){
        email.sendKeys(name);
    }
    public void verifyPassword(String name){
        passwordVerify.sendKeys(name);
    }
    public void clickCreateUserBtn(){
        someBtn.click();
    }
}
