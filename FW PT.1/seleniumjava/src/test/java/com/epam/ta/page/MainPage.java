package com.epam.ta.page;

import com.epam.ta.model.SearchQueryMain;
import com.epam.ta.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final static String XPATH_FOR_SEARCH_BUTTON = "//*(@id=':0')/div/div/div[1]/div/div[3]/div/div/div/div[4]/button";
	private final static String XPATH_FOR_ROOMS_BUTTON = "//*[@id=':0']/div/div/div[1]/div/div[3]/div/div/div/div[3]/div/label/div[2]/div[2]";
	private final static String XPATH_FOR_PLUSS_GUESTS = "//*[@id=':0']/div/div/div[1]/div/div[3]/div/div/div/div[3]/div/label/div[2]/div[2]";
	private final static String XPATH_FOR_DONE_BUTTON = " //button[@class='Button__button--2Bv_U Button__button_size_m--17NDb Button__button_wide--3B5Ul Form__button--2gKTS'] ";
	private final static String XPATH_FOR_NUMBER_DATE = "//*[@id=':0']/div/div/div[1]/div/div[3]/div/div/div/div[2]/div/div/label[1]";
	private final static String XPATH_FOR_NUMBER_DEPARTURE_DATE = "//[@id=':0']/div/div/div[1]/div/div[3]/div/div/div/div[2]/div/div/label[2]";
	private final static String XPATH_FOR_NUMBER_ARRIVAL_DATE = "/html/body/div[6]/div[2]/div[3]/div/div[1]/div[5]/div[4]";
	private final static String XPATH_FOR_DISTANTION = "//*(@id=':0')/div/div/div[1]/div/div[3]/div/div/div/div[1]/div/label/div[2]/input";
	private final static String XPATH_FOR_TITTLE_DISTANTION = "//*(@id=':0')/div/div/div[1]/div/div[1]";
	private final By loginErrorMessage = By.xpath("//div[@class='zen-authpane-signin-error-message']");
	private final By userName = By.xpath("/html/body/div[1]/div[1]/header/div/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/span");

	     @FindBy( xpath = "/html/body/div[1]/div[2]/div/div/div[4]")
	public WebElement personalAccount;

        @FindBy(xpath = "//input.zenforminput-control(@name='email')")
	public WebElement personalAccountEmail ;

        @FindBy(css = "input.zenforminput-control(name='pass')")
	public WebElement personalAccountPassword;

        @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[4]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/form/div[2]/button[1]")
	public WebElement buttonLogin;

        @FindBy(xpath = XPATH_FOR_NUMBER_DATE)
	public WebElement date;

        @FindBy(xpath = XPATH_FOR_NUMBER_ARRIVAL_DATE)
	public WebElement titleArrivalDate;

        @FindBy(xpath = XPATH_FOR_NUMBER_DEPARTURE_DATE)
	public WebElement tittleDepartureDate;

        @FindBy(xpath  = XPATH_FOR_ROOMS_BUTTON)
	public WebElement guests;

        @FindBy(css = XPATH_FOR_PLUSS_GUESTS)
	public WebElement buttonPlusGuests;

	@FindBy(css = XPATH_FOR_DONE_BUTTON)
	public WebElement doneButton;

        @FindBy(xpath = XPATH_FOR_DISTANTION)
	public WebElement distantion;

        @FindBy(xpath =  XPATH_FOR_TITTLE_DISTANTION)
	public WebElement titleDistantion;

        @FindBy(xpath = XPATH_FOR_SEARCH_BUTTON)
	public WebElement buttonSearch;

	private final String BASE_URL = "https://ostrovok.ru/?sid=e3f58065-543e-4e70-b30a-82a7d16d821b";

	private WebDriver driver;
	WebElement source;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public void loginEntry(User user)
	{
		personalAccount.click();
		personalAccountEmail.sendKeys(user.getUsername());
		personalAccountPassword.sendKeys(user.getPassword());
		buttonLogin.click();
	}

	public MainPage inputLogin(User user)
	{
		loginEntry(user);
		return new MainPage(driver);
	}

	public String getLoggedInUserName()
	{
		WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(userName));
		return linkLoggedInUser.getText();
	}
	public String getLoginErrorMessage()
	{
		WebElement linkLoginErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(loginErrorMessage));
		return linkLoginErrorMessage.getText();
	}

	public SearchHotelResultPage searchHotelsByParameters(SearchQueryMain query) {
		distantion.click();
		titleDistantion.sendKeys(query.getPlace());
		date.click();
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_TITTLE_DISTANTION)));
		titleArrivalDate.sendKeys(query.getArrivalDate());
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_NUMBER_DEPARTURE_DATE)));
		tittleDepartureDate.sendKeys(query.getDepartureDate());
		guests.click();
		buttonPlusGuests.sendKeys(query.getRoomsNumber());
		doneButton.click();
		buttonSearch = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_SEARCH_BUTTON)));
		buttonSearch.click();
		return new SearchHotelResultPage(driver, query);
	}

	public MainPage searchHotelsByWrongParameters(SearchQueryMain query) {
		distantion.click();
		titleDistantion.sendKeys(query.getPlace());
		date.click();
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_TITTLE_DISTANTION)));
		titleArrivalDate.sendKeys(query.getArrivalDate());
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_NUMBER_DEPARTURE_DATE)));
		tittleDepartureDate.sendKeys(query.getDepartureDate());
		buttonSearch = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_SEARCH_BUTTON)));
		buttonSearch.click();
		return new MainPage(driver);
	}

	public String errorMessage(){

		return this.errorMessage.getText();
	}

}

