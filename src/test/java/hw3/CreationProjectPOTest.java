package hw3;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import test.hw3.voidpo.MantisVoidPageObject;

public class CreationProjectPOTest {

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
        mvpo.selectMenu("Manage Projects");
        // Check title
        assertEquals(mvpo.getPageTitle(), "Manage Projects - MantisBT");
    }

    @Test(priority = 4)
    public void testPageFunction(){
        //Operations before test
        mvpo.login("administrator", "root");
        mvpo.selectMenu("Manage");
        mvpo.selectMenu("Manage Projects");

        // Check title
        assertEquals(mvpo.getPageTitle(), "Manage Projects - MantisBT");
        //Click "Create New Project" button
        mvpo.selectTextBtn("button", "Create New Project");
        // Check title
        assertEquals(mvpo.getPageTitle(), "MantisBT");
    }

    @Test(priority = 5)
    public void fillProjectInformationTest(){
        //Operations before test
        mvpo.login("administrator", "root");
        mvpo.selectMenu("Manage");
        mvpo.selectMenu("Manage Projects");
        mvpo.selectTextBtn("button", "Create New Project");

        // Check title
        assertEquals(mvpo.getPageTitle(), "MantisBT");

        //Check fields on the "Add Project" view
        assertEquals(mvpo.checkField(1), "* Project Name");
        assertEquals(mvpo.checkField(2), "Status");
        assertEquals(mvpo.checkField(3), "Inherit Global Categories");
        assertEquals(mvpo.checkField(4), "View Status");
        assertEquals(mvpo.checkField(5), "Description");

        //Fill project information
        mvpo.addInformationByID("project-name", "any project4");
        mvpo.addInformationByID("project-description", "any project description2");
        mvpo.addInformationByXpath("project-status", "1");
        mvpo.addInformationByXpath("project-view-state", "1");
        mvpo.selectByClass("lbl");

        mvpo.selectValueBtn("input", "Add Project");
    }

    @Test(priority = 6)
    public void Logout(){
        //Operations before test
        mvpo.login("administrator", "root");

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
