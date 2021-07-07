import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    //* Test: Registration New User
    /*Steps:
    1. Navigate to https://www.knjizare-vulkan.rs/
    2. Click on Register Link (New Form for entering Data is opened)
    3. Enter data in Fields
    4. Confirm Check Box "Da, imam više od 15 godina"
    5. Choose Gender ('Male')
    6. Confirm Check Box "Slažem se sa uslovima korišćenja"
     */
    @Test
    public void registrationUserTest() throws InterruptedException{
        ChromeDriver driver = openChromeDriver();
        driver.get("https://www.knjizare-vulkan.rs/");
        WebElement registrationLink = driver.findElement(By.xpath("//a[@class='register-btn']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        registrationLink.click();
        Thread.sleep(2000);

        WebElement firstNameField = driver.findElement(By.id("reg_firstname"));
        firstNameField.sendKeys("Marko");

        WebElement lastNameField = driver.findElement(By.id("reg_lastname"));
        lastNameField.sendKeys("Markovic");

        WebElement registerEmailField = driver.findElement(By.id("reg_email"));
        registerEmailField.sendKeys("marko@gmail.com");

        WebElement phoneNumberField = driver.findElement(By.id("reg_phone"));
        phoneNumberField.sendKeys("123456789");

        WebElement nameCountryField = driver.findElement(By.id("reg_country_geo"));
        nameCountryField.sendKeys("/Serbia");

        WebElement nameCityField = driver.findElement(By.id("reg_city"));
        nameCityField.sendKeys("Belgrade");

        WebElement registerPostCodeField = driver.findElement(By.id("reg_postcode"));
        registerPostCodeField.sendKeys("11001");

        WebElement streetNameField = driver.findElement(By.id("reg_address"));
        streetNameField.sendKeys("Stevana Sremca");

        WebElement streetNumberField = driver.findElement(By.id("reg_street_no"));
        streetNumberField.sendKeys("5a/25");

        WebElement registrationPasswordField = driver.findElement(By.id("reg_password"));
        registrationPasswordField.sendKeys("QATesting");

        WebElement confirmRegPasswordField = driver.findElement(By.id("reg_password_repeat"));
        confirmRegPasswordField.sendKeys("QATesting");

        WebElement checkAgeBox  = driver.findElement(By.xpath("//input[@id='reg_age']"));
        checkAgeBox.isSelected();
        checkAgeBox.click();


        /*if(!checkAgeBox.isSelected())
            checkAgeBox.click();
*/

        /* checkAgeBox.click();
        checkAgeBox.isSelected();
        */






    }



}
