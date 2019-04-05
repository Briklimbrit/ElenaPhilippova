package test.hw3.voidpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreationProjectVoidPageObject {

    private WebDriver driver;
    private WebElement username;
    private WebElement password;
    private WebElement loginBtn;

    public CreationProjectVoidPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void login(String name, String password){
        username = driver.findElement(By.id("username"));
        username.sendKeys(name);
        loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();
        this.password = driver.findElement(By.id("password"));
        this.password.sendKeys(password);
        loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
