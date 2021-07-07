package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(id = "reg_firstname")
    WebElement firstNameField;

    @FindBy(id = "reg_lastname")
    WebElement lastNameField;

    @FindBy(name = "reg_email")
    WebElement registEmailField;

    @FindBy(id = "reg_phone")
    WebElement phoneNumberField;

    @FindBy(id = "reg_country_geo")
    WebElement nameCountryField;

    @FindBy(id = "reg_city")
    WebElement nameCityField;

    @FindBy(id = "reg_postcode")
    WebElement registerPostCodeField;

    @FindBy(id = "reg_address")
    WebElement streetNameField;

    @FindBy(id = "reg_street_no")
    WebElement streetNumberField;

    @FindBy(id = "reg_password")
    WebElement registrationPasswordField;

    @FindBy(id = "reg_password_repeat")
    WebElement confirmRegPasswordField;


    @FindBy(id = "reg_age")
    WebElement ageCheckBoxField;

    //radio Buttons Fields

    @FindBy(id = "reg_gender_1")
    WebElement radioButtonMale;

    @FindBy(id = "reg_gender_2")
    WebElement radioButtonFemale;

    @FindBy(id = "recaptcha-anchor")
    WebElement notRobotCheckBox;

    @FindBy(id = "reg_confirm")
    WebElement checkBoxAgreeField;

    @FindBy(xpath = "//button[@class='btn btn-success confirm-loader']")
    WebElement registrationButton;

    public RegistrationPage enterfirstNameField(String firstName) {
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }
    public RegistrationPage enterLastNameField(String lastName) {
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }
    public RegistrationPage enterRegistEmailField(String regEmail){
        registEmailField.click();
        registEmailField.clear();
        registEmailField.sendKeys(regEmail);
        return this;
    }

    public RegistrationPage enterPhoneNumber(String phoneNumber){
        phoneNumberField.click();
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
        return  this;
    }
    public RegistrationPage enterNameOfCountry(String counrtyName){
        nameCountryField.click();
        nameCountryField.clear();
        nameCountryField.sendKeys(counrtyName);
        return this;
    }
    public RegistrationPage enterCityNameField(String cityName){
        nameCityField.click();
        nameCityField.clear();
        nameCityField.sendKeys(cityName);
        return this;
    }
    public RegistrationPage enterPostCodeField(String postCode){
        registerPostCodeField.click();
        registerPostCodeField.clear();
        registerPostCodeField.sendKeys(postCode);
        return this;
    }
    public RegistrationPage enterStreetName(String streetName){
        streetNameField.click();
        streetNameField.clear();
        streetNameField.sendKeys(streetName);
        return this;
    }
    public RegistrationPage enterStreetNumber(String streetNumber){
        streetNumberField.click();
        streetNumberField.clear();
        streetNumberField.sendKeys(streetNumber);
        return this;
    }
    public RegistrationPage enterRegistrationPassword(String registrationPass){
        registrationPasswordField.click();
        registrationPasswordField.clear();
        registrationPasswordField.sendKeys(registrationPass);
        return this;
    }
    public RegistrationPage confirmPasswordField(String confirmPassword){
        confirmRegPasswordField.click();
        confirmRegPasswordField.clear();
        confirmRegPasswordField.sendKeys(confirmPassword);
        return this;
    }







    public RegistrationPage(ChromeDriver driver){
        super(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("We are not on Registration page", currentUrl.equals(Strings.MAIN_PAGE));
    }




}
