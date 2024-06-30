package Tests;
import Pages.screens.LoginScreen;
import Pages.utils.JsonFileManager;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Epic("Sauce labs Android App")
@Feature("End to End")
public class EndToEndTest {

    private AndroidDriver driver;
    private LoginScreen loginScreen;
    private final JsonFileManager ValidloginTestData = new JsonFileManager("src/test/resources/testData/ValidloginTestData.json");
    private final JsonFileManager InvalidloginTestData = new JsonFileManager("src/test/resources/testData/InvalidloginTestData.json");
    ;

    @BeforeMethod
    public void appDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "YoussefEmulator");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "C://Users//h//Desktop//EjadaAppium//src//test//resources//app//Android-MyDemoAppRN.1.3.0.build-244.apk");


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Story("Login with valid data")
    @Test
    public void loginValid() throws InterruptedException {

        loginScreen = new LoginScreen(driver);
        loginScreen.loginUsingValidEmailAndPassword(ValidloginTestData.getTestData("email"),ValidloginTestData.getTestData("password"));

    }

    @Story("Login with valid data")
    @Test
    public void loginInvalid() throws InterruptedException {

        loginScreen = new LoginScreen(driver);
        loginScreen.loginUsingInValidEmailAndPassword(InvalidloginTestData.getTestData("email"),InvalidloginTestData.getTestData("password"));

    }

    @AfterMethod
    public void quitAndroidDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}


