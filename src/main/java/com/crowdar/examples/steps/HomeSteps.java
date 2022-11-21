package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.AddEntryService;
import com.crowdar.examples.services.HomeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class HomeSteps extends PageSteps {

    @Then("Home page is displayed")
    public void isHomePageVisible() {
        HomeService.isViewLoaded();
    }

    @When("The user taps on the 'Add time entry' button")
    public void tapOnTheAddTimeButton() {
        HomeService.tapOnTheAddTimeButton();
        AddEntryService.isViewLoaded();
    }

    @When("The user enters in settings and checks the current dark mode status")
    public void theUserEntersInSettingsAndChecksTheCurrentDarkModeStatus() {
        HomeService.enterInSettings();
        HomeService.checkDarkModeInSettings();
    }

    @And("The user taps on the 'Enable dark mode' toggle")
    public void theUserTapsOnTheEnableDarkModeToggle() {
        HomeService.changeDarkModeStatus();
    }

    @Then("The dark mode status is now the opposite of the initial one")
    public void theDarkModeStatusIsNowTheOppositeOfTheInitialOne() {
        HomeService.validateDarkModeStatus();
    }

    @When("The user logs out")
    public void theUserLogsOut() {
        HomeService.logout();
    }
}
