package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.AddEntryConstants;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;

import java.time.LocalDate;

public class AddEntryService {

    public static final ThreadLocal<String> TITLE = new ThreadLocal<>();

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
    }

    public static void theUserInputsATitle(String title) {
        MobileActionManager.click(AddEntryConstants.LOCATOR_TITLE_INPUT);
        TITLE.set(title + " " + System.currentTimeMillis());
        MobileActionManager.setInput(AddEntryConstants.LOCATOR_TITLE_INPUT, TITLE.get());
    }

    public static void selectProject(String project) {
        MobileActionManager.click(AddEntryConstants.LOCATOR_PROJECT_FIELD);
        MobileActionManager.waitVisibility(AddEntryConstants.LOCATOR_PROJECTS_SECTION_FIRST);
        MobileActionManager.click(AddEntryConstants.LOCATOR_PROJECT + project + "']");
    }

    public static void saveEntry() {
        MobileActionManager.waitVisibility(AddEntryConstants.LOCATOR_ADD_ENTRY_TOOLBAR_MANUAL_TITLE);
        MobileActionManager.click(AddEntryConstants.LOCATOR_SAVE_BUTTON);
    }

    public static void validateTimeEntry(int hours, int minutes, String project) {
        String title = TITLE.get();
        String entryTitle = MobileActionManager.getElement(HomeConstants.LOCATOR_ENTRY_TITLE_START + title + HomeConstants.LOCATOR_ENTRY_TITLE_END).getText();
        String entryTime = MobileActionManager.getElement(HomeConstants.LOCATOR_ENTRY_TITLE_START + title + HomeConstants.LOCATOR_ENTRY_TIME_END).getText();
        int entryTimeHours = Integer.parseInt(entryTime.split(":")[0]);
        int entryTimeMinutes = Integer.parseInt(entryTime.split(":")[1]);
        String entryProject = MobileActionManager.getElement(HomeConstants.LOCATOR_ENTRY_TITLE_START + title + HomeConstants.LOCATOR_ENTRY_PROJECT_END).getText();
        Assert.assertEquals(entryTimeHours, hours);
        Assert.assertEquals(entryTimeMinutes, minutes);
        Assert.assertEquals(entryTitle, title);
        Assert.assertEquals(entryProject, project);
        removeLast(title);
    }

    private static void removeLast(String title) {
        MobileActionManager.click(HomeConstants.LOCATOR_ENTRY_TITLE_START + title + HomeConstants.LOCATOR_ENTRY_MENU_END);
        MobileActionManager.waitVisibility(HomeConstants.LOCATOR_DELETE_BUTTON);
        MobileActionManager.click(HomeConstants.LOCATOR_DELETE_BUTTON);
        MobileActionManager.waitVisibility(HomeConstants.LOCATOR_ADD_TIME_BUTTON);
    }

    public static void pickStartDate(String startString) {
        // date validation
        try {
            LocalDate start = LocalDate.parse(startString);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Invalid start date!");
        }
        MobileActionManager.click(AddEntryConstants.LOCATOR_DATE_PICKER);

        // startDate parsing
        int startYear = Integer.parseInt(startString.split("-")[0]);
        int startMonth = Integer.parseInt(startString.split("-")[1]);
        int startDay = Integer.parseInt(startString.split("-")[2]);

        // current month
        String currentMonthFirstDay = MobileActionManager.getElement(AddEntryConstants.LOCATOR_FIRSTDAY).getAttribute("content-desc");
        String currentMonthString = currentMonthFirstDay.split(" ")[1];
        int currentMonth = AddEntryConstants.MONTHS.get(currentMonthString);

        // current year
        int currentYear = Integer.parseInt(currentMonthFirstDay.split(" ")[2]);

        // month difference --> previous or next month iterations
        int monthDiff = currentYear * 12 + currentMonth - startYear * 12 - startMonth;
        if (monthDiff >= 0) {
            for (int i = 0; i < monthDiff; i++) {
                MobileActionManager.click(AddEntryConstants.LOCATOR_PREVIOUSMONTH);
            }
        } else {
            for (int i = 0; i < -monthDiff; i++) {
                MobileActionManager.click(AddEntryConstants.LOCATOR_NEXTMONTH);
            }
        }

        // pick start day
        MobileActionManager.click(AddEntryConstants.LOCATOR_DAY_START + (startDay - 1) + "]");
        MobileActionManager.click(AddEntryConstants.LOCATOR_SAVEDATE_BUTTON);
    }

    public static void validateTimeEntryWithStartDate(int hours, int minutes, String start) {
        String title = TITLE.get();
        String entryTitle = MobileActionManager.getElement(HomeConstants.LOCATOR_ENTRY_TITLE_START + title + HomeConstants.LOCATOR_ENTRY_TITLE_END).getText();
        String entryTime = MobileActionManager.getElement(HomeConstants.LOCATOR_ENTRY_TITLE_START + title + HomeConstants.LOCATOR_ENTRY_TIME_END).getText();
        int entryTimeHours = Integer.parseInt(entryTime.split(":")[0]);
        int entryTimeMinutes = Integer.parseInt(entryTime.split(":")[1]);
        Assert.assertEquals(entryTimeHours, hours);
        Assert.assertEquals(entryTimeMinutes, minutes);
        Assert.assertEquals(entryTitle, title);
        MobileActionManager.click(HomeConstants.LOCATOR_ENTRY_TITLE_START + title + HomeConstants.LOCATOR_ENTRY_TITLE_END);
        MobileActionManager.click(AddEntryConstants.LOCATOR_DATE_PICKER);
        String entryDateLongString = MobileActionManager.getElement(AddEntryConstants.LOCATOR_CURRENTDAY).getAttribute("content-desc");
        MobileActionManager.click(AddEntryConstants.LOCATOR_BACK_BUTTON);
        MobileActionManager.click(AddEntryConstants.LOCATOR_BACK_BUTTON);
        removeLast(title);
        String year = entryDateLongString.split(" ")[2];
        int monthNumber = AddEntryConstants.MONTHS.get(entryDateLongString.split(" ")[1]);
        String month;
        if (monthNumber<10) {
            month = "0" + monthNumber;
        } else {
            month = "" + monthNumber;
        }
        String day = entryDateLongString.split(" ")[0];
        String entryDateString = year + "-" + month + "-" + day;
        Assert.assertEquals(LocalDate.parse(start), LocalDate.parse(entryDateString));
        LocalDate today = LocalDate.now();
        LocalDate entryDate = LocalDate.parse(entryDateString);
        Assert.assertTrue(today.compareTo(entryDate) >= 0, "Date shouldn't be latter than today!");
    }
}
