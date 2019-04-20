package test.hw4.voidpo.abstracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.hw4.voidpo.utilities.LeftSideBarElement;
import test.hw4.voidpo.utilities.MainMenuElement;
import test.hw4.voidpo.utilities.UserInfoElement;
import test.hw4.voidpo.enums.LeftMenuItem;
import test.hw4.voidpo.enums.UserInfoMenuItem;

public abstract class AbstractPageObject extends AbstractMainPageObject {

    protected LeftSideBarElement leftSideBar;
    protected UserInfoElement userInfoElement;

    @FindBy(xpath = "//*[(@class='grey') and not(@id='dropdown_projects_menu')]")
    protected WebElement userBtn;

    protected AbstractPageObject(WebDriver driver) {
        super(driver);
        this.leftSideBar = new LeftSideBarElement(driver);
        this.userInfoElement = new UserInfoElement(driver);
    }

    public void selectLeftMenu(LeftMenuItem item){
        leftSideBar.clickMenuItem(item);
    }

    public void selectUserInfoMenu(UserInfoMenuItem item){
        userBtn.click();
        userInfoElement.clickMenuItem(item);
    }

    public String getUserName(){
        return userInfoElement.getUserName();
    }
    public void logout(){
        this.selectUserInfoMenu(UserInfoMenuItem.LOGOUT);
    }
}