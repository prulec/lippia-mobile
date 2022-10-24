package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.AddEntryConstants;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;

public class AddEntryService {

    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(AddEntryConstants.LOCATOR_ADD_ENTRY_TOOLBAR_INITIAL_TITLE);
        Assert.assertTrue(MobileActionManager.isVisible(AddEntryConstants.LOCATOR_HOURS_INPUT), AddEntryConstants.MESSAGE_VIEW_NOT_DISPLAYED);
    }

    public static void doSetTime(int hours, int minutes) {
        for (int i = 0; i < hours; i++) {
            MobileActionManager.click(AddEntryConstants.LOCATOR_HOURS_NEXT_BUTTON);
        }
        for (int i = 0; i < minutes; i++) {
            MobileActionManager.click(AddEntryConstants.LOCATOR_MINUTES_NEXT_BUTTON);
        }
//        String hoursText = MobileActionManager.getElement(AddEntryConstants.LOCATOR_HOURS_INPUT).getText();
//        Assert.assertEquals(Integer.parseInt(hoursText), hours);
//        String minutesText = MobileActionManager.getElement(AddEntryConstants.LOCATOR_MINUTES_INPUT).getText();
//        Assert.assertEquals(Integer.parseInt(minutesText), minutes);
    }

    public static void theUserInsertsATitle(String title) {
        MobileActionManager.click(AddEntryConstants.LOCATOR_TITLE_INPUT);
        MobileActionManager.setInput(AddEntryConstants.LOCATOR_TITLE_INPUT, title + " " + System.currentTimeMillis());
    }

    public static void selectProject(String project) {
        MobileActionManager.click(AddEntryConstants.LOCATOR_PROJECT_FIELD);
        MobileActionManager.waitVisibility(AddEntryConstants.LOCATOR_PROJECTS_SECTION_FIRST);
        MobileActionManager.click(AddEntryConstants.LOCATOR_PROJECT + project + "']");
//        MobileActionManager.waitVisibility(AddEntryConstants.LOCATOR_ADD_ENTRY_TOOLBAR_MANUAL_TITLE);
//        String selectedProject = MobileActionManager.getElement(AddEntryConstants.LOCATOR_SELECTED_PROJECT).getText();
//        Assert.assertTrue(selectedProject.contains(project));
    }

    public static void saveEntry() {
        MobileActionManager.waitVisibility(AddEntryConstants.LOCATOR_ADD_ENTRY_TOOLBAR_MANUAL_TITLE);
        MobileActionManager.click(AddEntryConstants.LOCATOR_SAVE_BUTTON);
    }

    public static void validateLast(int hours, int minutes, String title, String project) {
        String timeLast = MobileActionManager.getElement(AddEntryConstants.LOCATOR_LAST_ITEM_TIME).getText();
        int hoursLast = Integer.parseInt(timeLast.split(":")[0]);
        int minutesLast = Integer.parseInt(timeLast.split(":")[1]);
        String titleLast = MobileActionManager.getElement(AddEntryConstants.LOCATOR_LAST_ITEM_TITLE).getText();
        String projectLast = MobileActionManager.getElement(AddEntryConstants.LOCATOR_LAST_ITEM_PROJECT).getText();
        Assert.assertEquals(hoursLast, hours);
        Assert.assertEquals(minutesLast, minutes);
        Assert.assertTrue(titleLast.contains(title));
        Assert.assertEquals(projectLast, project);
        removeLast();
    }

    private static void removeLast() {
        MobileActionManager.click(AddEntryConstants.LOCATOR_LAST_ITEM_MENU);
        MobileActionManager.waitVisibility(AddEntryConstants.LOCATOR_DELETE_BUTTON);
        MobileActionManager.click(AddEntryConstants.LOCATOR_DELETE_BUTTON);
        MobileActionManager.waitVisibility(HomeConstants.LOCATOR_ADD_TIME_BUTTON);
    }
}
