package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchPage {

    public GoogleSearchPage open(String url) {

        Selenide.open(url);
        return this;
    }

    /*Methods working with elements*/

    public void enterSearchParam(String value) {
        inputSearch.val(value);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void checkFirstResult(String value) {
        searchResults.get(0).shouldHave(text(value));
    }

    public void checkSearchResultsPage(){
        searchResults.shouldHaveSize(10);
    }

    /*Locators*/

    private SelenideElement inputSearch = $("input[name='q']");
    private SelenideElement searchButton = $("input[name='btnK']");
    private ElementsCollection searchResults = $$("div[class='r'] h3");

}
