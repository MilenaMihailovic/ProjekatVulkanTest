import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
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

    //** Test for closing cookie

    /* Steps to introduce:

    1. Open Web Site (https://www.knjizare-vulkan.rs/), Cookie will Appear
    2. Locate Button "Slazem se"
    3. Click on Button and close Cookie
     */


    @Test
    public void testVulkan(){
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs/");
        WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(cookieConsent));

        cookieConsent.click();

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
        driver.get("https://www.knjizare-vulkan.rs/");
        WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(cookieConsent));
        cookieConsent.click();

        WebElement termsOfUse = driver.findElement(By.xpath("//a[@href='https://www.knjizare-vulkan.rs/uslovi-koriscenja'][contains(text(),'Uslovi')]"));
        termsOfUse.click();

        /*String currentPageURL = driver.getCurrentUrl();
        Assert.assertTrue("We are not on expected Page. Expected url : " + Strings.TERMS_OF_USE +
                ". Actual: " + currentPageURL,currentPageURL.contains(Strings.TERMS_OF_USE));*/
    }












}
