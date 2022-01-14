import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {

    @Test
    @Owner("da-vasilev")
    @Feature("Issues")
    @Story("Проверка вкладки Issues")
    @DisplayName("Проверить вкладку 'Issues' на странице Github")
    void checkIssuesInGithub() {
        step("Открываем старницу", ()-> {
            open("https://github.com/");
        });

        step("Заполняем поле поиска", ()-> {
            $("[data-test-selector='nav-search-input']").setValue("Allure").pressEnter();
        });

        step("Выбираем первую страницу", ()-> {
            $("ul.repo-list li").$("a").click();
        });

        step("Проверяем наличие 'Issues' номером", ()-> {
            $(partialLinkText("Issues")).click();
            $(withText("#1558")).should(visible);
        });
    }
}
