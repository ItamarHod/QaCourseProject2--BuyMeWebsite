package Base;

import Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;


public class MyActions {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static CONSTANTS constatnt = new CONSTANTS();


    public static PageHome home = new PageHome();
    public static PageLogin login = new PageLogin();
    public static PageRegistration registration = new PageRegistration();
    public static PagePickBuisness pickBuisness = new PagePickBuisness();
    public static PageSenderReceiver senderReceiver = new PageSenderReceiver();

    //html reporter parameters
    public static ExtentReports extent;
    public static ExtentTest test;
    /*
    pages navigation
     */

    //opens browser window, go to buyme homepage
    public static void openSite() {
        driver = Singleton.driverSingleton(driver);
        wait = Singleton.waitSingleton(wait, driver);
        driver.get("https://buyme.co.il/");
    }


    /*
    UI
     */

    //click given web element
    public static void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //send given input to given element
    public static void sendToElement(WebElement element, String input){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(input);
    }
    public static void uploadPicture(WebElement element, String picturePath){
        try {
            element.sendKeys("<" + picturePath + ">");
        }catch(Exception e){
            System.out.println("picture wasn't uploaded");
        }
    }

    /*
    test report
     */
    //initiate html test reporter

    public static void makeHtmlReporter(){
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(constatnt.extentReportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("BuyMe Site", "Sanity test");
        test.log(Status.INFO, "test log initiated");
    }
    //take screenshot
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".jpg");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".jpg";
    }

    /*
    driver getter
     */
    public static WebDriver getDriver() {
        return driver;
    }
    public static String getData (String keyName) throws Exception{
        File fXmlFile = new File("C:\\Users\\itamar\\QA_course\\automation\\IdeaProjects\\automationHW\\QaCourse-Project2Check\\src\\main\\resources\\data.xml/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
