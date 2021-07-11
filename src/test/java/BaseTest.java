import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Strings;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver = null;

    public ChromeDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }



// metoda za zatvaranje cookies

    public void clearCookies(WebDriver driver){

        WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(cookieConsent));

        cookieConsent.click();

    }
    // helper metoda za logovanje korisnika

    public void loginUser(){
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs/");
        clearCookies(driver);
        WebElement logInUser = driver.findElement(By.xpath("//a[@class='login-btn']"));
        logInUser.click();

        WebElement loginEmailField = driver.findElement(By.id("login_email"));
        loginEmailField.sendKeys(Strings.VALID_USER);

        WebElement loginPasswordField = driver.findElement(By.id("login_password"));
        loginPasswordField.sendKeys(Strings.VALID_PASSWORD);

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-success btn-login confirm-loader']"));
        submitButton.click();


    }



    /** Test to open Using Conditions Terms

     /* Steps to introduce:
     1. User is on Main page;
     2. Click on link 'Uslovi koristenja"
     3. Open new page (https://www.knjizare-vulkan.rs/uslovi-koriscenja)
     4. Verification: Page consist Terms of Use

     **/
    @Test

    public void termsOfUse(){
        ChromeDriver driver = openChromeDriver();
        try {
            driver.get("https://www.knjizare-vulkan.rs/");
            WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            wait.until(ExpectedConditions.visibilityOf(cookieConsent));
            cookieConsent.click();

            WebElement termsOfUse = driver.findElement(By.xpath("//a[@title='Uslovi korišćenja']"));
            termsOfUse.click();


            WebElement titleOfTerms = driver.findElement(By.xpath("*//span[contains(text(),'Uslovi korišćenja i prodaje')]"));
            titleOfTerms.isDisplayed();


            String titleTermsOfUse = driver.getTitle();
            System.out.println(" [TEST REPORT ] Prikaz naslova na strani Terms Of Use: " + titleTermsOfUse);


        } finally {

            driver.quit();
        }



    }












}
