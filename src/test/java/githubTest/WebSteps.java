package githubTest;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Переход на главную страницу")
    public void openPage(){
        open("https://github.com/");
    }

    @Step("Ввод почты в поле")
    public void inputEmail(){
        $x("//input[@id='hero_user_email']").sendKeys("testuser@gmail.com");
    }

    @Step("Нажатие на Sign up for Github")
    public void clickSignUp(){
        $x("(//button[@type='submit'])[3]").click();
    }

    @Step("Проверка, что текст видимый")
    public void checkText(){
        $x("//span[@class='text-mono text-gray-light-mktg']").should(visible);
    }
}
