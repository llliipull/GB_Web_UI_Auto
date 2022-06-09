package HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        //Скачать IntelliJ IDEA Community для windows, используя поиск google
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("IntelliJ IDEA\n");
        driver.findElement(By.xpath("//h3[contains(text(), 'IntelliJ IDEA: функциональная и эргономичная IDE')]")).click();
        driver.findElement(By.xpath("//a[@href='/ru-ru/idea/download/' and @type='button']")).click();
        driver.findElement(By.xpath("//a[@href='/ru-ru/idea/download/download-thanks.html?platform=windows&code=IIC']")).click();
        Thread.sleep(3000);

        //Залогиниться на Stackoverflow (креды тестовые, не затрагивают никакую личную информацию)
        driver.get("https://ru.stackoverflow.com/");
        driver.findElement(By.xpath("//button[contains(text(),'Принять все файлы cookie')]")).click();
        driver.findElement(By.xpath("//a[text()='Войти']")).click();
        driver.findElement(By.id("email")).sendKeys("darihal170@iconzap.com");
        driver.findElement(By.id("password")).sendKeys("Qwerty1!");
        driver.findElement(By.xpath("//button[@name='submit-button']")).click();
        Thread.sleep(3000);
        driver.quit();


    }
}
