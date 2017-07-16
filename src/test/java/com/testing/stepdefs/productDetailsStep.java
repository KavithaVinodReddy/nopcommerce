package com.testing.stepdefs;


import com.testing.pages.HomePage;
import com.testing.pages.ProductDetailsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class productDetailsStep {

    private BaseStep baseStep;
    private HomePage homePage;
    private ProductDetailsPage product;

    public productDetailsStep(BaseStep bStep){
        baseStep = bStep;
        homePage = new HomePage(baseStep.getDriver());
        homePage.open();
        homePage.setTextForSearchField("htc");
        homePage.search();
    }

    @Given("^search results are displayed$")
    public void showSearchResults()  {
        assertTrue(homePage.searchResultCount() >0);
    }

    @When("^I click first item$")
    public void clickItemInResults()  {
        homePage.selectAnItem();
    }

    @Then("^product item should be displayed as per design$")
    public void verifyProductDescription()  {
        System.out.println(baseStep.getDriver().getCurrentUrl());
        ProductDetailsPage product = new ProductDetailsPage(baseStep.getDriver());
        String title = product.getProductName();
        assertEquals("HTC One Mini Blue", title);
        assertTrue(product.reviewEle.isDisplayed());
        assertTrue(product.pricesEle.isDisplayed());
        assertTrue(product.shortDescEle.isDisplayed());
        assertTrue(product.imageEle.isDisplayed());
        title = title.replaceAll("\\s", "-").toLowerCase();
        System.out.println(title);
        assertEquals("http://demo.nopcommerce.com/"+title , baseStep.getDriver().getCurrentUrl());

        // there are more design items to verify. I am only doing few
    }

    @Given("^I am on a product detail page$")
    public void i_am_on_a_product_detail_page()  {
        homePage.selectAnItem();
        product = new ProductDetailsPage(baseStep.getDriver());
        String title = product.getProductName();
        title = title.replaceAll("\\s", "-").toLowerCase();
        assertEquals("http://demo.nopcommerce.com/"+title , baseStep.getDriver().getCurrentUrl());
    }

    @When("^I click Add to Cart$")
    public void i_click_add_to_cart()  {
        assertEquals(0, homePage.getCartItemCount());
        product.addToCartBtn.click();
        sleep();
    }

    @When("^I click Add to Cart twice$")
    public void AddTwice()  {
        assertEquals(0, homePage.getCartItemCount());
        product.addToCartBtn.click();
        sleep();
        product.addToCartBtn.click();
        sleep();
    }

    private void sleep(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^shopping cart should be updated with \"([^\"]*)\"$")
    public void shopping_cart_should_be_updated_with_something(String strArg1) {
        assertEquals(Integer.parseInt(strArg1), homePage.getCartItemCount());
    }

    @When("^I give 2 number in the quantity field$")
    public void i_give_2_number_in_the_quantity_field()  {
        product.setQuantity("2");
    }


}
