package ru.mail.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class MailBoxPage {

    MailBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "PH_user-email")
    WebElement userProfile;

    @FindBy(id = "PH_logoutLink")
    WebElement buttonLogout;

    @FindBy(linkText = "Написать письмо")
    WebElement createMessage;

    @FindBy(css = "[data-original-name=\"To\"]")
    WebElement mailToField;

    @FindBy(css = "[title=\"{#aria.rich_text_area}\"]")
    WebElement messageField;

    @FindBy(css = "[data-name=\"send\"]")
    WebElement sendMailButton;

    @FindBy(xpath = "//*[@id=\"b-compose__sent\"]/div/div[2]/div[1]")
    WebElement sendPassed;

    String getUserMail() {
        return userProfile.getText();
    }

    void userLogout() {
        buttonLogout.click();
    }

    void newMessage() {
        createMessage.click();
    }

    void toMail(String email) {
        mailToField.sendKeys(email);
    }

    void messageText() {
        messageField.sendKeys("test");
    }
}
