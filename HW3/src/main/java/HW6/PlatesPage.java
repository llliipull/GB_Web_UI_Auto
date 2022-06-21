package HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlatesPage extends BasePage{

    public PlatesPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[@class='subcategory__title' and text()='Плиты электрические']")
    private WebElement electricPlates;

    @Step("Открыть страницу 'плиты электрические'")
    public ElectricPlatesPage openElectricPlatesPage(){
        driverWait.until(ExpectedConditions.visibilityOf(electricPlates));
        actions.moveToElement(electricPlates).click().build().perform();
        return new ElectricPlatesPage(driver);
    }

}
