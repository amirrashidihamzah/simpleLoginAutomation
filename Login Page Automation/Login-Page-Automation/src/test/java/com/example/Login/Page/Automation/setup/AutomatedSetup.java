package com.example.Login.Page.Automation.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@Data
public class AutomatedSetup {

    private WebDriver driver;
    private WebDriverWait wait;

    // Factory method to create a driver based on browser type
    public void setupDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                setupChromeDriver();
                break;
            case "firefox":
                setupGeckoDriver();
                break;
            case "edge":
                setupEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }


    public void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Options();
    }

    private void setupGeckoDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        Options();
    }

    private void setupEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        Options();
    }

    private void Options(){
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
