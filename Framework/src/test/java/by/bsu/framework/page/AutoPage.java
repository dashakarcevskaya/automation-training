package by.bsu.framework.page;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private final String AUTO_PAGE_URL = "https://gettransfer.com/en";

    public AutoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(xpath = "//div[@id='passenger-app']")

    //input[@id='date']
    @FindBy(xpath = "(//a[@class='modify-link'])[1]")
    private WebElement modifyLink;

    @FindBy(xpath = "(//input[@id='DropLoc_value'])")
    private WebElement dropLocValue;

    @FindBy(xpath = "(//button[@class='btn btn-green'])")
    private WebElement updateButton;

    @FindBy(xpath = "//div[@class='location-info']")
    private WebElement locationInfo;

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(AUTO_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.log(Level.INFO, "Auto page opened");
        return this;
    }

    public String pickUpLocationInfo() {
        return pickUpLocationInfo.getText();
    }

    public AutoPage clickModifyLink() {
        modifyLink.click();
        return this;
    }

    public AutoPage inputDropLocValue(String dropLoc) {
        dropLocValue.clear();
        dropLocValue.sendKeys(dropLoc);
        new WebDriverWait(driver, 40)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='angucomplete-row')]"))).click();
        return this;
    }

    public AutoPage clickUpdateButton() {
        updateButton.click();
        return this;
    }

    public String getLocationInfo() {
        return locationInfo.getText();
    }
}
