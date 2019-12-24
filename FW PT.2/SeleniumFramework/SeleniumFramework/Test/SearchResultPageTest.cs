using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using SeleniumFramework.Steps;


namespace SeleniumFramework.Test
{
    [TestClass]
    public class SearchResultPageTest
    {
        private Step step;
        private const string CITY = "Москва";
        private const string PRICE = "10000";
        public const string BASE_URL = "https://ostrovok.ru/";
        private const string XPATH_SORT = "//div//p[contains(text(),'Сначала дорогие')]";
        private const string XPATH_RATING = "//div[@class='zen-hotels-filter zen-hotels-filter-rating']//div[@class='zen-filter']//div[1]//label[1]//div[2]";
        private const string XPATH_MAX_PRICE = "//div/label//input[@id='goog_1265449482']";

        [TestInitialize]
        public void SetupTest()
        {
            step = new Step();
            step.InitBrowser();
        }

        [TestCleanup]
        public void TeardownTest()
        {
            step.CloseBrowser();
        }

        [TestMethod]
        public void SortingHotelsTest()
        {
            step.GoToPage(BASE_URL);
            step.SortingHotels(CITY);
            Assert.IsTrue(step.driver.FindElement(By.XPath(XPATH_SORT)).Displayed);
        }

        [TestMethod]
        public void ChooseMealTest()
        {
            step.GoToPage(BASE_URL);
            step.ChooseMeal(CITY);
            Assert.IsTrue(step.driver.FindElement(By.XPath(XPATH_RATING)).Displayed);
        }

        [TestMethod]
        public void SortByRatingTest()
        {
            step.GoToPage(BASE_URL);
            step.SortByRating(CITY);
            Assert.IsTrue(step.driver.FindElement(By.XPath(XPATH_RATING)).Displayed);
        }

        [TestMethod]
        public void AskMaxPriceTest()
        {
            step.GoToPage(BASE_URL);
            step.AskMaxPrice(CITY, PRICE);
            Assert.IsTrue(step.driver.FindElement(By.XPath(XPATH_MAX_PRICE)).Displayed);
        }
    }
}
