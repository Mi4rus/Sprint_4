import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.PageObject.ScooterMainPage;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class TestScooterMainPage {
    private ScooterMainPage objScooterMainPage;
    private WebDriver driver;

    @Before
    public void openPage() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        objScooterMainPage = new ScooterMainPage(driver);
        objScooterMainPage.open();
        objScooterMainPage.waitForLoadPage();
        objScooterMainPage.clickCookieButton();
        WebElement element = driver.findElement(By.cssSelector(".Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test
    public void checkFirstQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-0")); //Найти первый вопрос
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);// Проскроллить до первого вопроса
        objScooterMainPage.clickPriceQuestion();//Нажать на первый вопрос
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; //Ожидаемый ответ
        String actual = objScooterMainPage.priceText(); //Получить ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//Ожидание открытие ответа
        assertEquals(expected, actual);//Сравнение результатов
    }
    //Остальные методы и шаги внутри метода аналогичны методу checkFirstQuestionAndAnswer();
    @Test
    public void checkSecondQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.clickQuantityQuestion();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actual = objScooterMainPage.quantityText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertEquals(expected, actual);
    }

    @Test
    public void checkThirdQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.clickTimeQuestion();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";//ожидаемый ответ
        String actual = objScooterMainPage.timeText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertEquals(expected, actual);
    }

    @Test
    public void checkFourthQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.clickTodayQuestion();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = objScooterMainPage.todayText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertEquals(expected, actual);
    }

    @Test
    public void checkFifthQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.clickExtendReturnQuestion();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actual = objScooterMainPage.extendReturnText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//ожидание открытия ответа
        assertEquals(expected, actual);
    }

    @Test
    public void checkSixthQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-5"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.clickChargerQuestion();
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = objScooterMainPage.chargerText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertEquals(expected, actual);
    }

    @Test
    public void checkSeventhQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-6"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.clickCancellationQuestion();
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actual = objScooterMainPage.cancellationText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertEquals(expected, actual);
    }

    @Test
    public void checkEighthQuestionAndAnswer() {
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        objScooterMainPage.clickMkadQuestion();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = objScooterMainPage.mkadText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertEquals(expected, actual);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
