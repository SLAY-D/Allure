package githubTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Проверка текста на валидность")
    @Story("Переход по Sign up")
    @Owner("gorbatenkoda")
    @Link(value = "Test link", url = "https://github.com/")
    @DisplayName("Сверка текста")
    public void testStaticLabel(){

    }
}
