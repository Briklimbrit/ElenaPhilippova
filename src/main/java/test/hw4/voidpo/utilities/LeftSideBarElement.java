package test.hw4.voidpo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractMainPageObject;
import test.hw4.voidpo.enums.LeftMenuItem;

import java.util.List;

public class LeftSideBarElement extends AbstractMainPageObject {

    @FindBy(xpath = "//div[@id='sidebar']//li")
    private List<WebElement> menuItems;

    public LeftSideBarElement(WebDriver driver) {
        super(driver);
    }

    public void clickMenuItem(LeftMenuItem item) {
        for (WebElement menuItem : menuItems) {
            if (menuItem.getText().trim().equals(item.getItemName().trim())) {
                menuItem.click();
                break;
            }
        }
    }
}
