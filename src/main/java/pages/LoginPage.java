package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage{

    @FindBy(id="login_email")
    WebElement userEmailField;

    @FindBy(id="login_password")
    WebElement userPasswordField;

    @FindBy(xpath = ("//button[contains(text(),'submit')]"))
    WebElement submitButton;

    ChromeDriver driver = null;
    public LoginPage(ChromeDriver driver) {
        driver.get("https://www.knjizare-vulkan.rs/");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public LoginPage enterUserEmailField(String emailText) {
        userEmailField.click();
        userEmailField.clear();
        userEmailField.sendKeys(emailText);
        return this;
    }

    public LoginPage clickSubmitButton(){
        submitButton.click();
        return this;
      }

    public LoginPage enterPassword(String passwordText){
        userPasswordField.click();
        userPasswordField.clear();
        userPasswordField.sendKeys(passwordText);
        return this;
    }






}
