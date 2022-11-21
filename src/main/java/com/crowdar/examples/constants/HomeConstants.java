package com.crowdar.examples.constants;

public class HomeConstants {
    public static final String LOCATOR_ADD_TIME_BUTTON = "xpath://android.widget.ImageButton[@content-desc=\"Add time entry\"]";
    public static final String LOCATOR_ENTRY_TITLE_START = "xpath://*[contains(@resource-id,\"time_entry_description\")][contains(@text,'";
    public static final String LOCATOR_ENTRY_TITLE_END = "')]/../*[contains(@resource-id,\"time_entry_description\")]";
    public static final String LOCATOR_ENTRY_TIME_END = "')]/../*[contains(@resource-id,\"time_entry_duration\")]";
    public static final String LOCATOR_ENTRY_PROJECT_END = "')]/../*/*[contains(@resource-id,\"time_entry_project\")]";
    public static final String LOCATOR_ENTRY_MENU_END = "')]/../*[contains(@resource-id,\"time_entry_more_button_icon\")]";
    public static final String LOCATOR_DELETE_BUTTON = "xpath://android.widget.TextView[@text='Delete']";

    public static final String LOCATOR_LISTITEMS = "xpath://androidx.recyclerview.widget.RecyclerView/*";
    public static final String LOCATOR_NAVIGATIONDRAWER = "xpath://android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]";
    public static final String LOCATOR_SETTINGDRAWER = "xpath://android.widget.CheckedTextView[@text='Settings']";
    public static final String LOCATOR_LOGOUTDRAWER = "xpath://android.widget.CheckedTextView[@text='Log out']";
    public static final String LOCATOR_LOGOUTCONFIRM_BUTTON = "xpath://android.widget.TextView[@text='CONFIRM']";
    public static final String LOCATOR_DARKMODE_TOGGLE = "xpath://android.widget.Switch[contains(@resource-id,'settings_dark_mode')]";
    public static final String MESSAGE_VIEW_NOT_DISPLAYED = "Home page is not displayed.";
}
