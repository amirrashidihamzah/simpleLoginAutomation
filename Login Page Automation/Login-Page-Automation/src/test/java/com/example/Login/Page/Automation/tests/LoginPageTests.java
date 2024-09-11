package com.example.Login.Page.Automation.tests;

import com.example.Login.Page.Automation.pageObjectMethods.LoginPageMethod;
import com.example.Login.Page.Automation.setup.AutomatedSetup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginPageTests {

    @Autowired
    private AutomatedSetup automatedSetup;

    private static final String URL = "https://www.saucedemo.com/";

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "edge"})
    void givenDifferentBrowser_whenValidUserNamePassword_thenHomePageDisplay(String browserType) {
        automatedSetup.setupDriver(browserType);

        // Retrieve the driver and wait instances
        WebDriver driver = automatedSetup.getDriver();
        WebDriverWait wait = automatedSetup.getWait();

        driver.get(URL);
        LoginPageMethod loginPage = new LoginPageMethod(driver, wait);
        loginPage.validUserNamePassword("standard_user", "secret_sauce");

        driver.quit();
    }
}
