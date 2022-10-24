package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.AddEntryService;
import com.crowdar.examples.services.HomeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AddEntrySteps extends PageSteps {

    @And("The 'Add entry' page is displayed")
    public void theAddEntryPageIsDisplayed() {
        AddEntryService.isViewLoaded();
    }

    @And("The user puts (.*) hours and (.*) minutes")
    public void theUserPutsHoursHoursAndMinutesMinutes(int hours, int minutes) {
        AddEntryService.doSetTime(hours, minutes);
    }

    @And("The user inserts the title '(.*)' in 'What are you working on' field")
    public void theUserInsertsATitleInWhatAreYouWorkingOnField(String title) {
        AddEntryService.theUserInsertsATitle(title);
    }

    @And("The user selects the project field and picks the project (.*)")
    public void theUserSelectsTheProjectFieldAndPicksTheProjectProject(String project) {
        AddEntryService.selectProject(project);
    }

    @And("The user saves the time entry")
    public void theUserSavesTheTimeEntry() {
        AddEntryService.saveEntry();
    }

    @And("The time entry with (.*) hours, (.*) minutes, title '(.*)', and project '(.*)' was created successfully")
    public void theTimeEntryWasCreatedSuccessfully(int hours, int minutes, String title, String project) {
        AddEntryService.validateLast(hours, minutes, title, project);
    }
}
