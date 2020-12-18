package Pages;

import org.openqa.selenium.WebElement;

public class PageSenderReceiver extends Pages {
    public static WebElement toSomeone;
    public static WebElement receiverName;
    public static WebElement senderName;
    public static WebElement pickEvent;
    public static WebElement blessing;
    public static WebElement picUploead;
    public static WebElement afterPayment;
    public static WebElement emailBut;
    public static WebElement emailField;
    public static WebElement saveBut;

    public static void loadElements() {
        toSomeone = makeElement(toSomeone, "css","[data='forSomeone']");
        receiverName = makeElement(receiverName,"css", ".ui-grid .ui-input:nth-of-type(1) .ember-text-field" );
        senderName = makeElement(senderName, "css", ".ui-grid .ui-input:nth-of-type(2) .ember-text-field");
        pickEvent = makeElement(pickEvent, "css", ".ui-grid [tabindex]");
        blessing = makeElement(blessing, "css", ".ember-view.ui-field.ui-textarea > textarea[required]" );
        picUploead = makeElement(picUploead, "css", ".media-fields .ember-text-field");
        afterPayment = makeElement(afterPayment , "css", ".send-now");
        emailBut = makeElement(emailBut, "css", "[data-ember-action='1217']");

    }
    public static void loadSending(){
        emailField = makeElement(emailField, "css", ".form-control.input-theme");
        saveBut = makeElement(saveBut, "css", ".btn.btn-save.btn-theme");
    }
}
