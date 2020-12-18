package Pages;

import Base.MyActions;
import Base.CONSTANTS;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pages {

    public static MyActions myActions = new MyActions();
    public static CONSTANTS constants = new CONSTANTS();
    public static WebDriver driver = MyActions.getDriver();

    //web element factory
    public static WebElement makeElement(WebElement element, String locatorType, String locator) {
        driver = MyActions.getDriver();

        try {
            switch(locatorType.toLowerCase()){
                case "xpath" :
                    element = driver.findElement(By.xpath(locator));
                    break;
                case "tagName" :
                    element = driver.findElement(By.tagName(locator));
                    break;
                case "id" :
                    element = driver.findElement(By.id(locator));
                    break;
                case "className" :
                    element = driver.findElement(By.className(locator));
                    break;
                case "text" :
                    String path = "//*[contains(text(), \""+locator+"\")]";
                    element = driver.findElement(By.xpath(path));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(locator));
            }
        }
        //"element not found", MediaEntityBuilder.createScreenCaptureFromPath(myActions.takeScreenShot(CONSTANTS.extentReportPath))
        catch (Exception e) {
            e.printStackTrace();
                MyActions.test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(myActions.takeScreenShot(constants.extentReportPath)).build());

        }
        return element;
    }

    //choose from dropdown - adjusted to website's specific dropdowns
    public static void chooseFromDropDownByXpath(WebElement element, String xpath){
        element.click();
        WebElement option = element;
        option = makeElement(option , "xpath", xpath);
        myActions.clickElement(option);
    }
}
