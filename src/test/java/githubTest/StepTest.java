package githubTest;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class StepTest {
    private static String BASE_URL = "https://github.com/";
    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Переходим на главную страницу " + BASE_URL, () -> {
            open("https://github.com/");
        });

        step("Ввод почты в поле", () -> {
            $x("//input[@id='hero_user_email']").sendKeys("testuser@gmail.com");
        });

        step("Нажатие на Sign up for Github", () ->{
            $x("(//button[@type='submit'])[3]").click();
        });

        step("Проверка, что текст видимый", () ->{
            $x("//span[@class='text-mono text-gray-light-mktg']").should(visible);
        });
    }

    @Test
    public void testWebSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();
        webSteps.openPage();
        webSteps.inputEmail();
        webSteps.clickSignUp();
        webSteps.checkText();
    }

    @Test
    public void testAttachments(){
        Services services = new Services();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Переходим на главную страницу " + BASE_URL, () -> {
            open("https://github.com/");
            attachment("Source", WebDriverRunner.source()); // Прикрепление HTML кода страницы
        });
        services.takeScreenshot();
    }
}
