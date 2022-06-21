package HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Бытовая техника']")
    private WebElement appliances;

    @FindBy(xpath = "//a[text()='Приготовление пищи']")
    private WebElement cooking;

    @FindBy(xpath = "//a[text()='Плиты']")
    private WebElement plates;

    @Step("Открыть страницу 'плиты'")
    public PlatesPage openPlatesPage() {
        driverWait.until(ExpectedConditions.visibilityOf(appliances));
        actions.moveToElement(appliances).build().perform();
        driverWait.until(ExpectedConditions.visibilityOf(cooking));
        actions.moveToElement(cooking).build().perform();
        driverWait.until(ExpectedConditions.visibilityOf(plates));
        actions.moveToElement(plates).click().build().perform();

        return new PlatesPage(driver);

    }
}
