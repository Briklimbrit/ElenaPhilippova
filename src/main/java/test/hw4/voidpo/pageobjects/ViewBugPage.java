package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.hw4.voidpo.abstracts.AbstractPageObject;
import test.hw4.voidpo.enums.PriorityOption;
import test.hw4.voidpo.enums.SeverityOption;
import test.hw4.voidpo.enums.StatusOption;
import test.hw4.voidpo.utilities.CalendarElement;

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

    private CalendarElement calendarElement;

    public ViewBugPage(WebDriver driver) {
        super(driver);
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
        //DONE
        this.selectMenuByXpath("show_priority_filter_target", PriorityOption.HIGH.getOptionNumber());
    }

    public void setSeverity(){
        severityBtn.click();
        // TODO Что такое 5?
        //DONE
        this.selectMenuByXpath("show_severity_filter_target", SeverityOption.TWEAK.getOptionNumber());
    }

    public void setStatus(){
        statusBtn.click();
        // TODO Что такое 6?
        //DONE
        this.selectMenuByXpath("show_status_filter_target", StatusOption.ASSIGNED.getOptionNumber());
    }

    public void setFilterDate(){
        filterDate.click();

        // TODO Какие даты фильтруются?
        // TODO Это может быть отдельный элемент?
        //DONE

        calendarElement = new CalendarElement(driver, "2019", "March", "27",
                "2019", "April", "15");
        calendarElement.setFilterDate();
    }

    public void clickApplyFilterBtn(){
        applyFilterBtn.click();
    }

    public String getIssuesNumber() {
        String st = issuesNumber.getText();
        return st;
    }
}
