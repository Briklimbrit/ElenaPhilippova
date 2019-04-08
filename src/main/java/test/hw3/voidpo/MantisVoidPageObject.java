package test.hw3.voidpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

// TODO Для каждой страницы должен быть определён свой PageObject
// TODO Исправить в HW4
public class MantisVoidPageObject {

    private WebDriver driver;
    private WebElement username;
    private WebElement password;
    private WebElement someBtn;

    public MantisVoidPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void login(String name, String password){
        username = driver.findElement(By.id("username"));
        username.sendKeys(name);
        someBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        someBtn.click();
        this.password = driver.findElement(By.id("password"));
        this.password.sendKeys(password);
        someBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        someBtn.click();
    }

    public void selectMenu(String name){
        //Check left side menu
        driver.findElement(By.id("sidebar"));
        //Click "Name" button at the left side menu
        someBtn = driver.findElement(By.partialLinkText(name));
        someBtn.click();
    }

    public void selectTextBtn(String cl, String name){
        //Click "Name" button at the main menu
        someBtn = driver.findElement(By.xpath("//"+ cl +"[contains(text(), '" + name + "')]"));
        someBtn.click();
    }
    public void selectValueBtn(String cl, String name){
        //Click "Name" button at the main menu
        someBtn = driver.findElement(By.xpath("//"+ cl +"[@value='" + name + "']"));
        someBtn.click();
    }
    public String checkField(Integer i){
       return driver.findElement(By.xpath("//tr["+i.toString()+"]/td[@class='category']")).getText();
    }

    public void addInformationByID(String field, String info){
        driver.findElement(By.id(field)).sendKeys(info);
    }

    public void addInformationByXpath(String field, String option){
        someBtn = driver.findElement(By.xpath("//*[@id='" + field + "']"));
        someBtn.click();
        someBtn = driver.findElement(By.xpath("//*[@id='" + field + "']/option[" + option + "]"));
        someBtn.click();
    }

    public void selectByClass(String cl){
        someBtn = driver.findElement(By.className(cl));
        someBtn.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getUserName(){
        return driver.findElement(By.className("user-info")).getText();
    }
}
