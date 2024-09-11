package com.example.Login.Page.Automation.pageObjectMethods;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class LoginPageMethod {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="user-name")
    WebElement userNameInput;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(id="login-button")
    WebElement loginButton;

    public LoginPageMethod(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void validUserNamePassword(String userName, String password){
        wait.until(ExpectedConditions.visibilityOf(userNameInput)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);

        loginButton.click();
    }
}
