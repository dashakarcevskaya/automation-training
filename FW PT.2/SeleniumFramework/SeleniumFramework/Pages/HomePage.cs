using log4net;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using OpenQA.Selenium.Support.UI;
using SeleniumFramework.Model;
using System;
using System.Collections.Generic;

namespace SeleniumFramework.Pages
{
    public class HomePage
    {
        public const string XPATHEMAIL = "input.zenforminput-control[name='email']";
        public const string XPATHPASSWORD = "input.zenforminput-control[name='pass']";
        public const string XPATHNAMECITY = "//*[@id=':0']/div/div/div[1]/div/div[3]/div/div/div/div[1]/div/label/div[2]/input";
        public const string XPATHNUMBER = "//div[@class='Day__inner--1kyRv Day__inner_locked--2etRy Day__inner_selected--3eqFt Day__inner_edgeDay--1K1eT Day__inner_withLeftRadius--3nDHR']";
        private IWebDriver driver;
        private ILog log = LogManager.GetLogger(typeof(HomePage));

        [FindsBy(How = How.XPath, Using = "/html/body/div[1]/div[2]/div/div/div[4]")]
        public IWebElement PersonalAccount { get; set; }

        [FindsBy(How = How.CssSelector, Using = XPATHEMAIL)]
        public IWebElement PersonalAccountEmail { get; set; }

        [FindsBy(How = How.CssSelector, Using = XPATHPASSWORD)]
        public IWebElement PersonalAccountPassword { get; set; }

        [FindsBy(How = How.XPath, Using = "/html/body/div[1]/div[2]/div/div/div[4]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/form/div[2]/button[1]")]
        public IWebElement ButtonLogin { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='SearchForm__dates--3XSQc SearchForm__control--2yett']//label[1]")]
        public IWebElement ArrivalDate { get; set; }

        [FindsBy(How = How.XPath, Using = XPATHNUMBER)]
        public IWebElement TitleArrivalDate { get; set; }

        [FindsBy(How = How.XPath, Using = "//*[@id=':0']/div/div/div[1]/div/div[3]/div/div/div/div[3]/div/label/div[2]/div[2]")]
        public IWebElement Guests { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='Room__line--385ZF']//div[1]//div[2]//button[1]")]
        public IWebElement ButtonPlusGuests { get; set; }

        [FindsBy(How = How.XPath, Using = XPATHNAMECITY)]
        public IWebElement Distantion { get; set; }

        [FindsBy(How = How.XPath, Using = "//*[@id=':0']/div/div/div[1]/div/div[1]")]
        public IWebElement TitleDistantion { get; set; }

        [FindsBy(How = How.XPath, Using = "//*[@id=':0']/div/div/div[1]/div/div[3]/div/div/div/div[4]/button")]
        public IWebElement ButtonSearch { get; set; }

        [FindsBy(How = How.XPath, Using = "//select[@class='zen-header-select-list']")]
        public IWebElement ButtonChangeLanguage { get; set; }

        [FindsBy(How = How.XPath, Using = "//option[contains(text(),'Español')]")]
        public IWebElement EnglishLanguage { get; set; }

        [FindsBy(How = How.XPath, Using = "//option[contains(text(),'USD')]")]
        public IWebElement ValueUSD { get; set; }

        [FindsBy(How = How.XPath, Using = "//select[@class='zen-currency-select-list']")]
        public IWebElement ButtonChangeValue { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='zenheaderhelpcenter-button']")]
        public IWebElement ButtonOnlineChat { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='zenheaderhelpcenter-menu-send-message-chat-button button-view-primary button-size-m']")]
        public IWebElement ChatWebSite { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='scroll-content']//input[@name='name']")]
        public IWebElement ChatName { get; set; }

        [FindsBy(How = How.XPath, Using = "//body[@class='ru mobileready body-home body-home-loaded']/div[@id='webim_chat']/div[@class='webim-chat-block']/div[@class='webim-chat']/div[@class='webim-resizable ui-resizable']/div[@class='webim-body']/div[@class='webim-sections']/div[@class='webim-section webim-section-online']/div[@class='webim-section webim-section-first-question']/div[@class='webim-question-block webim-ready']/div[@class='webim-auto-height-wrapper']/div[@class='scroll-wrapper']/div[@class='scroll-content scroll-scrolly_visible']/div[@class='webim-form']/div[@class='webim-form-control']/label[@class='webim-label webim-js-overlabel']/span[1] ")]
        public IWebElement ChatMessage { get; set; }

        [FindsBy(How = How.XPath, Using = "/button[@class='webim-btn webim-btn-send']")]
        public IWebElement ButtonStartDialog { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='zen-headermenu-wrapper']")]
        public IWebElement MenuButton { get; set; }

        [FindsBy(How = How.XPath, Using = "//div[@class='layout layout-desktop']//li[4]")]
        public IWebElement CustomerButton { get; set; }

        public HomePage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(driver, this);
            new WebDriverWait(driver, TimeSpan.FromSeconds(30));
            log4net.Config.DOMConfigurator.Configure();
            log.Info("HomePage created");
        }

        public void SignIn(User user)
        {
            PersonalAccount.Click();
            PersonalAccountEmail.Click();
            PersonalAccountEmail.SendKeys(user.Email);
            PersonalAccountPassword.Click();
            PersonalAccountPassword.SendKeys(user.Password);
            ButtonLogin.Click();
            log.Info("Person signed up");
        }

        public void ChangeLanguage()
        {
            ButtonChangeLanguage.Click();
            EnglishLanguage.Click();
            log.Info("Language changed");
        }

        public void ChangeValue()
        {
            ButtonChangeValue.Click();
            ValueUSD.Click();
            log.Info("Value changed");
        }

        public ContactPage CustomerSupport()
        {
            MenuButton.Click();
            CustomerButton.Click();
            log.Info("Go to CustomerSupportPage");
            return new ContactPage(driver);
        }
     }
}
