using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using SeleniumFramework.Pages;
using SeleniumFramework.Steps;

namespace Test
{
    [TestClass]
    public class ContactPageTest
    {
        private const string BASE_URL = "https://ostrovok.ru/feedback/";
        private const string EMAIL = "example@mail.ru";
        private const string BOOK_NUMBER = "3";
        private const string QUESTION = "question";
        private const string XPATH_SEND_MESSAGE = "//div[@class='zenfeedback-inner']";
        Step step;

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
        public void AskQuestionTest()
        {
            ContactPage contactPage = new ContactPage(step.driver);
            step.GoToPage(BASE_URL);
            contactPage.AskQuestion(EMAIL, BOOK_NUMBER, QUESTION);
            Assert.IsTrue(step.driver.FindElement(By.XPath(XPATH_SEND_MESSAGE)).Displayed);
        }
    }
}
