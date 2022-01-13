import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    @DisplayName("Проверить вкладку 'Issue' на странице Github")
    void checkIssuesInGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");

        $("[data-test-selector='nav-search-input']").setValue("Allure").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#issues-tab").should(visible);
        sleep(10);
    }
}
