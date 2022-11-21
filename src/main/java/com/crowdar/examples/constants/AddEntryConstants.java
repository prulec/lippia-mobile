package com.crowdar.examples.constants;

import java.util.HashMap;
import java.util.Map;

public class AddEntryConstants {

    public static final String LOCATOR_ADD_ENTRY_TOOLBAR_INITIAL_TITLE = "xpath://android.widget.TextView[@content-desc=\"Add entry\"]";
    public static final String LOCATOR_ADD_ENTRY_TOOLBAR_MANUAL_TITLE = "xpath://android.widget.TextView[@content-desc=\"Manual\"]";
    public static final String LOCATOR_HOURS_INPUT = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.NumberPicker[1]/android.widget.EditText";
    public static final String LOCATOR_HOURS_NEXT_BUTTON = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.NumberPicker[1]/android.widget.Button[2]";
    public static final String LOCATOR_MINUTES_NEXT_BUTTON = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.NumberPicker[2]/android.widget.Button[2]";
    public static final String MESSAGE_VIEW_NOT_DISPLAYED = "Add Entry page is not displayed.";
    public static final String LOCATOR_TITLE_INPUT = "id:time_entry_description_input";
    public static final String LOCATOR_PROJECT_FIELD = "id:timeentry_project_section";
    public static final String LOCATOR_PROJECTS_SECTION_FIRST = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView";
    public static final String LOCATOR_PROJECT = "xpath://android.widget.TextView[@text='";
    public static final String LOCATOR_SAVE_BUTTON = "xpath://android.widget.Button[@text='SAVE']";
    public static final String LOCATOR_DATE_PICKER = "xpath://*[contains(@resource-id,'timeentry_start_label')]/..";
    public static final String LOCATOR_FIRSTDAY = "xpath://*[contains(@resource-id,'month_view')]/android.view.View[@index=0]";
    public static final String LOCATOR_CURRENTDAY = "xpath://*[contains(@resource-id,'month_view')]/android.view.View[@checked='true']";
    public static final String LOCATOR_DAY_START = "xpath://*[contains(@resource-id,'month_view')]/android.view.View[@index=";
    public static final String LOCATOR_PREVIOUSMONTH = "xpath://android.widget.ImageButton[contains(@resource-id,'prev')]";
    public static final String LOCATOR_NEXTMONTH = "xpath://android.widget.ImageButton[contains(@resource-id,'next')]";
    public static final String LOCATOR_SAVEDATE_BUTTON = "xpath://android.widget.Button[@text='SAVE']";
    public static final String LOCATOR_BACK_BUTTON = "xpath://*[contains(@resource-id,'toolbar')]/*[@index=0]";
    public static final String LOCATOR_DISCARDCONFIRM_BUTTON = "xpath://android.widget.TextView[@text='DISCARD']";
    public static final Map<String,Integer> MONTHS = getMonths();
    private static Map<String,Integer> getMonths() {
        Map<String,Integer> data = new HashMap<>();
        data.put("January", 1);
        data.put("February", 2);
        data.put("March", 3);
        data.put("April", 4);
        data.put("May", 5);
        data.put("June", 6);
        data.put("July", 7);
        data.put("August", 8);
        data.put("September", 9);
        data.put("October", 10);
        data.put("November", 11);
        data.put("December", 12);
        data.put("enero", 1);
        data.put("febrero", 2);
        data.put("marzo", 3);
        data.put("abril", 4);
        data.put("mayo", 5);
        data.put("junio", 6);
        data.put("julio", 7);
        data.put("agosto", 8);
        data.put("septiembre", 9);
        data.put("octubre", 10);
        data.put("noviembre", 11);
        data.put("diciembre", 12);
        return data;
    }
}
