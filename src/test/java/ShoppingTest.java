import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Strings;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        WebElement cookieConsent = driver.findElement(By.xpath("//button[@class='cookie-agree 3'][.//span[contains(text(), 'Slažem se')]]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOf(cookieConsent));
        cookieConsent.click();

        WebElement searchLocator = driver.findElement(By.xpath("//div[@data-content='Pretraži sajt']"));
        searchLocator.click();


        WebElement searchField = driver.findElement(By.id("search-text"));
        Thread.sleep(2000);


        searchField.click();
        searchField.clear();
        searchField.sendKeys("Prokleta avlija");
        searchField.sendKeys(Keys.ENTER);

    }

    //* Test Promotivna besplatna isporuka
    /* Steps:
    1. Navigate to Main Page
    2. Click on Free Shipping
    3. Go to page  FREE_DELIVERY
    4. Page with title "BESPLATNA ISPORUKA ZA BILO KOJI IZNOS KUPOVNINE" is Opened

     */
    @Test
    public void freeDelivery(){
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs");

        clearCookies(driver);


        WebElement freeDelivery = driver.findElement(By.xpath("//div[@data-promotion-item-id='231']"));
        freeDelivery.click();

        String titleFreeDelivery= driver.getTitle();
        System.out.println(" [TEST REPORT ] Prikaz naslova na strani Terms Of Use: " + titleFreeDelivery);

        String currentPageURL = driver.getCurrentUrl();
        Assert.assertTrue("We are not logged in. Expected url : " + Strings.FREE_DELIVERY +
                ". Actual: " + currentPageURL, currentPageURL.contains(Strings.FREE_DELIVERY));

    }


    //* Testig Article View
    /* Steps:
    1. Navigate to first page (https://www.knjizare-vulkan.rs)
    2. Close Cookies
    3. Select School Program from Menu
    4. Click on School Program
    5. Page https://www.knjizare-vulkan.rs/program-za-skolu Will Be Opened
    6. Choose an Item from the page (In this case - Pernica STUDIO PETS CAT)
    7. Click on that Item (Item Details are shown in new Window )


     */



    @Test
    public void articleSingleView()throws Exception{
        ChromeDriver driver = openChromeDriver();
        try {
            driver.get("https://www.knjizare-vulkan.rs");
            clearCookies(driver);

            WebElement schoolProgram = driver.findElement(By.xpath("//a[@href='https://www.knjizare-vulkan.rs/program-za-skolu']"));
            schoolProgram.click();

            WebElement childPencilBox = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/div[5]/div/div[2]/div/div/div[7]/div[1]/div[1]/a[2]"));
            childPencilBox.click();

            Thread.sleep(3000);

        } finally {

            driver.quit();

        }

    }

    //Test - Shopping Cart Overview and continue shopping
    /* Steps:
    1. Navigate to shopping cart
    2. Message: "Vasa korpa je prazna" is Displayed
    3. Click on Button: Continue Shopping
    4. Page wits products is Displayed
    5. Click on Top List to see more items
    6. Assert: Page - Top list is opened
     */

    @Test
    public void continueShopping(){
        ChromeDriver driver = openChromeDriver();

        driver.get("https://www.knjizare-vulkan.rs/kupovina");
        clearCookies(driver);

        WebElement alertMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger' ]"));
        alertMessage.isDisplayed();

        WebElement continueShopping = driver.findElement(By.xpath("//div/a[@href='https://www.knjizare-vulkan.rs/proizvodi' ]"));
        continueShopping.click();

        WebElement topList = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/div[1]/div/div[1]/div/h2/a"));
        topList.click();

        String currentPageURL = driver.getCurrentUrl();
        Assert.assertTrue("We are not logged in. Expected url : " + Strings.TOP_LIST +
                ". Actual: " + currentPageURL, currentPageURL.contains(Strings.TOP_LIST));




    }



    /*
    @Test

    public void thrillerViewInBooks(){
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs");
        clearCookies(driver);

        WebElement bookElement = driver.findElement(By.xpath("//a[@title='Knjige']"));

        WebElement bookRoman = driver.findElement(By.xpath("//li[@class='slider_menu_romani']/a[@title='ROMANI']"));

        //WebElement bookThriller = driver.findElement(By.xpath("//a[@href='https://www.knjizare-vulkan.rs/trileri-misterije']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(bookElement).perform();

        actions.moveToElement(bookRoman).perform();

        //actions.moveToElement(bookThriller).perform();

        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        //wait.until(ExpectedConditions.visibilityOf(bookThriller));
        //wait.until(ExpectedConditions.elementToBeClickable(bookThriller));


        //wait.until(ExpectedConditions.visibilityOfAllElements());

        //bookThriller.click();

    }


*/


}
