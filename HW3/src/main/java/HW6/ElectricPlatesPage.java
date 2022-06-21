package HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ElectricPlatesPage extends BasePage {

    public ElectricPlatesPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[1][@class='product-buy__price product-buy__price_active']")
    private WebElement firstProductItem;


    //в процессе увидел необходимость добавления активного элемента, так как DOM меняется при наведении на элемент
    @FindBy(xpath = "//div[@class='product-buy product-buy_one-line catalog-product__buy'][1]" +
            "//button[@class='button-ui buy-btn button-ui_brand']")
    private WebElement firstBuyButtonActive;

    @Step("Кликнуть по кнопке 'купить' для первого товара")
    public AddToCartPopup clickFirstBuyButton(){
        driverWait.until(ExpectedConditions.visibilityOf(firstProductItem));
        actions.moveToElement(firstProductItem).build().perform();
        driverWait.until(ExpectedConditions.visibilityOf(firstBuyButtonActive));
        actions.moveToElement(firstBuyButtonActive).click().build().perform();
        return new AddToCartPopup(driver);
    }
}
