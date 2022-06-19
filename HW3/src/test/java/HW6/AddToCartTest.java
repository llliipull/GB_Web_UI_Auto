package HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.dns-shop.ru/");
    }

    @Test
    void addFirstGoodToCart() throws InterruptedException {
        new MainPage(driver).openPlatesPage()
                .openElectricPlatesPage()
                .clickFirstBuyButton()
                .checkTotalPrice();
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }
}
