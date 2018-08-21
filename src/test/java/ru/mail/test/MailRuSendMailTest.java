package ru.mail.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MailRuSendMailTest {

    private String login = "your@email.address";
    private String password = "yourPassword";

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static MailBoxPage mailBoxPage;


    @BeforeGroups("Mail")
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "/path/to/you/geckodriver");
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
        driver.get("https://mail.ru/");
    }

    @Test(groups = {"Mail"})
    public void loginTest() {
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.inputDomain(login);
        loginPage.clickLoginButton();
        mailBoxPage.newMessage();
        Assert.assertEquals(login, mailBoxPage.getUserMail());
    }

    @Test(groups = {"Mail"})
    public void newMessageTest() {
        mailBoxPage.newMessage();
        mailBoxPage.toMail(login);
        mailBoxPage.messageText();
        mailBoxPage.sendMailButton.click();
        Assert.assertEquals(mailBoxPage.sendPassed.getText(), "Получатели: " + login);
    }

    @AfterGroups("Mail")
    public void tearDown() {
        mailBoxPage.userLogout();
        driver.quit();
    }
}
