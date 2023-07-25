package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='mat-button-wrapper']//span[text()='Accept All']")
    WebElement acceptCookie;
    @CacheLookup
    @FindBy(id = "keywords")
    WebElement searchJobTitle;
    @CacheLookup
    @FindBy(id = "location")
    WebElement searchLocation;
    @CacheLookup
    @FindBy(id = "distance")
    WebElement distanceDropDown;
    @CacheLookup
    @FindBy(id = "toggle-hp-search")
    WebElement moreSearchOptionsLink;
    @CacheLookup
    @FindBy(id = "salarymin")
    WebElement salaryMin;
    @CacheLookup
    @FindBy(id = "salarymax")
    WebElement salaryMax;
    @CacheLookup
    @FindBy(id = "salarytype")
    WebElement salaryTypeDropDown;
    @CacheLookup
    @FindBy(id = "tempperm")
    WebElement jobTypeDropDown;
    @CacheLookup
    @FindBy(id = "hp-search-btn")
    WebElement findJobsBtn;
    @FindBy(id = "gdpr-consent-notice")
    WebElement getInToIFrame;
    @CacheLookup
    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptAllBtn;

    public void acceptAllCookies() {
        log.info("Accepting all cookies: " + acceptCookie.toString());
        mouseHoverToElementAndClick(acceptCookie);
    }

    public void enterJobTitle(String jobTitle) {
        log.info("Entering job title: " + searchJobTitle.toString());
        sendTextToElement(searchJobTitle, jobTitle);
    }

    public void enterLocation(String location) {
        log.info("Entering location: " + searchLocation.toString());
        sendTextToElement(searchLocation, location);
    }

    public void selectDistance(String distance) {
        log.info("Selecting distance: " + distanceDropDown.toString());
        selectByVisibleTextFromDropDown(distanceDropDown, distance);
    }

    public void clickOnMoreSearchOptionLink() {
        log.info("Clicking on more search options link: " + moreSearchOptionsLink.toString());
        clickOnElement(moreSearchOptionsLink);
    }

    public void enterMinSalary(String minSalary) {
        log.info("Entering minimum salary: " + salaryMin.toString());
        sendTextToElement(salaryMin, minSalary);
    }

    public void enterMaxSalary(String maxSalary) {
        log.info("Entering maximum salary: " + salaryMax.toString());
        sendTextToElement(salaryMax, maxSalary);
    }

    public void selectSalaryType(String sType) {
        log.info("Selecting salary type: " + salaryTypeDropDown.toString());
        selectByVisibleTextFromDropDown(salaryTypeDropDown, sType);
    }

    public void selectJobType(String jobType) {
        log.info("Selecting job type: " + jobTypeDropDown.toString());
        selectByVisibleTextFromDropDown(jobTypeDropDown, jobType);
    }

    public void clickOnFindJobsButton() {
        log.info("Clicking on find jobs button: " + findJobsBtn.toString());
        clickOnElement(findJobsBtn);
    }

    public void acceptIFrameAlert() throws InterruptedException {
        log.info("Accepting all cookies: " + acceptAllBtn.toString());
        Thread.sleep(2000);
        driver.switchTo().frame(getInToIFrame);
        clickOnElement(acceptAllBtn);
        driver.switchTo().defaultContent();
    }

    public void jobSearch(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
                          String result) {

        log.info("searching for job: ");
        enterJobTitle(jobTitle);
        enterLocation(location);
        selectDistance(distance);
        clickOnMoreSearchOptionLink();
        enterMinSalary(salaryMin);
        enterMaxSalary(salaryMax);
        selectSalaryType(salaryType);
        selectJobType(jobType);
        clickOnFindJobsButton();
    }

}
