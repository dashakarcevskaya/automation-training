using log4net;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using SeleniumFramework.Pages;
using System;
using System.Linq;

namespace SeleniumFramework.Steps
{
    public class Step
    {
        public IWebDriver driver;
        private IWebElement source;
        private HomePage homePage;
        private SearchResultPage searchResultPage;
        private const string XPATH_SORTING = "//div[@class='zenformselect zenformselect-size-xs']";
        private const string XPATH_MEAL = "//body[@class='ru body-hotels mobileready']/div[@class='layout layout-desktop']/div[@class='layout-page-wrapper']/div[@class='page']/div[@class='page-content']/div[@id=':0']/div[@class='zen-hotels-wrapper clearfix']/div[@class='zen-hotels zen-hotels-rightbar-medium zen-hotels-scrolled']/div[@class='zen-hotels-main']/div[@class='zen-hotels-content-wrapper']/div[@class='zen-hotels-content']/aside[@class='zen-hotels-leftbar']/div[@class='zen-hotels-leftbar-content']/div[@class='zen-hotels-filters']/div[@class='zen-hotels-filters-inner']/div[@class='zen-hotels-filter zen-hotels-filter-mealtypes']/div[@class='zen-filter']/div[@class='zen-filter-checkbox-fields']/div[1]";
        private const string XPATH_RATING_BUTTON = "//div[@class='zen-hotels-filter zen-hotels-filter-rating']//div[@class='zen-filter']//div[1]//label[1]//div[2]";
        private ILog log = LogManager.GetLogger(typeof(Step));

        public Step()
        {
            log4net.Config.DOMConfigurator.Configure();
            log.Info("Step created");
        }
        public void InitBrowser()
        {
            driver = Driver.DriverInstance.GetInstance();
        }

        public void CloseBrowser()
        {
            Driver.DriverInstance.CloseBrowser();
        }

        public SearchResultPage Search(string city)
        {
            homePage = new HomePage(driver);
            homePage.Guests.Click();
            homePage.ButtonPlusGuests.Click();
            homePage.Distantion.Click();
            homePage.Distantion.Clear();
            homePage.Distantion.SendKeys(city);
            homePage.TitleDistantion.Click();
            homePage.ButtonSearch.Click();
            driver.SwitchTo().Window(driver.WindowHandles.Last());
            return new SearchResultPage(driver);
        }

        public SearchResultPage SortingHotels(string city)
        {
            searchResultPage = new SearchResultPage(driver);
            Search(city);
            new WebDriverWait(driver, TimeSpan.FromSeconds(50)).Until(ExpectedConditions
                .ElementExists(By.XPath(XPATH_SORTING)));
            searchResultPage.Sorting.Click();
            searchResultPage.FirstExpensiveHotels.Click();
            log.Info("Sorting by expensive price");
            return new SearchResultPage(driver);
        }

        public SearchResultPage ChooseMeal(string city)
        {
            searchResultPage = new SearchResultPage(driver);
            Search(city);
            new WebDriverWait(driver, TimeSpan.FromSeconds(50)).Until(ExpectedConditions
                .ElementExists(By.XPath(XPATH_RATING_BUTTON)));
            log.Info("Choose breakfast");
            return new SearchResultPage(driver);
        }

        public SearchResultPage SortByRating(string city)
        {
            searchResultPage = new SearchResultPage(driver);
            Search(city);
            new WebDriverWait(driver, TimeSpan.FromSeconds(50)).Until(ExpectedConditions
                .ElementExists(By.XPath(XPATH_RATING_BUTTON)));
            searchResultPage.RatingButton.Click();
            log.Info("Sorting by rating");
            return new SearchResultPage(driver);
        }

        public SearchResultPage AskMaxPrice(string city, string price)
        {
            searchResultPage = new SearchResultPage(driver);
            Search(city);
            new WebDriverWait(driver, TimeSpan.FromSeconds(70)).Until(ExpectedConditions
                .ElementExists(By.XPath(XPATH_RATING_BUTTON)));
            driver.FindElement(By.XPath("//div[@class='zen-filter-prices-indicator']"));
            searchResultPage.MaxPrice.SendKeys(price);
            log.Info("Sorting by max price");
            return new SearchResultPage(driver);
        }


        public void GoToPage(string url)
        {
            driver.Navigate().GoToUrl(url);
        }       
    }
}
