using log4net;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using OpenQA.Selenium.Support.UI;
using SeleniumFramework.Steps;
using System;

namespace SeleniumFramework.Pages
{
    public class SearchResultPage
    {
        [FindsBy(How = How.XPath, Using = "//div[@class='zenformselect zenformselect-size-xs']")]
        public IWebElement Sorting { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='zen-hotels-leftbar-regioninfo']")]
        public IWebElement Result { get; set; }

        [FindsBy(How = How.XPath, Using = "//li[@class='zendropdownlist-item zendropdownlist-item-price.desc']")]
        public IWebElement FirstExpensiveHotels { get; set; }

        [FindsBy(How = How.XPath, Using = "//body[@class='ru body-hotels mobileready']/div[@class='layout layout-desktop']/div[@class='layout-page-wrapper']/div[@class='page']/div[@class='page-content']/div[@id=':0']/div[@class='zen-hotels-wrapper clearfix']/div[@class='zen-hotels zen-hotels-rightbar-medium zen-hotels-scrolled']/div[@class='zen-hotels-main']/div[@class='zen-hotels-content-wrapper']/div[@class='zen-hotels-content']/aside[@class='zen-hotels-leftbar']/div[@class='zen-hotels-leftbar-content']/div[@class='zen-hotels-filters']/div[@class='zen-hotels-filters-inner']/div[@class='zen-hotels-filter zen-hotels-filter-mealtypes']/div[@class='zen-filter']/div[@class='zen-filter-checkbox-fields']/div[1]")]
        public IWebElement AddBreakfastButton { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='zen-hotels-filter zen-hotels-filter-rating']//div[@class='zen-filter']//div[1]//label[1]//div[2]")]
        public IWebElement RatingButton { get; set; }

        [FindsBy(How = How.XPath, Using = "//div/label//input[@id='goog_1265449482']")]
        public IWebElement MaxPrice { get; set; }
        private ILog log = LogManager.GetLogger(typeof(SearchResultPage));

        private IWebDriver driver;
        Step step = new Step();

        public SearchResultPage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(driver, this);
            new WebDriverWait(driver, TimeSpan.FromSeconds(30));
            log4net.Config.DOMConfigurator.Configure();
            log.Info("SearchPage created");
        }
    }
}
