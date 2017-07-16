package com.testing.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {


    public SearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.XPATH, using="//div[@class='search-results']/div/div/div")
    List<WebElement> searchResults;

    @FindBy(how=How.XPATH, using="//div[@class='search-results']/div/div/div/div")
    WebElement productItem;

    public void getProductItem(){

    }
}
