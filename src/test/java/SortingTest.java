import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortingTest extends BaseTest {

//Test - Sorting Items By Name

    /* Steps:
    1. Navigate to Page "https://www.knjizare-vulkan.rs/romani/";
    2. Mouse Hover Knjige and Romani
    3. Click on Romani;
    4. Wait Until Items be Visible
    5. Select Option Po nazivu (By Name) in Select Dropdown Box
    6. Romans are sorted By Name.
    7. Wait while Page is loading.


     */
    @Test

    public void sortingItemsByName(){

        ChromeDriver driver = openChromeDriver();

        driver.get("https://www.knjizare-vulkan.rs");
        clearCookies(driver);

        WebElement bookElement = driver.findElement(By.xpath("//a[@href='https://www.knjizare-vulkan.rs/knjige-domace']"));
        WebElement bookRoman = driver.findElement(By.xpath("//a[@href='https://www.knjizare-vulkan.rs/romani']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(bookElement).perform();
        actions.moveToElement(bookRoman).perform();
        bookRoman.click();
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='block products-listing product product-listing-items ']"),0));

        Select dropdown = new Select(driver.findElement(By.id("sort")));
        dropdown.selectByVisibleText("Po nazivu");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='block products-listing product product-listing-items ']"),0));




    }



}
