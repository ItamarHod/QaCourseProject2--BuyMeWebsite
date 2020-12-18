package Pages;

import org.openqa.selenium.WebElement;

public class PageHome extends Pages {

    public static WebElement loginRegisterBut;
    public static WebElement price;
    public static WebElement region;
    public static WebElement category;
    public static WebElement findPresent;

    //set elements when they can be found
    public void loadElements() {
        this.loginRegisterBut = makeElement(loginRegisterBut, "xpath", "//*[@id=\"ember718\"]/div/ul[1]/li[3]/a");
        this.price = makeElement(price, "xpath", "//*[@id=\"ember780_chosen\"]/a");
        this.region = makeElement(region, "xpath", "//*[@id=\"ember795_chosen\"]/a");
        this.category = makeElement(category, "xpath", "//*[@id=\"ember805_chosen\"]/a");
        this.findPresent = makeElement(findPresent, "id", "ember840");
    }

    //goes to login page
    public static void toLoginFromHome() {
        PageHome homeElements = new PageHome();
        homeElements.loadElements();
        myActions.clickElement(homeElements.loginRegisterBut);
    }

    //goes to register page
    public static void toRegisterFromHome() {
        toLoginFromHome();
        PageLogin login = new PageLogin();
        login.loadElements();
        myActions.clickElement(login.toRegister);
    }

    //search in searchbar by price, region, category xpath (adjusted to website specific dropdowns)
    public static void searchGift(String priceXpath, String regionXpath, String categoryXpath) {
        chooseFromDropDownByXpath(price, priceXpath);
        chooseFromDropDownByXpath(region, regionXpath);
        chooseFromDropDownByXpath(category, categoryXpath);
        myActions.clickElement(findPresent);
    }

    //goes to home page
    public static void returnHome() {
        myActions.getDriver().get(constants.homePageUrl);
    }
}