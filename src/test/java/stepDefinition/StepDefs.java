package stepDefinition;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.WishListPage;
import utils.DriverFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StepDefs {

    HomePage homePage;
    WishListPage wishListPage;
    CartPage cartPage;

    @Given("I navigate to {string}")
    public void navigate_to_url(String url)
    {
        BasePage.driverInitialize();
        BasePage.navigateToUrl(url);
    }

    @Given("I add four products to my wish list")
    public void add_four_products_to_wish_list()
    {
        homePage = new HomePage(DriverFactory.driver);
        homePage.addProductsToWishlist();
    }
    @When("I view my wishlist table")
    public void view_wishlist_table() {
        homePage.clickWishList();
    }
    @Then("I find total four selected items in my Wishlist")
    public void i_find_total_four_selected_items_in_my_wishlist() throws InterruptedException {
        wishListPage = new WishListPage(DriverFactory.driver);
        HashMap<String, Boolean> products = wishListPage.verifyAllItemsInWishList();
        boolean status = true;

        Iterator it = products.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue().equals(false)){
                status = false;
                break;
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        Assert.assertEquals(true,status);

    }
    @When("I search for lowest price product")
    public void search_for_lowest_price_product()
    {
        System.out.println(wishListPage.fetchLowestPriceProduct());

    }
    @When("I am able to add the lowest price item to my cart")
    public void to_add_the_lowest_price_item_to_cart() {
        wishListPage.addMinPriceProductToTheCart();

    }
    @Then("I am able to verify the item in my cart")
    public void to_verify_the_item_in_cart() {
        cartPage = new CartPage(DriverFactory.driver);
        String actualProduct = cartPage.verifyProductInTheCart();
        Assert.assertEquals("1",actualProduct);
    }
}
