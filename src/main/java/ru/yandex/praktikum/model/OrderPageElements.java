package ru.yandex.praktikum.model;

import org.openqa.selenium.By;

public class OrderPageElements {
    private final By nameInputField = By.cssSelector(".//input[@placeholder='* Имя']"); //Поле "Имя"

    private final By surnameInputField = By.cssSelector(".//input[@placeholder='* Фамилия']");//Поле "Фамилия"

    private final By addressInputField = By.cssSelector(".//input[@placeholder='* Адрес: куда привезти заказ']");//Поле "Адрес: куда привезти заказ"

    private final By metroInputField = By.cssSelector(".//input[@placeholder='* Станция метро']");//Поле "Станция метро"

    private final By phoneInputField = By.cssSelector(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //Поле "Телефон: на него позвонит курьер"

    private final By orderNextButton = By.cssSelector("div.Order_NextButton__1_rCA > button.Button_Middle__1CSJM");//Кнопка "Далее"

    private final By whenInputField = By.cssSelector(".//input[@placeholder='* Когда привезти самокат']");//Поле "Когда привезти самокат"

    private final By termInputField = By.cssSelector(".Dropdown-placeholder");//Поле "Срок аренды"

    private final By termInputOption = By.xpath(".//div[2]/div[2]/div[2]/div[2]/div[1]");//Сутки в Поле "Срок аренды"

    private final By colorInputField = By.cssSelector(".Order_Title__3EKne"); //Поле "Цвет самоката"

    private final By colorInputOption = By.id("black");  //Черный в Поле "Цвет самоката"

    private final By commentInputField = By.cssSelector(".//input[@placeholder='Комментарий для курьера']");//Поле "Комментарий для курьера"

    private final By orderButtonFinal = By.xpath(".//div[2]/div[3]/button[2]");//Кнопка "Заказать" для завершения

    private final By confirmButton = By.xpath(".//div[2]/div[5]/div[2]/button[2]"); //Кнопка "Да" в окне подтверждения оформления заказа

    private final By processedWindow = By.cssSelector(".Order_ModalHeader__3FDaJ");//Окно "Заказ оформлен"

    private final By checkStatusButton = By.xpath(".//div[2]/div[5]/div[2]/button");  //Кнопка "Посмотреть статус"
}
