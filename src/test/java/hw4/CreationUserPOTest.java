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
import static test.hw4.voidpo.enums.PageTitle.*;

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

    @Test
    public void CreationUser() {
        // Check title
        assertEquals(lp.getPageTitle(), MANTIS_BT.getName());

        // Login
        lp.login("administrator", "root");

        // Check title
        assertEquals(ap.getPageTitle(), MY_ACCOUNT.getName());

        //Check login
        assertEquals(ap.getUserName(), "administrator");

        //Click "Manage" button at the left side menu
        ap.selectLeftMenu(LeftMenuItem.MANAGE);
        // Check title
        assertEquals(mop.getPageTitle(), MANAGE.getName());

        //Click "Manage Projects" button at the main menu
        mop.selectMainMenu(ManageMenuItem.USERS);
        // Check title
        assertEquals(mup.getPageTitle(), MANAGE_USERS.getName());

        //Click "Create New Project" button
        mup.clickCreateNewUserBtn();
        // Check title
        assertEquals(mucp.getPageTitle(), MANTIS_BT.getName());

        //Fill project information
        mucp.addUsername("EL");
        mucp.addRealname("so good");
        mucp.addEmail("anymail@nail.ru");
        mucp.addPassword("1234");
        mucp.verifyPassword("1234");
        mucp.setAccessLevel("2");

        mucp.clickCreateUserBtn();


        // Check title
        assertEquals(lp.getPageTitle(), MANTIS_BT.getName());

        //Logout
        ap.logout();

        // Login
        lp.login("EL", "1234");

        //Check login
        assertEquals(ap.getUserName(), "EL");

        //Logout
        ap.logout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        // Close driver
        driver.close();
    }
}
