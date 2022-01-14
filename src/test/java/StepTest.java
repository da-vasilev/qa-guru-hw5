
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebSteps;

public class StepTest {

    @Test
    @Owner("da-vasilev")
    @Feature("Issues")
    @Story("Проверка вкладки Issues")
    @DisplayName("Проверить вкладку 'Issues' на странице Github")
    void checkIssueInGithub() {
        WebSteps webSteps = new WebSteps();

        webSteps
                .openPage("https://github.com/")
                .search("Allure")
                .clickFirstDocument()
                .checkIssuesTab("#1558");
    }
}
