package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Singleton {

    public static CONSTANTS constant = new CONSTANTS();

    //driver singleton
    public static WebDriver driverSingleton(WebDriver driver) {
        if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(constant.waitForPageLoad, TimeUnit.SECONDS);

        }
        return driver;
    }

    public static WebDriver xmlDriverSingleton(WebDriver driver) {
        if (driver == null) {
            try {
                String type = MyActions.getData("browserType");
                String driverPAth = MyActions.getData("driverPath");
                if (type =="Chrome")
                    System.setProperty("webdriver.chrome.driver", driverPAth);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(constant.waitForPageLoad, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    //wait object singleton
    public static WebDriverWait waitSingleton(WebDriverWait wait, WebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(driver, constant.waitObject);
        }
        return wait;
    }

}
