package uk.co.library.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultsPage;

public class JobSearchSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {
    }

    @When("I click on accept cookies")
    public void iClickOnAcceptCookies() throws InterruptedException {
        new HomePage().acceptIFrameAlert();
    }

    @And("I enter the job title {string}")
    public void iEnterTheJobTitle(String jobTitle) {
        new HomePage().enterJobTitle(jobTitle);
    }

    @And("I enter location {string}")
    public void iEnterLocation(String location) {
        new HomePage().enterLocation(location);

    }

    @And("I select distance {string}")
    public void iSelectDistance(String distance) {
        new HomePage().selectDistance(distance);
    }

    @And("I click on more search options link")
    public void iClickOnMoreSearchOptionsLink() {
        new HomePage().clickOnMoreSearchOptionLink();
    }

    @And("I enter minimum salary {string}")
    public void iEnterMinimumSalary(String minSalary) {
        new HomePage().enterMinSalary(minSalary);
    }

    @And("I enter maximum salary {string}")
    public void iEnterMaximumSalary(String maxSalary) {
        new HomePage().enterMaxSalary(maxSalary);
    }

    @And("I select salary type {string}")
    public void iSelectSalaryType(String sType) {
        new HomePage().selectSalaryType(sType);
    }

    @And("I select job type {string}")
    public void iSelectJobType(String jobType) {
        new HomePage().selectJobType(jobType);
    }

    @And("I click on find jobs button")
    public void iClickOnFindJobsButton() {
        new HomePage().clickOnFindJobsButton();
    }

    @Then("I verify the result {string}")
    public void iVerifyTheResult(String result) {
        Assert.assertEquals(new ResultsPage().verifyTheResults(), result, "Unable to verify result.");
    }

}
