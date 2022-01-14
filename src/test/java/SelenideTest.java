import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    @DisplayName("Проверить вкладку 'Issue' на странице Github")
    void checkIssuesInGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");

        $("[data-test-selector='nav-search-input']").setValue("Allure").pressEnter();
        $("ul.repo-list li").$("a").click();
        $(partialLinkText("Issues")).click();
        $(withText("#1558")).should(visible);
    }
}
