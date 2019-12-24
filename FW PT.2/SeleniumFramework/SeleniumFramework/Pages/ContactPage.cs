using log4net;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using OpenQA.Selenium.Support.UI;
using System;

namespace SeleniumFramework.Pages
{
    public class ContactPage
    {
        private IWebDriver driver;

        [FindsBy(How = How.XPath, Using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]")]
        public IWebElement Email { get; set; }

        [FindsBy(How = How.XPath, Using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/label[1]/input[1]")]
        public IWebElement BookingNumber { get; set; }

        [FindsBy(How = How.XPath, Using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/label[1]/textarea[1]")]
        public IWebElement Question { get; set; }

        [FindsBy(How = How.XPath, Using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")]
        public IWebElement ButtonSend { get; set; }
        private ILog log = LogManager.GetLogger(typeof(ContactPage));

        public ContactPage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(driver, this);
            new WebDriverWait(driver, TimeSpan.FromSeconds(30));
            log4net.Config.DOMConfigurator.Configure();
            log.Info("ContactPage created");
        }

        public ContactPage AskQuestion(string email, string bookingNumber, string question)
        {
            Email.SendKeys(email);
            BookingNumber.SendKeys(bookingNumber);
            Question.SendKeys(question);
            ButtonSend.Click();
            log.Info("Question askred");
            return new ContactPage(driver);
        }     
    }
}
