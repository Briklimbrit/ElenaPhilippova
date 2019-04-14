package hw4;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.hw4.voidpo.enums.LeftMenuItem;
import test.hw4.voidpo.pageobjects.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class IssuePOTest {

        private WebDriver driver;
        private LoginPage lp;
        private AccountPage ap;
        private ViewBugPage vbp;

        @BeforeSuite(alwaysRun = true)
        public void setUp() {
            ChromeDriverManager.chromedriver().version("73.0.3683.20").setup();
        }

        @BeforeMethod(alwaysRun = true)
        public void initDriver() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

            // Open Mantis
            driver.get("http://localhost/mantisbt/login_page.php");

            //init
            lp = new LoginPage(driver);
            ap = new AccountPage(driver);
            vbp = new ViewBugPage(driver);
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
            ap.selectLeftMenu(LeftMenuItem.VIEW_ISSUES);
            // Check title
            assertEquals(vbp.getPageTitle(), "View Issues - MantisBT");
        }

        @Test(priority = 3)
        public void setFilterValues(){
            //Operations before test
            lp.login("administrator", "root");
            ap.selectLeftMenu(LeftMenuItem.VIEW_ISSUES);

            // Check title
            assertEquals(vbp.getPageTitle(), "View Issues - MantisBT");

            vbp.setFilterDate();
            vbp.setPriority();
            vbp.setSeverity();
            vbp.setStatus();

            vbp.clickApplyFilterBtn();

            assertEquals(vbp.getIssuesNumber(), "1 - 1 / 1");
        }

        @Test(priority = 4)
        public void Logout(){
            //Operations before test
            lp.login("administrator", "root");

            //Logout
            ap.logout();
        }

        @AfterMethod(alwaysRun = true)
        public void tearDownDriver() {
            // Close driver
            driver.close();
        }
}
