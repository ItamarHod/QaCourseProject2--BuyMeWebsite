import Base.MyActions;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainTest extends MyActions {

    @BeforeClass
    public static void beforeClass() {
        makeHtmlReporter();
    }

    @Test
    public void enterNdRegister() {
        openSite();
        home.toRegisterFromHome();
        registration.loadElements();
        registration.register();
        test.log(Status.PASS, "intro and registration test passed");
    }

    @Test
    public void homeScreen() {
        home.returnHome();
        home.loadElements();
        String priceChoiceXpath = "//*[@id=\"ember780_chosen\"]/div/ul/li[5]";
        String regionChoiceXpath = "//*[@id=\"ember795_chosen\"]/div/ul/li[4]";
        String categoryChoiceXpath = "//*[@id=\"ember805_chosen\"]/div/ul/li[3]";
        home.searchGift(priceChoiceXpath, regionChoiceXpath, categoryChoiceXpath);
        Assert.assertEquals(driver.getCurrentUrl(), constatnt.searchResultsUrl);
        test.log(Status.PASS, "search via searchbar test passed");
    }

    @Test
    public void pickBusiness() {
        driver.get(constatnt.searchResultsUrl);
        try {
            pickBuisness.loadPort24();
            clickElement(pickBuisness.port24);
        }catch(Exception e){
            test.log(Status.FAIL, "didnt pick a business");
        }finally{
            driver.get("https://buyme.co.il/supplier/379005");
        }
        pickBuisness.loadPriceInput();
        sendToElement(pickBuisness.priceInput, constatnt.priceInput);
        pickBuisness.submit.click();
        test.log(Status.PASS, "pick business and choose price test passed");
    }

    @Test
    public static void senderReceiverPage(){
        senderReceiver.loadElements();
        clickElement(senderReceiver.toSomeone);
        sendToElement(senderReceiver.receiverName, "roy");
        sendToElement(senderReceiver.senderName, "john");
        senderReceiver.chooseFromDropDownByXpath(senderReceiver.pickEvent, "//*[@id=\"ember1316_chosen\"]/div/ul/li[6]");
        senderReceiver.blessing.clear();
        sendToElement(senderReceiver.blessing, "happy wife happy life");
        uploadPicture(senderReceiver.picUploead, "C:\\Users\\itamar\\QA_course\\automation\\IdeaProjects\\automationHW\\QaCourse-Project2Check\\src\\main\\resources\\happy_wedding.jfif.crdownload");
        clickElement(senderReceiver.afterPayment);
        clickElement(senderReceiver.emailBut);
        senderReceiver.loadSending();
        sendToElement(senderReceiver.emailField, constatnt.email);
        clickElement(senderReceiver.saveBut);

    }
    @AfterClass
    public static void afterClass(){
        extent.flush();
    }
}
