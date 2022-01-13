
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class StepTest {

    @Test
    @Owner("da-vasilev")
    @Feature("Issues")
    @Story("Проверка вкладки Issues")
    @DisplayName("Проверить вкладку 'Issues' на странице Github")
    void checkIssueInGithub() {
        MainPage mainPage = new MainPage();

        mainPage
                .openPage("https://github.com/")
                .search("Allure")
                .clickFirstDocument()
                .checkIssuesTab();
    }
}
