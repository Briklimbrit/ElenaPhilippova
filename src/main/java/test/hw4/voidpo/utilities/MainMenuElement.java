package test.hw4.voidpo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractMainPageObject;
import test.hw4.voidpo.enums.LeftMenuItem;
import test.hw4.voidpo.enums.ManageMenuItem;

import java.util.List;

public class MainMenuElement extends AbstractMainPageObject {

    @FindBy(xpath = "//div[contains(@class, 'row')]/ul//li")
    private List<WebElement> menuItems;

    public MainMenuElement(WebDriver driver) {
        super(driver);
    }

    public void clickMenuItem(ManageMenuItem item) {
        for (WebElement menuItem : menuItems) {
            if (menuItem.getText().trim().equals(item.getItemName().trim())) {
                menuItem.click();
                break;
            }
        }
    }
}
