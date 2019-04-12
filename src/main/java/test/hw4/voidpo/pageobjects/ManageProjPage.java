package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractPageObject;

public class ManageProjPage extends AbstractPageObject {

    @FindBy(xpath = "//button[contains(text(), 'Create New Project')]")
    protected WebElement someBtn;

    public ManageProjPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewProjBtn(){
        someBtn.click();
    }
}
