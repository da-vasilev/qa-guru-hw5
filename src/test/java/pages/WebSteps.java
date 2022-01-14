package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открыть старницу: {page}")
    public WebSteps openPage(String page) {
        open(page);
        return this;
    }

    @Step("В строку поиска внести данные: {searchText}")
    public WebSteps search(String searchText) {
        $("[data-test-selector='nav-search-input']").setValue(searchText).pressEnter();
        return this;
    }

    @Step("Выбрать первый документ в окне результаты")
    public WebSteps clickFirstDocument() {
        $("ul.repo-list li").$("a").click();
        return this;
    }

    @Step("Проверить наличие 'Issues' с номером: {number}")
    public WebSteps checkIssuesTab(String number) {
        $(partialLinkText("Issues")).click();
        $(withText(number)).should(visible);
        return this;
    }

}
