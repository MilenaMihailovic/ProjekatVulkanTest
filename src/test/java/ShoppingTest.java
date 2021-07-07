import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.*;

public class ShoppingTest extends BaseTest{

    //* Test Entering Book Name in Search Field
    /*
    Steps to introduce:
    1. Navigate to https://www.knjizare-vulkan.rs/
    2. Click on Search Field
    3. Type in 'Prokleta avlija'
    4. Press Key ENTER
    5. Expected Result: "Book with title 'Prokleta avlija' will be Displayed on page: "https://www.knjizare-vulkan.rs/proizvodi?search=Prokleta+avlija"
     */

    @Test
    public void searchingItem() throws InterruptedException {
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs/");
/*        WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(cookieConsent));
        cookieConsent.click();*/


        WebElement searchField = driver.findElement(By.xpath("//div[@class='container']//div[@class='block autocomplete-button  autocomplete-button-simple']"));
       // wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        Thread.sleep(2000);


        searchField.click();
        searchField.clear();
        searchField.sendKeys("Prokleta avlija");
        searchField.sendKeys(Keys.ENTER);

    }



}
