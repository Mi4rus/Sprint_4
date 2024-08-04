package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ScooterOrderForm {
    private final WebDriver driver;


    public ScooterOrderForm(WebDriver driver) {
        this.driver = driver;
    }

    //
    private static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";//Адрес сайта
    //
    private final static By COOKIE_BUTTON = By.id("rcc-confirm-button");//Кнопка "да все привыкли" в окне про куки
    //
    private final static By HEADER_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g']");//Кнопка "Заказать" в хедере
    //
    private final static By MIDDLE_ORDER_BUTTON = By.cssSelector("div.Home_FinishButton__1_cWm > button.Button_Middle__1CSJM");//Кнопка "Заказать" в блоке "Как это работает"

    //
    private final static By NAME_INPUT_FIELD = By.xpath(".//input[@placeholder='* Имя']");//Поле "Имя"
    //
    private final static By SURNAME_INPUT_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");//Поле "Фамилия"
    //
    private final static By ADDRESS_INPUT_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");//Поле "Адрес: куда привезти заказ"
    //
    private final static By METRO_INPUT_FIELD = By.xpath(".//input[@placeholder='* Станция метро']");//Поле "Станция метро"
    //
    private final static By PHONE_INPUT_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");//Поле "Телефон: на него позвонит курьер"

    //
    private final static By ORDER_NEXT_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");//Кнопка "Далее"

    //
    private final static By WHEN_INPUT_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");//Поле "Когда привезти самокат"
    //
    private final static By TERM_INPUT_FIELD = By.xpath(".//div[@class='Dropdown-placeholder' and text()= '* Срок аренды']");//Поле "Срок аренды"
    //
    private final static By TERM_INPUT_OPTION1 = By.xpath(".//div[@class='Dropdown-option' and text()= 'сутки']");//Сутки в Поле "Срок аренды"
    //
    private final static By TERM_INPUT_OPTION2 = By.xpath(".//div[@class='Dropdown-option' and text()= 'двое суток']");//Двое суток в поле "Срок аренды"

    private final static By TERM_INPUT_OPTION3 = By.xpath(".//div[@class='Dropdown-option' and text()= 'трое суток']");//Трое суток в Поле "Срок аренды"
    //
    private final static By TERM_INPUT_OPTION4 = By.xpath(".//div[@class='Dropdown-option' and text()= 'четверо суток']");//Четверо суток в Поле "Срок аренды"

    private final static By TERM_INPUT_OPTION5 = By.xpath(".//div[@class='Dropdown-option' and text()= 'пятеро суток']");//Пять суток в Поле "Срок аренды"

    private final static By TERM_INPUT_OPTION6 = By.xpath(".//div[@class='Dropdown-option' and text()= 'шестеро суток']");//Шесть суток в Поле "Срок аренды"

    private final static By TERM_INPUT_OPTION7 = By.xpath(".//div[@class='Dropdown-option' and text()= 'семеро суток']");//Семь суток в Поле "Срок аренды"

    private final static By COLOR_INPUT_OPTION_GREY = By.id("grey");//Серый в Поле "Цвет самоката"
    //
    private final static By COLOR_INPUT_OPTION_BLACK = By.id("black");//Черный в Поле "Цвет самоката"
    //
    private final static By COMMENT_INPUT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");//Поле "Комментарий для курьера"

    //
    private final static By ORDER_BUTTON_FINAL = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");//Кнопка "Заказать" для завершения
    //
    private final static By CONFIRM_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");//Кнопка "Да" в окне подтверждения оформления заказа

    //
    private final static By PROCESSED_WINDOW = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");//Окно "Заказ оформлен"


    public static By getMiddleOrderButton() {
        return MIDDLE_ORDER_BUTTON;
    }

    // Метод открытия сайта
    public ScooterOrderForm open() {
        driver.get(SCOOTER_URL);
        return this;
    }

    // Метод клика на подтверждение кук
    public ScooterOrderForm clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
        return this;
    }

    // Метод ожидания загрузки страницы
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(HEADER_ORDER_BUTTON));
    }

    // Метод проверки наличия кнопки "Заказать" в хедере
    public boolean isHeaderOrderButtonPresent() {
        return driver.findElement(HEADER_ORDER_BUTTON).isDisplayed();
    }

    // Метод клика на "Заказать" в хедере
    public ScooterOrderForm clickHeaderOrderButton() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
        return this;
    }

    // Метод проверки наличия кнопки "Заказать" в блоке "Как это работает"
    public boolean isOrderButtonMiddlePresent() {
        return driver.findElement(MIDDLE_ORDER_BUTTON).isEnabled();
    }

    // Метод клика на "Заказать" в блоке "Как это работает"
    public ScooterOrderForm clickMiddleOrderButton() {
        driver.findElement(MIDDLE_ORDER_BUTTON).click();
        return this;
    }

    // Метод ввода значения в поле "Имя"
    public ScooterOrderForm inputName(String name) {
        driver.findElement(NAME_INPUT_FIELD).click();
        driver.findElement(NAME_INPUT_FIELD).sendKeys(name);
        return this;
    }

    // Метод ввода значения в поле "Имя"
    public ScooterOrderForm inputNameWithSpaceCaps(String name) {
        driver.findElement(NAME_INPUT_FIELD).click();
        driver.findElement(NAME_INPUT_FIELD).sendKeys(name);
        return this;
    }

    // Метод ввода значения в поле "Фамилия"
    public ScooterOrderForm inputSurname(String surname) {
        driver.findElement(SURNAME_INPUT_FIELD).click();
        driver.findElement(SURNAME_INPUT_FIELD).sendKeys(surname);
        return this;
    }

    // Метод ввода значения в поле "Фамилия"
    public ScooterOrderForm inputSurnameCaps(String surname) {
        driver.findElement(SURNAME_INPUT_FIELD).click();
        driver.findElement(SURNAME_INPUT_FIELD).sendKeys(surname);
        return this;
    }

    // Метод ввода значения в поле "Адрес: куда привезти заказ"
    public ScooterOrderForm inputAddress(String address) {
        driver.findElement(ADDRESS_INPUT_FIELD).click();
        driver.findElement(ADDRESS_INPUT_FIELD).sendKeys(address);
        return this;
    }

    // Метод ввода значения в поле "Адрес: куда привезти заказ"
    public ScooterOrderForm inputAddressMinus(String address) {
        driver.findElement(ADDRESS_INPUT_FIELD).click();
        driver.findElement(ADDRESS_INPUT_FIELD).sendKeys(address);
        return this;
    }

    // Метод ввода значения в поле "Станция метро"
    public ScooterOrderForm inputMetro() {
        driver.findElement(METRO_INPUT_FIELD).click();
        driver.findElement(METRO_INPUT_FIELD).sendKeys(Keys.DOWN);
        driver.findElement(METRO_INPUT_FIELD).sendKeys(Keys.ENTER);
        return this;
    }

    // Метод ввода значения в Поле "Станция метро"
    public ScooterOrderForm inputMetro2() {
        driver.findElement(METRO_INPUT_FIELD).click();
        driver.findElement(METRO_INPUT_FIELD).sendKeys(Keys.DOWN);
        driver.findElement(METRO_INPUT_FIELD).sendKeys(Keys.DOWN);
        driver.findElement(METRO_INPUT_FIELD).sendKeys(Keys.ENTER);
        return this;
    }

    // Метод ввода значения в поле "Телефон: на него позвонит курьер"
    public ScooterOrderForm inputPhone(String phoneNumber) {
        driver.findElement(PHONE_INPUT_FIELD).click();
        driver.findElement(PHONE_INPUT_FIELD).sendKeys(phoneNumber);
        return this;
    }

    // Метод ввода значения в поле "Телефон: на него позвонит курьер"
    public ScooterOrderForm inputPhonePlus(String phoneNumber) {
        driver.findElement(PHONE_INPUT_FIELD).click();
        driver.findElement(PHONE_INPUT_FIELD).sendKeys(phoneNumber);
        return this;
    }

    // Метод клика на кнопку "Далее"
    public ScooterOrderForm clickOrderNextButton() {
        driver.findElement(ORDER_NEXT_BUTTON).click();
        return this;
    }

    // Метод ввода значения в поле "Когда привезти самокат"
    public ScooterOrderForm inputWhen() {
        driver.findElement(WHEN_INPUT_FIELD).click();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(2).format(formatter);
        driver.findElement(WHEN_INPUT_FIELD).sendKeys(date);
        driver.findElement(WHEN_INPUT_FIELD).sendKeys(Keys.ENTER);
        return this;
    }

    // Метод ввода значения в поле "Когда привезти самокат"
    public ScooterOrderForm inputWhenToday() {
        driver.findElement(WHEN_INPUT_FIELD).click();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(0).format(formatter);
        driver.findElement(WHEN_INPUT_FIELD).sendKeys(date);
        driver.findElement(WHEN_INPUT_FIELD).sendKeys(Keys.ENTER);
        return this;
    }

    // Метод ввода значения в поле "Срок аренды"
    public ScooterOrderForm inputTerm() {
        driver.findElement(TERM_INPUT_FIELD).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(TERM_INPUT_OPTION1));
        driver.findElement(TERM_INPUT_OPTION1).click();
        return this;
    }

    // Метод ввода значения в поле "Срок аренды"
    public ScooterOrderForm inputTermTwo() {
        driver.findElement(TERM_INPUT_FIELD).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(TERM_INPUT_OPTION2));
        driver.findElement(TERM_INPUT_OPTION2).click();
        return this;
    }

    // Метод ввода значения в поле "Цвет самоката"
    public ScooterOrderForm inputColor() {
        driver.findElement(COLOR_INPUT_OPTION_BLACK).click();
        return this;
    }

    // Метод ввода значения в поле "Цвет самоката"
    public ScooterOrderForm inputColorGrey() {
        driver.findElement(COLOR_INPUT_OPTION_GREY).click();
        return this;
    }

    // Метод ввода значения в поле "Комментарий для курьера"
    public ScooterOrderForm inputComment(String comment) {
        driver.findElement(COMMENT_INPUT_FIELD).click();
        driver.findElement(COMMENT_INPUT_FIELD).sendKeys(comment);
        return this;
    }

    // Метод клика на кнопку "Заказать" для завершения
    public ScooterOrderForm clickOrderButtonFinal() {
        driver.findElement(ORDER_BUTTON_FINAL).click();
        return this;
    }

    // Метод нажатия кнопки "Да" в окне подтверждения оформления заказа
    public ScooterOrderForm clickConfirmButton() {
        driver.findElement(CONFIRM_BUTTON).click();
        return this;
    }

    // Метод проверки окна "Заказ оформлен"
    public boolean isProcessedWindowPresent() {
        return driver.findElement(PROCESSED_WINDOW).isDisplayed();
    }
}