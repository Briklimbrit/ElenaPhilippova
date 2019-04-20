package test.hw4.voidpo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.abstracts.AbstractMainPageObject;
import test.hw4.voidpo.enums.UserInfoMenuItem;

import java.util.List;

public class UserInfoElement extends AbstractMainPageObject {

    @FindBy(className = "user-info")
    private WebElement userButton;

    // TODO неоднозначный локатор
    //DONE
    @FindBy(xpath = "//ul[contains(@class, 'user-menu')]/li")
    private List<WebElement> menuItems;

    public UserInfoElement(WebDriver driver) {
        super(driver);
    }

    public void clickMenuItem(UserInfoMenuItem item){
        for(WebElement menuItem: menuItems){
            if(menuItem.getText().trim().equals(item.getItemName().trim())){
                menuItem.click();
                break;
            }
        }
    }

    public String getUserName(){
        return userButton.getText();
    }

}
