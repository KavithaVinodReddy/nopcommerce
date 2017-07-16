package com.testing.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private String URL="http://demo.nopcommerce.com/";
    private WebDriver driver;

    @FindBy(how= How.ID, using="small-searchterms")
    public WebElement txtSearchBox;

    @FindBy(how=How.XPATH, using="//div[@class='search-results']/div/div/div")
    List<WebElement> searchResults;

    @FindBy(how=How.XPATH, using="//div[@class='search-results']/div")
    WebElement noResults;

    @FindBy(how= How.ID, using="adv")
    public WebElement advanceSearchChk;

    @FindBy(how= How.XPATH, using="//div[@class='header-links']/ul/li[4]/a/span[2]")
    public WebElement cart;


    @FindBy(how= How.XPATH, using="//form[@id='small-search-box-form']/input[2]")
    WebElement searchButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void open(){
        driver.get(URL);
    }

    public void setTextForSearchField(String text){
        txtSearchBox.sendKeys(text);
    }

    public void search(){
        searchButton.click();
    }

    public int searchResultCount(){
        return searchResults.size();
    }

    public String getAlertText(){
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public String getNoResultsDivText(){
        return  noResults.getText();
    }

    public void selectAnItem(){
        searchResults.get(1).click();
    }

    public int getCartItemCount(){
        String count = cart.getText().substring(1,2);
        System.out.println(count);
        return Integer.parseInt(count);
    }
}
