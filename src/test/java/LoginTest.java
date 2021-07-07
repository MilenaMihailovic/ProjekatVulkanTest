import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.Strings;

import java.time.Duration;

public class LoginTest extends BaseTest{

    /**
     *  Test - successfully login with valid credentials

    * Steps to introduce:
    1. Navigate to main page ("https://www.knjizare-vulkan.rs/")
    2. Click on Button "Prijavite se"
    3. Dialog Box for entering e-mail and password is opened
    4. Enter valid e-mail
    5. Enter valid password
    6. Click on Button ("Prijava")
    7. User is loged in
         **/


    @Test
    public void testSuccessfullyLogin() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs/");
        WebElement loginFieldLink = driver.findElement(By.xpath("//a[@class='login-btn']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        loginFieldLink.click();
        Thread.sleep(2000);


        WebElement loginEmailField = driver.findElement(By.id("login_email"));
        loginEmailField.sendKeys(Strings.VALID_USER);

        WebElement loginPasswordField = driver.findElement(By.id("login_password"));
        loginPasswordField.sendKeys(Strings.VALID_PASSWORD);

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-success btn-login confirm-loader']"));
        submitButton.click();




    }
    /**
     *  Test - login with valid user name and invalid password

     * Steps to introduce:
     1. Navigate to main page ("https://www.knjizare-vulkan.rs/")
     2. Click on Button "Prijavite se"
     3. Dialog Box for entering e-mail and password is opened
     4. Enter valid e-mail
     5. Enter invalid password
     6. Click on Button ("Prijava")
     7. User is not loged in

     **/

    @Test
    public void testLoginWithValidUserInvalidPassword() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs/");
        WebElement loginFieldLink = driver.findElement(By.xpath("//a[@class='login-btn']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        loginFieldLink.click();
        Thread.sleep(2000);


        WebElement loginEmailField = driver.findElement(By.id("login_email"));
        loginEmailField.sendKeys(Strings.VALID_USER);

        WebElement loginPasswordField = driver.findElement(By.id("login_password"));
        loginPasswordField.sendKeys(Strings.INVALID_PASSWORD);

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-success btn-login confirm-loader']"));
        submitButton.click();






    }
    //*Test for opening profile page
    /* Steps to introduce
    1. User is loged in (https://www.knjizare-vulkan.rs/)
    2. User name is displayed
    3. Click on user name open profile page
    4. Validation: User picture is Displayed
     */
    @Test
    public void profilePage(){
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs/");
        WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(cookieConsent));
        cookieConsent.click();

        WebElement userProfile = driver.findElement(By.xpath("//div[@class='row']//a[@href='https://www.knjizare-vulkan.rs/profil']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(userProfile));
        userProfile.isDisplayed();
        userProfile.click();
    }


}
