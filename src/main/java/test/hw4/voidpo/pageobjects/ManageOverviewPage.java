package test.hw4.voidpo.pageobjects;

import org.openqa.selenium.WebDriver;
import test.hw4.voidpo.abstracts.AbstractPageObject;
import test.hw4.voidpo.enums.ManageMenuItem;
import test.hw4.voidpo.utilities.MainMenuElement;

public class ManageOverviewPage extends AbstractPageObject {

    protected MainMenuElement mainMenuElement;

    public ManageOverviewPage(WebDriver driver) {
        super(driver);
        mainMenuElement = new MainMenuElement(driver);
    }

    public void selectMainMenu(ManageMenuItem item){
        mainMenuElement.clickMenuItem(item);
    }
}
