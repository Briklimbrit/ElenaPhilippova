package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
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


    JavascriptExecutor js;

    public ViewBugPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor)driver;
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
        this.selectMenuByXpath("show_priority_filter_target", "5" );
    }

    public void setSeverity(){
        severityBtn.click();
        this.selectMenuByXpath("show_severity_filter_target", "5");
    }

    public void setStatus(){
        statusBtn.click();
        this.selectMenuByXpath("show_status_filter_target", "6");
    }

    public void setFilterDate(){
        filterDate.click();

        //someBtn.findElement(By.xpath("//span[@class='lbl padding-6 small']"));
        js.executeScript("document.querySelector('#do_filter_by_date_filter_target > table > tbody > tr:nth-child(1) > td > label > span::before').click();");

        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='start_year']")).click();
        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='start_year']/option[1]")).click();

        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='start_month']")).click();
        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='start_month']/option[3]")).click();

        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='start_day']")).click();
        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='start_day']/option[27]")).click();

        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='end_year']")).click();
        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='end_year']/option[1]")).click();

        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='end_month']")).click();
        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='end_month']/option[4]")).click();

        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='end_day']")).click();
        someBtn.findElement(By.xpath("//*[@class='input-xs' and @name='end_day']/option[20]")).click();

    }

    public void clickApplyFilterBtn(){
        applyFilterBtn.click();
    }

    public String getIssuesNumber() {
        String st = issuesNumber.getText();
        return st;
    }
}
