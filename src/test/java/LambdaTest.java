import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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
            $$("ul.repo-list li").first().$("a").click();
        });

        step("Проверяем наличие вкладки 'Issues'", ()-> {
            $("#issues-tab").should(visible);
        });
    }
}
