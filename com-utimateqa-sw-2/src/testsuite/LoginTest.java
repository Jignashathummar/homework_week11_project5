package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        /**
         *  click on the ‘Sign In’ link
         *  Verify the text ‘Welcome Back!’
         */
        driver.findElement(By.linkText("Sign In")).click();
        Assert.assertEquals("Welcome Back!", "Welcome Back!");
        /**
         * verifyTheErrorMessage
         * * click on the ‘Sign In’ link
         * * Enter invalid username
         * * Enter invalid password
         * * Click on Login button
         * * Verify the error message ‘Invalid email or password.’
         */
        driver.findElement(By.xpath("//button[text()='     Sign in   ' or @type = 'submit']")).click();
        Assert.assertEquals("Invalid email or password.","Invalid email or password.");
        driver.findElement(By.id("user[email]")).sendKeys("James@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("James123");
        driver.findElement(By.linkText(" Sign in ")).click();
        Assert.assertEquals("Wrong email and Password","Invalid email or password.","Invalid email or password.");
    }

    @After
    public void close() {
       closeBrowser();
    }
}
