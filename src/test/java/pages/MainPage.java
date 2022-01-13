package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Открыть старницу: {page}")
    public MainPage openPage(String page) {
        open(page);
        return this;
    }

    @Step("В строку поиска внести данные: {searchText}")
    public MainPage search(String searchText) {
        $("[data-test-selector='nav-search-input']").setValue(searchText).pressEnter();
        return this;
    }

    @Step("Выбрать первый документ в окне результаты")
    public MainPage clickFirstDocument() {
        $$("ul.repo-list li").first().$("a").click();
        return this;
    }

    @Step("Проверить наличие вкладки: 'Issues'")
    public MainPage checkIssuesTab() {
        $("#issues-tab").should(visible);
        return this;
    }

}
