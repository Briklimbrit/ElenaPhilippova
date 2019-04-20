package test.hw4.voidpo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.hw4.voidpo.abstracts.AbstractMainPageObject;

public class CalendarElement extends AbstractMainPageObject {

    protected String startYear;
    protected String startMonth;
    protected String startDay;

    protected String endYear;
    protected String endMonth;
    protected String endDay;


    public CalendarElement(WebDriver driver, String startYear, String startMonth, String startDay
            , String endYear, String endMonth, String endDay) {
        super(driver);
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }

    public void setFilterDate(){

        //Клик по галке
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.
                        visibilityOf(driver.findElement(By.xpath("//span[contains(text(), 'Filter by Date Submitted')]")))).click();

        setDateItem("start_year", startYear);
        setDateItem("start_month", startMonth);
        setDateItem("start_day", startDay);
        setDateItem("end_year", endYear);
        setDateItem("end_month", endMonth);
        setDateItem("end_day", endDay);
    }

    private void setDateItem(String type, String date){
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='" + type +"']")).click();
        driver.findElement(By.xpath("//*[@class='input-xs' and @name='" + type +"']/option[contains(text(), '"+date+"')] ")).click();

    }
}
