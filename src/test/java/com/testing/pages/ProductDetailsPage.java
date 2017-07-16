package com.testing.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    String URL = "http://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop";

    @FindBy(how= How.XPATH, using="//div[@class='gallery']/div/img")
    public WebElement imageEle;

    @FindBy(how= How.XPATH, using="//div[@class='product-name']/h1")
    public WebElement titleEle;

    @FindBy(how= How.XPATH, using="//div[@class='short-description']")
    public WebElement shortDescEle;

    @FindBy(how= How.XPATH, using="//div[@class='product-review-box']/div/div")
    public WebElement reviewEle;

    @FindBy(how= How.XPATH, using="//div[@class='product-review-links']")
    public WebElement reviewLinksEle;


    @FindBy(how= How.XPATH, using="//div[@class='add-to-cart-panel']/input[1]")
    public WebElement addToCartTxtEle;

    @FindBy(how= How.XPATH, using="//div[@class='add-to-cart-panel']/input[2]")
    public WebElement addToCartBtn;

    @FindBy(how= How.XPATH, using="//div[@class='availability']/div/span[2]")
    public WebElement availabiltyEle;

    @FindBy(how= How.XPATH, using="//div[@class='prices']/div/span")
    public WebElement pricesEle;



    public ProductDetailsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        return titleEle.getText();
    }

    public String getProductShortDescription(){
        return shortDescEle.getText();
    }

    public String getAvailability(){
        return availabiltyEle.getText();
    }
    public String getPrice(){
        return availabiltyEle.getText();
    }

    public void setQuantity(String qty){
        addToCartTxtEle.clear();
        addToCartTxtEle.sendKeys(qty);
    }
}
