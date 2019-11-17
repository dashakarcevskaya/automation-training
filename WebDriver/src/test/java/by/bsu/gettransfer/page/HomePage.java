package by.bsu.gettransfer.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
    private final String HOMEPAGE_URL = "https://www.gettransfer.com/";
    private final int WAIT_TIMEOUT_SECONDS = 40;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(HOMEPAGE_URL);
        PageFactory.initElements(this.driver, this);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @FindBy(xpath = "//*[@id=\"from\"]")
    private WebElement pickUpLocation;

    @FindBy(xpath = "//*[@id=\"to\"]")
    private WebElement returnLocation;

    @FindBy(xpath = "//*[@id=\"short-form-submit-btn\"]")
    private WebElement selectCar;

    @FindBy(xpath = "//*[@id=\"new-transfer-form\"]/div[3]/div[9]/div/button")
    private WebElement getOffers;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"menu_home_page\"]/div/div/div/nav/div/ul[1]/li[6]/a")
    private WebElement signUp;

    @FindBy(xpath = "//*[@id=\"full_name\"]")
    private WebElement fullName;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement registrationNumber;

    @FindBy(xpath = "//*[@id=\"sign_in-window\"]/form/div[7]/button")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneNumberInSignUpForm;


    public void inputPickUpLocation(String picLoc) {
        pickUpLocation.clear();
        pickUpLocation.sendKeys(picLoc);
    }

    public void inputReturnLocation(String retLoc) {
        returnLocation.clear();
        returnLocation.sendKeys(retLoc);
    }

    public void selectCar() {
        selectCar.click();
    }

    public void getOffers() {
        getOffers.click();
    }

    public void enterPhoneNumber(String number) {
        phoneNumber.clear();
        phoneNumber.sendKeys(number);
    }

    public void signUp() {
        signUp.click();
    }

    public void enterFullName(String name) {
        fullName.clear();
        fullName.sendKeys(name);
    }

    public void signUpClick() {
        signUpButton.click();
    }

    public void enterPhoneNumberInSignUpForm(String number) {
        phoneNumberInSignUpForm.clear();
        phoneNumberInSignUpForm.sendKeys(number);
    }


    public boolean isErrorMessageVisible1() {
        WebElement errorMessage =
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[@id=\"sign_in-window\"]/form/div[4]/span[2]")));
        return errorMessage.isDisplayed();
    }

    public boolean isErrorMessageVisible2() {
        WebElement errorMessage =
                new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[@id=\"new-transfer-form\"]/div[3]/div[7]/div/span[2]")));
        return errorMessage.isDisplayed();
    }
}
