package Pages;

import org.openqa.selenium.WebElement;

public class PagePickBuisness extends Pages{

   public static WebElement port24;
   public static WebElement priceInput;
   public static WebElement submit;

    //set elements when they can be found

   public void loadPort24(){
       this.port24 = makeElement(port24, "css", ".card-items .ember-view:nth-of-type(3) [data-lazyattr='style']");
   }

    public void loadPriceInput(){
        this.priceInput = makeElement(priceInput, "css", ".form-control.input-theme");
        this.submit = makeElement(priceInput, "css", ".ember-view.moneyForm .btn.btn-theme");
    }
}
