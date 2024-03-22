package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Selenide.*;

public class PostponementOfTheDateOfIssueOfTheBankCard {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        var validUser = DataClients.Registration.generateUser("ru");
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataClients.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataClients.generateDate(daysToAddForSecondMeeting);
        $("[data-test-id=city] [placeholder='Город']").val(validUser.getCity());

        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);


        $("[data-test-id=name] [name='name']").val(validUser.getName());
        $("[data-test-id=phone] [name='phone']").val(validUser.getPhone());
        $("[data-test-id=agreement]").click();
        $$("[class=button__text]").find(exactText("Запланировать")).click();
        $$("[class=button__text]").find(exactText("Перепланировать")).click();
        $("[data-test-id=success-notification]").$("[class=notification__content]")
                  .shouldHave(textCaseSensitive("Встреча успешно запланирована на " + ));

        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
        // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
        // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
        // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
        // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе
    }
}
   // @Test
   // void postponementOfTheDateOfIssueOfTheBankCard() {

    //    open("http://localhost:9999");
     //   $("[data-test-id=city] [placeholder='Город']").setValue(DataClients.generateCity());
      //  $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
      //  String verificationDate = LocalDate.now().plusDays(3)         //Текущая дата плюс 3 дня
      //          .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));     //Формат даты день.месяц.год
      //  $("[data-test-id=date] input").setValue(verificationDate);
       // $("[data-test-id=name] [name='name']").setValue(DataClients.generateName());
       // $("[data-test-id=phone] [name='phone']").setValue(DataClients.generatePhone());
       // $("[data-test-id=agreement]").click();
       // $$("[class=button__text]").find(exactText("Запланировать")).click();
       // $$("[class=button__text]").find(exactText("Перепланировать")).click();

      //  $("[data-test-id=success-notification]").$("[class=notification__content]")
      //          .shouldHave(textCaseSensitive("Встреча успешно запланирована на " + verificationDate));


