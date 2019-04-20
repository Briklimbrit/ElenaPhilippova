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
import static test.hw4.voidpo.enums.PageTitle.*;

// TODO Смотри комментарии в CreationProjectPOTest
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

        @Test
        public void FilterIssue() {
            // Check title
            assertEquals(lp.getPageTitle(), MANTIS_BT.getName());

            // Login
            lp.login("administrator", "root");

            // Check title
            assertEquals(ap.getPageTitle(), MY_ACCOUNT.getName());

            //Check login
            assertEquals(ap.getUserName(), "administrator");

            //Click "Manage" button at the left side menu
            ap.selectLeftMenu(LeftMenuItem.VIEW_ISSUES);
            // Check title
            assertEquals(vbp.getPageTitle(), VIEW_ISSUES.getName());

            vbp.setFilterDate();
            vbp.setPriority();
            vbp.setSeverity();
            vbp.setStatus();

            vbp.clickApplyFilterBtn();

            assertEquals(vbp.getIssuesNumber(), "1 - 1 / 1");

            //Logout
            ap.logout();
        }

        @AfterMethod(alwaysRun = true)
        public void tearDownDriver() {
            // Close driver
            driver.close();
        }
}
