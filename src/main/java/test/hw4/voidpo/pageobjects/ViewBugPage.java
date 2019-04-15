package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.hw4.voidpo.abstracts.AbstractPageObject;

public class ViewBugPage extends AbstractPageObject {

    @FindBy(id = "show_priority_filter")
    private WebElement priorityBtn;

    @FindBy(id = "show_severity_filter")
    private WebElement severityBtn;

    @FindBy(id = "show_status_filter")
    private WebElement statusBtn;

    @FindBy(id = "do_filter_by_date_filter")
    private WebElement filterDate;

    @FindBy(className = "badge")
    private WebElement issuesNumber;


    //JavascriptExecutor js;

    public ViewBugPage(WebDriver driver) {
        super(driver);
        //js = (JavascriptExecutor)driver;
    }

    private WebElement someBtn;

    @FindBy(xpath = "//input[@value='Apply Filter']")
    private WebElement applyFilterBtn;

    protected void selectMenuByXpath(String field, String option){
        someBtn = driver.findElement(By.xpath("//*[@id='" + field + "']/select"));
        someBtn.click();
        someBtn = driver.findElement(By.xpath("//*[@id='" + field + "']/select/option[" + option + "]"));
        someBtn.click();
    }

    public void setPriority(){
        priorityBtn.click();
        // TODO Что такое 5?
        this.selectMenuByXpath("show_priority_filter_target", "5" );
    }

    public void setSeverity(){
        severityBtn.click();
        // TODO Что такое 5?
        this.selectMenuByXpath("show_severity_filter_target", "5");
    }

    public void setStatus(){
        statusBtn.click();
        // TODO Что такое 6?
        this.selectMenuByXpath("show_status_filter_target", "6");
    }

    public void setFilterDate(){
        filterDate.click();

        // TODO Какие даты фильтруются?
        // TODO Это может быть отдельный элемент?
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.
                        visibilityOf(driver.findElement(By.xpath("//span[contains(text(), 'Filter by Date Submitted')]")))).click();

        driver.findElement(By.xpath("//*[@class='input-xs' and @name='start_year']")).click();
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='start_year']/option[1]")).click();

        driver.findElement(By.xpath("//*[@class='input-xs' and @name='start_month']")).click();
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='start_month']/option[3]")).click();

        driver.findElement(By.xpath("//*[@class='input-xs' and @name='start_day']")).click();
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='start_day']/option[27]")).click();

        driver.findElement(By.xpath("//*[@class='input-xs' and @name='end_year']")).click();
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='end_year']/option[1]")).click();

        driver.findElement(By.xpath("//*[@class='input-xs' and @name='end_month']")).click();
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='end_month']/option[4]")).click();

        driver.findElement(By.xpath("//*[@class='input-xs' and @name='end_day']")).click();
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='end_day']/option[1]")).click();

    }

    public void clickApplyFilterBtn(){
        applyFilterBtn.click();
    }

    public String getIssuesNumber() {
        String st = issuesNumber.getText();
        return st;
    }
}
