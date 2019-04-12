package hw3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.hw3.voidpo.MantisVoidPageObject;

import static org.testng.Assert.assertEquals;

public class CreationUserPOTest {


    private WebDriver driver;
    private MantisVoidPageObject mvpo;

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
        mvpo = new MantisVoidPageObject(driver);
    }

    @Test(priority = 1)
    public void loginMantisBt() {
        // Check title
        assertEquals(mvpo.getPageTitle(), "MantisBT");

        // Login
        mvpo.login("administrator", "root");

        // Check title
        assertEquals(mvpo.getPageTitle(), "My Account - MantisBT");

        //Check login
        assertEquals(mvpo.getUserName(), "administrator");
    }

    @Test(priority = 2)
    public void testSideBar() {
        //Operations before test
        mvpo.login("administrator", "root");

        // Check title
        assertEquals(driver.getTitle(), "My Account - MantisBT");
        //Click "Manage" button at the left side menu
        mvpo.selectMenu("Manage");
        // Check title
        assertEquals(mvpo.getPageTitle(), "Manage - MantisBT");
    }

    @Test(priority = 3)
    public void testMainMenu(){
        //Operations before test
        mvpo.login("administrator", "root");
        mvpo.selectMenu("Manage");

        // Check title
        assertEquals(mvpo.getPageTitle(), "Manage - MantisBT");
        //Click "Manage Projects" button at the main menu
        mvpo.selectMenu("Manage Users");
        // Check title
        assertEquals(mvpo.getPageTitle(), "Manage Users - MantisBT");
    }

    @Test(priority = 4)
    public void testPageFunction(){
        //Operations before test
        mvpo.login("administrator", "root");
        mvpo.selectMenu("Manage");
        mvpo.selectMenu("Manage Users");

        // Check title
        assertEquals(mvpo.getPageTitle(), "Manage Users - MantisBT");
        //Click "Create New Project" button
        mvpo.selectTextBtn("a", "Create New Account");
        // Check title
        assertEquals(mvpo.getPageTitle(), "MantisBT");
    }

    @Test(priority = 5)
    public void fillProjectInformationTest(){
        //Operations before test
        mvpo.login("administrator", "root");
        mvpo.selectMenu("Manage");
        mvpo.selectMenu("Manage Users");
        mvpo.selectTextBtn("a", "Create New Account");

        // Check title
        assertEquals(mvpo.getPageTitle(), "MantisBT");

        //Check fields on the "Create New Account" view
        assertEquals(mvpo.checkField(1), "Username");
        assertEquals(mvpo.checkField(2), "Real Name");
        assertEquals(mvpo.checkField(3), "E-mail");
        assertEquals(mvpo.checkField(4), "Password");
        assertEquals(mvpo.checkField(5), "Verify Password");
        assertEquals(mvpo.checkField(6), "Access Level");
        assertEquals(mvpo.checkField(7), "Enabled");
        assertEquals(mvpo.checkField(8), "Protected");

        //Fill user information
        mvpo.addInformationByID("user-username", "any name 12");
        mvpo.addInformationByID("user-realname", "any real name 1");
        mvpo.addInformationByID("email-field", "any@gmail.com");
        mvpo.addInformationByID("user-password", "elena");
        mvpo.addInformationByID("user-verify-password", "elena");
        mvpo.addInformationByXpath("user-access-level", "2");

        mvpo.selectValueBtn("input", "Create User");
    }

    @Test(priority = 6)
    public void Logout(){
        //Operations before test
        mvpo.login("administrator", "root");

        //Logout
        mvpo.selectByClass("user-info");
        mvpo.selectTextBtn("a", "Logout");
    }

    @Test(priority = 7)
    public void loginAnotherUser(){
        // Check title
        assertEquals(mvpo.getPageTitle(), "MantisBT");

        // Login
        mvpo.login("any name 12", "elena");

        //Check login
        assertEquals(mvpo.getUserName(), "any name 12");

        //Logout
        mvpo.selectByClass("user-info");
        mvpo.selectTextBtn("a", "Logout");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        // Close driver
        driver.close();
    }
}
