package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WishListPage {

    WebDriver driver;
    List<String> list = new ArrayList<String>();
    String minimumPrice;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(1)")
    public WebElement blackTrousers;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(2)")
    public WebElement hardTop;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(3)")
    public WebElement singleShirt;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(4)")
    public WebElement bikini;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(1) td:nth-child(4) span:first-child bdi")
    public WebElement priceBlackTrousers;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(2) td:nth-child(4) span:first-child bdi")
    public WebElement priceHardTop;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(3) td:nth-child(4) span:first-child bdi")
    public WebElement priceSingleShirt;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(4) td:nth-child(4) span:first-child bdi")
    public WebElement pricebikini;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(1) td:nth-child(6) a")
    public WebElement blackTrousersAddToCart;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(2) td:nth-child(6) a")
    public WebElement hardTopAddToCart;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(3) td:nth-child(6) a")
    public WebElement singleShirtAddToCart;

    @FindBy(css = "tbody[class='wishlist-items-wrapper'] tr:nth-child(4) td:nth-child(6) a")
    public WebElement bikiniAddToCart;

    public WishListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public HashMap<String, Boolean> verifyAllItemsInWishList() throws InterruptedException {
        Thread.sleep(2000);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("product1", blackTrousers.isDisplayed());
        map.put("product2", hardTop.isDisplayed());
        map.put("product3", singleShirt.isDisplayed());
        map.put("product4", bikini.isDisplayed());

        return map;


    }

    public void addMinPriceProductToTheCart() {
        if(priceBlackTrousers.getText().equals(minimumPrice)){
            blackTrousersAddToCart.click();
        }else if (priceHardTop.getText().equals(minimumPrice)){
            hardTopAddToCart.click();
        }else if(priceSingleShirt.getText().equals(minimumPrice)){
            singleShirtAddToCart.click();
        }else if(pricebikini.getText().equals(minimumPrice)){
            bikiniAddToCart.click();
        }else{
            System.out.println(minimumPrice+" did not match");
        }
    }

    public String fetchLowestPriceProduct() {
        list.add(priceBlackTrousers.getText());
        list.add(priceHardTop.getText());
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)");
        list.add(priceSingleShirt.getText());
        list.add(pricebikini.getText());
        minimumPrice = Collections.min(list);
        return minimumPrice;
    }
}
