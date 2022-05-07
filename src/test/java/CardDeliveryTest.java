import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {

    @Test

    public void shouldDeliveryCard() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[placeholder='Дата встречи']").setValue("13.05.2022");
        $$x("//input[@type='text']").get(1).setValue("Иванов Иван");
        $(byName("phone")).setValue("+79162235588");
        $$x("//*[@class=\"checkbox__box\"]").get(0).click();
        $$x("//*[@class=\"button__text\"]").get(0).click();
        $(withText("Успешно!")).should(visible, Duration.ofSeconds(15));


    }
}



