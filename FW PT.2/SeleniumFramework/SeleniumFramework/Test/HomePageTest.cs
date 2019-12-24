using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using SeleniumFramework.Model;
using SeleniumFramework.Pages;
using SeleniumFramework.Steps;

namespace Test
{
    [TestClass]
    public class HomePageTest
    {
        public const string BASE_URL = "https://ostrovok.ru/";
        public const string CITY = "Москва";
        private const string LANGUAGE = "Русский";
        public const string BUTTON_CITY = "Москва, Россия";
        public const string EMAIL = "example@gmail.com";
        public const string PASSWORD = "example12345";
        private const string ERROR_MESSAGE = "Указан неправильный пароль или электронный адрес";
        private const string VALUE = "BYN";
        private const string XPATH_LANGUAGE = "//div[@class='zen-header-select-value']";
        private const string XPATH_VALUE = "//div[@class='zen-currency-select-value']";
        private const string XPATH_ERROR_MESSAGE = "zen-authpane-signin-error-message";
        private const string XPATH_CUSTOM_SUPPORT = "//h1[@class='zenfeedback-form-title']";

        private Step step;
        private HomePage homePage;

        [TestInitialize]
        public void SetupTest()
        {
            step = new Step();
            step.InitBrowser();
            homePage = new HomePage(step.driver);
        }

        [TestCleanup]
        public void TeardownTest()
        {
           step.CloseBrowser();
        }

        [TestMethod]
        public void CustomerSupportTest()
        {
            step.GoToPage(BASE_URL);
            homePage.CustomerSupport();
            Assert.IsTrue(step.driver.FindElement(By.XPath(XPATH_CUSTOM_SUPPORT)).Displayed);
        }

        [TestMethod]
        public void SignUpErrorTest()
        {
            User user = new User(EMAIL, PASSWORD);
            step.GoToPage(BASE_URL);
            homePage.SignIn(user);
            Assert.AreEqual(ERROR_MESSAGE, step.driver.FindElement(By.ClassName(XPATH_ERROR_MESSAGE)).Text);
        }

        [TestMethod]
        public void ChangeLanguageTest()
        {
            step.GoToPage(BASE_URL);
            Assert.AreEqual(LANGUAGE, step.driver.FindElement(By.XPath(XPATH_LANGUAGE)).Text);
            homePage.ChangeLanguage();
        }

        [TestMethod]
        public void ChangeValueTest()
        {
            step.GoToPage(BASE_URL);
            Assert.AreEqual(VALUE, step.driver.FindElement(By.XPath(XPATH_VALUE)).Text);
            homePage.ChangeValue();
        }

        [TestMethod]
        public void SearchTest()
        {
            step.GoToPage(BASE_URL);
            var searchResult = step.Search(CITY);
            Assert.IsTrue(searchResult.Result.Displayed);
        }
    }
}
