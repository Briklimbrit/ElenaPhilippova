package hw2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class AddUserMantisWebElementTest {

    @Test
    public void addUser(){
        //Init driver
        //System.setProperty("webdriver.chrome.driver",
        //      "C:/Users/Елена/Documents/IdeaProjects/src/test/resources/webdriver/chrome/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                        this.getClass().getClassLoader().getResource("webdriver/chrome/chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open test site by URL
        driver.get("http://localhost/mantisbt/login_page.php");

        // Assert Browser title
        assertEquals(driver.getTitle(), "MantisBT");

        //Perform login
        driver.findElement(By.id("username")).sendKeys("administrator");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.id("password")).sendKeys("root");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "administrator");

        //Check left side menu
        driver.findElement(By.id("sidebar"));

        //Click "Manage" button at the left side menu

        //Click "Manage" button at the left side menu
        driver.findElement(By.partialLinkText("Manage")).click();

        //Click "Manage Projects" button at the top menu on the "Manage MantisBT" page
        driver.findElement(By.partialLinkText("Manage Users")).click();

        //Check "Create New Account" button
        driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]"));

        //Click "Create New Account" button
        driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();

        //Check fields on the "Create New Account" view
        assertEquals(driver.findElement(By.xpath("//tr[1]/td[@class='category']")).getText(), "Username");
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[@class='category']")).getText(), "Real Name");
        assertEquals(driver.findElement(By.xpath("//tr[3]/td[@class='category']")).getText(), "E-mail");
        assertEquals(driver.findElement(By.xpath("//tr[4]/td[@class='category']")).getText(), "Password");
        assertEquals(driver.findElement(By.xpath("//tr[5]/td[@class='category']")).getText(), "Verify Password");
        assertEquals(driver.findElement(By.xpath("//tr[6]/td[@class='category']")).getText(), "Access Level");
        assertEquals(driver.findElement(By.xpath("//tr[7]/td[@class='category']")).getText(), "Enabled");
        assertEquals(driver.findElement(By.xpath("//tr[8]/td[@class='category']")).getText(), "Protected");

        //Fill user information
        driver.findElement(By.id("user-username")).sendKeys("any name 1");
        driver.findElement(By.id("user-realname")).sendKeys("any real name 1");
        driver.findElement(By.id("email-field")).sendKeys("any@gmail.com");
        driver.findElement(By.id("user-password")).sendKeys("elena");
        driver.findElement(By.id("user-verify-password")).sendKeys("elena");
        driver.findElement(By.xpath("//*[@id='user-access-level']")).click();
        driver.findElement(By.xpath("//*[@id='user-access-level']/option[2]")).click();

        //Click "Create User" button
        driver.findElement(By.xpath("//input[@value='Create User']")).click();

        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

        //Login under created user
        driver.findElement(By.id("username")).sendKeys("any name 1");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.id("password")).sendKeys("elena");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "any name 1");
        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        // Close driver
        driver.close();
    }

}

