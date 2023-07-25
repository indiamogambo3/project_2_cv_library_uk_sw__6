package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utility;

public class ResultsPage extends Utility {

    private static final Logger log = LogManager.getLogger(ResultsPage.class.getName());

    public ResultsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[@class='search-header__title']")
    WebElement resultText;

    public String verifyTheResults() {
        log.info("Verifying the results: " + resultText.toString());
        return getTextFromElement(resultText);
    }

}
