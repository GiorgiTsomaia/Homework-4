import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework {
    @Test
    public void TestCase(){
        Configuration.browserSize = "1920x1080";
        open("https://ee.ge");

        $(".btn-cart").click();
        sleep(1000);
        $(".not_cart_items").shouldBe(Condition.visible);

        $(byText("შენახული ნივთები")).click();
        sleep(1000);
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);

        $(byText("მსხვილი საყოფაცხოვრებო ტექნიკა")).click();
        $(byText("კონდიციონერი")).click();
        $(byText("დაამატე კალათში"),0).shouldBe(Condition.visible, Duration.ofMillis(50000));
        $(byText("დაამატე კალათში"),0).click();

        $(".btn-cart").click();
        $(byText("შენახვა")).click();
        sleep(500);
        $(byText("შენახული ნივთები")).click();
        sleep(1000);
        $(byText("ვერ მოიძებნა")).shouldNotBe(Condition.visible);

        $(".btn-cart").click();
        sleep(500);
        $(".not_cart_items").shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        sleep(2000);
        $(".cross_icon").click();
        sleep(500);
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);


    }

}
