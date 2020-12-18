package Pages;

import org.openqa.selenium.WebElement;

public class PageLogin extends Pages {

    public WebElement toRegister;
    public WebElement loginWithFacebook;
    public WebElement email;
    public WebElement password;
    public WebElement submit;

    //set elements when they can be found

    public void loadElements(){
        this.toRegister = makeElement(toRegister,"xpath","//span[@class=\"text-btn\"]");
        this.loginWithFacebook =makeElement(loginWithFacebook,"xpath","//div[@class=\"social-btn facebook\"]");
        this.email = makeElement(email,"xpath","//input[@id=\"ember1223\"]");
        this.password = makeElement(password,"xpath","//input[@id=\"ember1225\"]");
        this.submit = makeElement(submit,"xpath","//*[@id=\"ember1215\"]/button");
    }
}
