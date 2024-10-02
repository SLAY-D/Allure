package githubTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testMainPage(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $x("//input[@id='hero_user_email']").sendKeys("testuser@gmail.com");
        $x("(//button[@type='submit'])[3]").click();
        $x("//span[@class='text-mono text-gray-light-mktg']").should(visible);
    }
}
