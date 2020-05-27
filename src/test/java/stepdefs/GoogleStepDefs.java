package stepdefs;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import pages.GoogleSearchPage;

public class GoogleStepDefs implements En {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    public GoogleStepDefs() {
        Before((scenario) -> {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
            googleSearchPage = new GoogleSearchPage();
        });

        Given("open {string} page", (String arg0) -> {
            googleSearchPage.open(arg0);
        });

        When("enter {string} in search input", (String arg0) -> {
            googleSearchPage.enterSearchParam(arg0);
            googleSearchPage.clickSearch();
        });

        Then("search results page opens", () ->{
            googleSearchPage.checkSearchResultsPage();
        });

        And("first result has text {string}", (String arg0) -> {
            googleSearchPage.checkFirstResult(arg0);
        });
    }
}
