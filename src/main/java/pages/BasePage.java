package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    ChromeDriver driver = null;

    public BasePage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

   /* public void clearCookies(WebDriver driver) {
        WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(cookieConsent));
        cookieConsent.click();
    }*/





}


