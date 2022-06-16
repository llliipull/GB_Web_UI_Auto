package HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWorkFiveTest {

    WebDriver driver;
    WebDriverWait driverWait;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Метод из дз 3, проверяет переход на страницу загрузки Idea Community
    @Test
    void downloadIdeaTest() {
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("IntelliJ IDEA\n");
        driver.findElement(By.xpath(
                "//h3[contains(text(), 'IntelliJ IDEA: функциональная и эргономичная IDE')]")).click();
        driver.findElement(By.xpath("//a[@href='/ru-ru/idea/download/' and @type='button']")).click();
        driver.findElement(By.xpath(
                "//a[@href='/ru-ru/idea/download/download-thanks.html?platform=windows&code=IIC']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='по ссылке']")).isDisplayed());
    }

    //метод из дз 3, проверяет что юзер залогинился на stackoverflow
    @Test
    void stackoverflowLoginTest() {
        driver.get("https://ru.stackoverflow.com/");
        driver.findElement(By.xpath("//button[contains(text(),'Принять все файлы cookie')]")).click();
        driver.findElement(By.xpath("//a[text()='Войти']")).click();
        driver.findElement(By.id("email")).sendKeys("darihal170@iconzap.com");
        driver.findElement(By.id("password")).sendKeys("Qwerty1!");
        driver.findElement(By.xpath("//button[@name='submit-button']")).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@data-gps-track='profile_summary.click()']")));
        Assertions.assertTrue(
                driver.findElement(By.xpath("//a[@data-gps-track='profile_summary.click()']")).isDisplayed());
    }

    @AfterEach
    void afterEach(){
        driver.quit();
    }
}
