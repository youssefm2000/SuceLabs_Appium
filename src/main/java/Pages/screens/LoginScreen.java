package Pages.screens;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginScreen {
    private final By openMenuLocator = AppiumBy.xpath("//*[@content-desc=\"open menu\"]");
    private final By loginmenu = AppiumBy.accessibilityId("menu item log in");
    private final By userNameLocator = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]");
    private final By passwordLocator = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]");
    private final By loginButtonLocator = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]");
    private final By headertitle = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");

    AndroidDriver driver;
    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
    }



    @Step("login Using Valid Email And Password ==> user Name: [{username}], password: [{password}]")
    @Test
    public void loginUsingValidEmailAndPassword(String username , String password) throws InterruptedException {
       WebElement menu = driver.findElement(openMenuLocator);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(menu));
        menu.click();

        Thread.sleep(3000);
        WebElement login = driver.findElement(loginmenu);
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        Thread.sleep(3000);
        WebElement userfield = driver.findElement(userNameLocator);
        wait.until(ExpectedConditions.elementToBeClickable(userfield));
        userfield.sendKeys(username);

        WebElement passfield = driver.findElement(passwordLocator);
        wait.until(ExpectedConditions.elementToBeClickable(passfield));
        passfield.sendKeys(password);

        driver.findElement(loginButtonLocator).click();

        Thread.sleep(2000);
        WebElement header = driver.findElement(headertitle);
        Assert.assertEquals(header.getText(),"Products");

    }

    @Step("login Using InValid Email And Password ==> user Name: [{username}], password: [{password}]")
    @Test
    public void loginUsingInValidEmailAndPassword(String username , String password) throws InterruptedException {
        WebElement menu = driver.findElement(openMenuLocator);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(menu));
        menu.click();

        Thread.sleep(3000);
        WebElement login = driver.findElement(loginmenu);
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();

        Thread.sleep(3000);
        WebElement userfield = driver.findElement(userNameLocator);
        wait.until(ExpectedConditions.elementToBeClickable(userfield));
        userfield.sendKeys(username);

        WebElement passfield = driver.findElement(passwordLocator);
        wait.until(ExpectedConditions.elementToBeClickable(passfield));
        passfield.sendKeys(password);

        driver.findElement(loginButtonLocator).click();


    }

}
