import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobject.ScooterOrderForm;

public class TestScooterOrderForm {
    private WebDriver driver;
    private ScooterOrderForm objScooterOrderForm;

    @Before
    public void openPage() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        objScooterOrderForm = new ScooterOrderForm(driver);
        objScooterOrderForm.open();
        objScooterOrderForm.waitForLoadPage();
        objScooterOrderForm.clickCookieButton();
    }

    @Test
    public void enterOrderInMiddle() {
        // проверка наличия кнопки "Заказать" в хедере
        objScooterOrderForm.isHeaderOrderButtonPresent();
        //найти кнопку "Заказать" в блоке "Как это работает"
        WebElement element = driver.findElement(ScooterOrderForm.getMiddleOrderButton());
        //скролл до кнопки
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        // проверка наличия кнопки "Заказать" в блоке "Как это работает"
        objScooterOrderForm.isOrderButtonMiddlePresent();
        // клик на "Заказать" в блоке "Как это работает"
        objScooterOrderForm.clickMiddleOrderButton();
        // ввод значения в Поле "Имя"
        objScooterOrderForm.inputName("Михаил");
        // ввод значения в Поле "Фамилия"
        objScooterOrderForm.inputSurname("Колюшин");
        // ввод значения в Поле "Адрес: куда привезти заказ"
        objScooterOrderForm.inputAddress("Советская, 123");
        // ввод значения в Поле "Станция метро"
        objScooterOrderForm.inputMetro();
        // ввод значения в Поле "Телефон: на него позвонит курьер"
        objScooterOrderForm.inputPhone("12345678901");
        // клик на кнопку "Далее"
        objScooterOrderForm.clickOrderNextButton();
        // ввод значения в Поле "Когда привезти самокат"
        objScooterOrderForm.inputWhen();
        // ввод значения в Поле "Срок аренды"
        objScooterOrderForm.inputTerm();
        // ввод значения в Поле "Цвет самоката"
        objScooterOrderForm.inputColor();
        // ввод значения в Поле "Комментарий для курьера"
        objScooterOrderForm.inputComment("Позвоните, как подъедете");
        // клик на кнопку "Заказать" для завершения
        objScooterOrderForm.clickOrderButtonFinal();
        // клик на кнопку "Да" в окне подтверждения оформления заказа
        objScooterOrderForm.clickConfirmButton();
        // проверка появления окна "Заказ оформлен"
        objScooterOrderForm.isProcessedWindowPresent();
    }

    @Test
    public void enterOrderInHeader() {
        // проверка наличия кнопки "Заказать" в хедере
        objScooterOrderForm.isHeaderOrderButtonPresent();
        // клик на "Заказать" в хедере
        objScooterOrderForm.clickHeaderOrderButton();
        // ввод значения в Поле "Имя"
        objScooterOrderForm.inputNameWithSpaceCaps("МИ ША");
        // ввод значения в Поле "Фамилия"
        objScooterOrderForm.inputSurnameCaps("КОЛЮШИН");
        // ввод значения в Поле "Адрес: куда привезти заказ"
        objScooterOrderForm.inputAddressMinus("Советская-123");
        // ввод значения в Поле "Станция метро"
        objScooterOrderForm.inputMetro2();
        // ввод значения в Поле "Телефон: на него позвонит курьер"
        objScooterOrderForm.inputPhonePlus("+12345678901");
        // клик на кнопку "Далее"
        objScooterOrderForm.clickOrderNextButton();
        // ввод значения в Поле "Когда привезти самокат"
        objScooterOrderForm.inputWhenToday();
        // ввод значения в Поле "Срок аренды"
        objScooterOrderForm.inputTermTwo();
        // ввод значения в Поле "Цвет самоката"
        objScooterOrderForm.inputColorGrey();
        // клик на кнопку "Заказать" для завершения
        objScooterOrderForm.clickOrderButtonFinal();
        // клик на кнопку "Да" в окне подтверждения оформления заказа
        objScooterOrderForm.clickConfirmButton();
        // проверка появления окна "Заказ оформлен"
        objScooterOrderForm.isProcessedWindowPresent();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
