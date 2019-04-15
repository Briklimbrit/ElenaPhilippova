package hw4;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.hw4.voidpo.enums.LeftMenuItem;
import test.hw4.voidpo.enums.ManageMenuItem;
import test.hw4.voidpo.pageobjects.*;

import static org.testng.Assert.assertEquals;

// TODO Смотри комментарии в CreationProjectPOTest
public class CreationUserPOTest {

    private WebDriver driver;
    private LoginPage lp;
    private AccountPage ap;
    private ManageOverviewPage mop;
    private ManageUserPage mup;
    private ManageUserCreatePage mucp;


    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ChromeDriverManager.chromedriver().version("73.0.3683.20").setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Mantis
        driver.get("http://localhost/mantisbt/login_page.php");

        //init
        lp = new LoginPage(driver);
        ap = new AccountPage(driver);
        mop = new ManageOverviewPage(driver);
        mup = new ManageUserPage(driver);
        mucp = new ManageUserCreatePage(driver);
    }

    @Test(priority = 1)
    public void loginMantisBt() {
        // Check title
        assertEquals(lp.getPageTitle(), "MantisBT");

        // Login
        lp.login("administrator", "root");

        // Check title
        assertEquals(ap.getPageTitle(), "My Account - MantisBT");
    }

    @Test(priority = 2)
    public void testSideBar() {
        //Operations before test
        lp.login("administrator", "root");

        // Check title
        assertEquals(ap.getPageTitle(), "My Account - MantisBT");

        //Check login
        assertEquals(ap.getUserName(), "administrator");

        //Click "Manage" button at the left side menu
        ap.selectLeftMenu(LeftMenuItem.MANAGE);
        // Check title
        assertEquals(mop.getPageTitle(), "Manage - MantisBT");
    }

    @Test(priority = 3)
    public void testMainMenu(){
        //Operations before test
        lp.login("administrator", "root");
        ap.selectLeftMenu(LeftMenuItem.MANAGE);

        // Check title
        assertEquals(mop.getPageTitle(), "Manage - MantisBT");
        //Click "Manage Projects" button at the main menu
        mop.selectMainMenu(ManageMenuItem.USERS);
        // Check title
        assertEquals(mup.getPageTitle(), "Manage Users - MantisBT");
    }

    @Test(priority = 4)
    public void testPageFunction() {
        //Operations before test
        lp.login("administrator", "root");
        ap.selectLeftMenu(LeftMenuItem.MANAGE);
        mop.selectMainMenu(ManageMenuItem.USERS);

        // Check title
        assertEquals(mup.getPageTitle(), "Manage Users - MantisBT");
        //Click "Create New Project" button
        mup.clickCreateNewUserBtn();
        // Check title
        assertEquals(mucp.getPageTitle(), "MantisBT");
    }

    @Test(priority = 5)
    public void fillProjectInformationTest(){
        //Operations before test
        lp.login("administrator", "root");
        ap.selectLeftMenu(LeftMenuItem.MANAGE);
        mop.selectMainMenu(ManageMenuItem.USERS);
        mup.clickCreateNewUserBtn();

        // Check title
        assertEquals(mucp.getPageTitle(), "MantisBT");

        //Fill project information
        mucp.addUsername("mabe");
        mucp.addRealname("so good");
        mucp.addEmail("anymail@nail.ru");
        mucp.addPassword("1234");
        mucp.verifyPassword("1234");
        mucp.setAccessLevel("2");

        mucp.clickCreateUserBtn();
    }

    @Test(priority = 6)
    public void Logout(){
        //Operations before test
        lp.login("administrator", "root");

        //Logout
        ap.logout();
    }

    @Test(priority = 7)
    public void loginAnotherUser(){
        // Check title
        assertEquals(lp.getPageTitle(), "MantisBT");

        // Login
        lp.login("maybe", "1234");

        //Check login
        assertEquals(ap.getUserName(), "maybe");

        //Logout
        ap.logout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        // Close driver
        driver.close();
    }
}
