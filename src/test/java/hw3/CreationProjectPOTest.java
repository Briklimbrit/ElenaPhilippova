package hw3;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import test.hw3.voidpo.CreationProjectVoidPageObject;

public class CreationProjectPOTest {

    private WebDriver driver;
    private CreationProjectVoidPageObject cpvpo;

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
        cpvpo = new CreationProjectVoidPageObject(driver);
    }

    @Test(priority = 1)
    public void loginMantisBt() {
        // Check title
        assertEquals(cpvpo.getPageTitle(), "MantisBT");

        // Login
        cpvpo.login("administrator", "root");

        // Check login
        assertEquals(cpvpo.getPageTitle(), "My Account - MantisBT");

        //изменить на функцию проверки пользователя
        assertEquals(cpvpo.getUserName(), "administrator");
    }

    @Test(priority = 2)
    public void testSideBar() {
        //Operations before test
        cpvpo.login("administrator", "root");

        // Check title
        assertEquals(driver.getTitle(), "My Account - MantisBT");
        //Click "Manage" button at the left side menu
        cpvpo.selectMenu("Manage");
        // Check title
        assertEquals(cpvpo.getPageTitle(), "Manage - MantisBT");
    }

    @Test(priority = 3)
    public void testMainMenu(){
        //Operations before test
        cpvpo.login("administrator", "root");
        cpvpo.selectMenu("Manage");

        // Check title
        assertEquals(cpvpo.getPageTitle(), "Manage - MantisBT");
        //Click "Manage Projects" button at the main menu
        cpvpo.selectMenu("Manage Projects");
        // Check title
        assertEquals(cpvpo.getPageTitle(), "Manage Projects - MantisBT");
    }

    @Test(priority = 4)
    public void testPageFunction(){
        //Operations before test
        cpvpo.login("administrator", "root");
        cpvpo.selectMenu("Manage");
        cpvpo.selectMenu("Manage Projects");

        // Check title
        assertEquals(cpvpo.getPageTitle(), "Manage Projects - MantisBT");
        //Click "Create New Project" button
        cpvpo.selectTextBtn("button", "Create New Project");
        // Check title
        assertEquals(cpvpo.getPageTitle(), "MantisBT");
    }

    @Test(priority = 5)
    public void fillProjectInformationTest(){
        //Operations before test
        cpvpo.login("administrator", "root");
        cpvpo.selectMenu("Manage");
        cpvpo.selectMenu("Manage Projects");
        cpvpo.selectTextBtn("button", "Create New Project");

        // Check title
        assertEquals(cpvpo.getPageTitle(), "MantisBT");

        //Check fields on the "Add Project" view
        assertEquals(cpvpo.checkField(1), "* Project Name");
        assertEquals(cpvpo.checkField(2), "Status");
        assertEquals(cpvpo.checkField(3), "Inherit Global Categories");
        assertEquals(cpvpo.checkField(4), "View Status");
        assertEquals(cpvpo.checkField(5), "Description");

        //Fill project information
        cpvpo.addInformationByID("project-name", "any project4");
        cpvpo.addInformationByID("project-description", "any project description2");
        cpvpo.addInformationByXpath("project-status", "1");
        cpvpo.addInformationByXpath("project-view-state", "1");
        cpvpo.selectByClass("lbl");

        cpvpo.selectValueBtn("input", "Add Project");
    }

    @Test(priority = 6)
    public void Logout(){
        //Operations before test
        cpvpo.login("administrator", "root");

        //Logout
        cpvpo.selectByClass("user-info");
        cpvpo.selectTextBtn("a", "Logout");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        // Close driver
        driver.close();
    }
}
