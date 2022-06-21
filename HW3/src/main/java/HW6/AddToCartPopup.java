package HW6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPopup extends BasePage{

    public AddToCartPopup(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[1][@class='product-buy__prev']/parent::div")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[1][@class='product-buy__price product-buy__price_active']")
    private WebElement productPrice;

    @Step("Проверить соответствие цены товара итоговой сумме")
    public void checkTotalPrice(){
        Assertions.assertEquals(productPrice.getText(), totalPrice.getText());
    }
}
