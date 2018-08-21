package ru.mail.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

class LoginPage {

    LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(id = "mailbox:submit")
    private WebElement loginButton;

    @FindBy(id = "mailbox:domain")
    private WebElement domainSelect;


    void inputLogin(String login) {
        loginField.sendKeys(login.split("@")[0]);
    }

    void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    void inputDomain(String login) {
        getServers().selectByVisibleText("@" + login.split("@")[1]);
    }

    void clickLoginButton() {
        loginButton.click();
    }

    private Select getServers() {
        return new Select(domainSelect);
    }
}
