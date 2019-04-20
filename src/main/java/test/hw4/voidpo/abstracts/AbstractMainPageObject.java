package test.hw4.voidpo.abstracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractMainPageObject {
    protected WebDriver driver;

    protected AbstractMainPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}