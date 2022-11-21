package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.AddEntryService;
import com.crowdar.examples.services.HomeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEntrySteps extends PageSteps {

    @And("The 'Add entry' page is displayed")
    public void theAddEntryPageIsDisplayed() {
        AddEntryService.isViewLoaded();
    }

    @And("The user chooses (.*) hours and (.*) minutes")
    public void theUserChoosesHoursHoursAndMinutesMinutes(int hours, int minutes) {
        AddEntryService.doSetTime(hours, minutes);
    }

    @And("The user inputs the title '(.*)' in 'What are you working on' field")
    public void theUserInputsATitleInWhatAreYouWorkingOnField(String title) {
        AddEntryService.theUserInputsATitle(title);
    }

    @And("The user selects the project field and picks the project '(.*)'")
    public void theUserSelectsTheProjectFieldAndPicksTheProjectProject(String project) {
        AddEntryService.selectProject(project);
    }

    @And("The user saves the time entry")
    public void theUserSavesTheTimeEntry() {
        AddEntryService.saveEntry();
        HomeService.isViewLoaded();
    }

    @Then("The time entry with (.*) hours, (.*) minutes, project '(.*)' and title '(.*), plus a timestamp' is created and displayed on Home page")
    public void theTimeEntryIsCreated(int hours, int minutes, String project, String title) {
        AddEntryService.validateTimeEntry(hours, minutes, project);
    }

    @When("The user selects the start date '(.*)' in date picker")
    public void theUserSelectsTheStartDateInDatePicker(String start) {
        AddEntryService.pickStartDate(start);
    }

    @Then("The time entry with (.*) hours (.*) minutes duration, start date '(.*)', and title '(.*), plus a timestamp' is displayed at Home page and the start date is less or equals to the current date")
    public void theTimeEntryIsDisplayedAndTheStartDateIsLessOrEqualsToTheCurrentDate(int hours, int minutes, String start, String title) {
        AddEntryService.validateTimeEntryWithStartDate(hours, minutes, start);
    }

    @When("The user discards the addition of the new time entry")
    public void theUserDiscardsTheAdditionOfTheNewTimeEntry() {
        AddEntryService.discardNewEntryAddition();
    }

    @Then("The time entry is not saved and doesn't appear in the entries list")
    public void theTimeEntryIsNotSavedAndDoesnTAppearInTheEntriesList() {
        AddEntryService.validateTimeEntryNotAppearing();
    }
}
