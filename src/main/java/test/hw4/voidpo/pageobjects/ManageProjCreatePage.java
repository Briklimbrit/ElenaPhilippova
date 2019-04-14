package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractPageObject;

public class ManageProjCreatePage extends AbstractPageObject {

    @FindBy(id = "project-name")
    protected WebElement prjName;

    @FindBy(id = "project-description")
    protected WebElement prjDesc;

    @FindBy(id = "project-status")
    protected WebElement prjStatus;

    @FindBy(id = "project-view-state")
    protected WebElement prjViewState;

    @FindBy(xpath = "//input[@value='Add Project']")
    protected WebElement someBtn;

    public ManageProjCreatePage(WebDriver driver) {
        super(driver);
    }

    public void addName(String name){
        prjName.sendKeys(name);
    }

    public void addDesc(String name){
        prjDesc.sendKeys(name);
    }
    public void addStatus(String name){
        prjStatus.click();

    }
    public void addViewStatus(String name){
        prjViewState.click();
    }

    public void clickAddProjBtn(){
        someBtn.click();
    }
}
