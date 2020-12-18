package Pages;

import org.openqa.selenium.WebElement;

public class PageRegistration extends Pages{

    public static  WebElement firstName;
    public static WebElement email;
    public static  WebElement password;
    public static WebElement passwordConfirm;
    public static WebElement submit;

    //set elements when they can be found

    public void loadElements(){                                                     //works
        this.firstName = makeElement(firstName,"id","ember1237");
        this.email = makeElement(email,"id","ember1239");
        this.password = makeElement(password,"xpath","/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[3]/label/input");
        this.passwordConfirm = makeElement(passwordConfirm,"xpath","/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[4]/label/input");
        this.submit = makeElement(submit,"xpath","//*[@id=\"ember1235\"]/button");
    }

    //register - inputs data to fields, and submits
    public void register(){                                         //works
        myActions.sendToElement(firstName,constants.firstName);
        myActions.sendToElement(email, constants.email);
        myActions.sendToElement(password, constants.password);
        myActions.sendToElement(passwordConfirm, constants.password);
        myActions.clickElement(submit);
    }
}
