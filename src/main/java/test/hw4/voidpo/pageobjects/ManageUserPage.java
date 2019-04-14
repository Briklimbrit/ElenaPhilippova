package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractPageObject;

public class ManageUserPage extends AbstractPageObject {

    @FindBy(xpath = "//a[contains(text(), 'Create New Account')]")
    protected WebElement someBtn;

    public ManageUserPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewUserBtn(){
        someBtn.click();
    }
}
