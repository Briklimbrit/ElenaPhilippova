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

public class CreationProjectPOTest {

    // TODO Дубликат кода, можно вынести в базовый класс
    private WebDriver driver;
    private LoginPage lp;
    private AccountPage ap;
    private ManageOverviewPage mop;
    private ManageProjPage mpp;
    private ManageProjCreatePage mpcp;

    @BeforeSuite(alwaysRun = true)
    // TODO  базовый класс
    public void setUp() {
        ChromeDriverManager.chromedriver().version("73.0.3683.20").setup();
    }

    @BeforeMethod(alwaysRun = true)
    // TODO  базовый класс
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Mantis
        driver.get("http://localhost/mantisbt/login_page.php");

        //init
        lp = new LoginPage(driver);
        ap = new AccountPage(driver);
        mop = new ManageOverviewPage(driver);
        mpp = new ManageProjPage(driver);
        mpcp = new ManageProjCreatePage(driver);
    }

    // TODO Для каких целей используется приоритезация?
    @Test
    public void CreationProject() {
        // Check title
        // TODO hard-code
        assertEquals(lp.getPageTitle(), MANTIS_BT.getName());

        // Login
        // TODO пользователь должен быть в property файле
        lp.login("administrator", "root");

        // Check title
        // TODO hard-code
        assertEquals(ap.getPageTitle(), MY_ACCOUNT.getName());

        //Check login
        assertEquals(ap.getUserName(), "administrator");

        //Click "Manage" button at the left side menu
        ap.selectLeftMenu(LeftMenuItem.MANAGE);
        // Check title
        // TODO hard-code
        assertEquals(mop.getPageTitle(), MANAGE.getName());

        //Click "Manage Projects" button at the main menu
        mop.selectMainMenu(ManageMenuItem.PROJECTS);
        // Check title
        // TODO hard-code
        assertEquals(mpp.getPageTitle(), MANAGE_PROJECTS.getName());

        //Click "Create New Project" button
        mpp.clickCreateNewProjBtn();
        // Check title
        assertEquals(mpcp.getPageTitle(), MANTIS_BT.getName());

        //Fill project information
        mpcp.addName("MyProject");
        mpcp.addDesc("Some desc");
        mpcp.addStatus("1");
        mpcp.addViewStatus("1");

        mpcp.clickAddProjBtn();

        //Logout
        ap.logout();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        // Close driver
        driver.close();
    }
}