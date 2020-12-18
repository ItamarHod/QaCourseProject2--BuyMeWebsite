import Base.MyActions;

public class Check extends MyActions {
    public static void main(String[] args) {
        openSite();
        driver.get("https://buyme.co.il/money/398383");
        pickBuisness.loadPriceInput();
        sendToElement(pickBuisness.priceInput, constatnt.priceInput);
        clickElement(pickBuisness.submit);
        senderReceiver.loadElements();
        senderReceiver.loadElements();
        clickElement(senderReceiver.toSomeone);
        sendToElement(senderReceiver.receiverName, "roy");
        sendToElement(senderReceiver.senderName, "john");
        senderReceiver.chooseFromDropDownByXpath(senderReceiver.pickEvent, "//*[@id=\"ember1279_chosen\"]/div/ul/li[6]");
        senderReceiver.blessing.clear();
        sendToElement(senderReceiver.blessing, "happy wife happy life");
        uploadPicture(senderReceiver.picUploead, "C:\\Users\\itamar\\QA_course\\automation\\IdeaProjects\\automationHW\\QaCourse-Project2Check\\src\\main\\resources\\happy_wedding.jfif.crdownload");
        clickElement(senderReceiver.afterPayment);
        clickElement(senderReceiver.emailBut);
        senderReceiver.loadSending();
        sendToElement(senderReceiver.emailField, constatnt.email);
        clickElement(senderReceiver.saveBut);
    }
}
