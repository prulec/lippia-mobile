package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class HomeService {

    public static final ThreadLocal<Boolean> DARKMODE_STATUS = new ThreadLocal<>();

    // CLOCKIFY
    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(HomeConstants.LOCATOR_ADD_TIME_BUTTON);
        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.LOCATOR_ADD_TIME_BUTTON), HomeConstants.MESSAGE_VIEW_NOT_DISPLAYED);
    }

    public static void tapOnTheAddTimeButton() {
        MobileActionManager.click(HomeConstants.LOCATOR_ADD_TIME_BUTTON);
    }

    public static void enterInSettings() {
        MobileActionManager.click(HomeConstants.LOCATOR_NAVIGATIONDRAWER);
        MobileActionManager.click(HomeConstants.LOCATOR_SETTINGDRAWER);
    }

    public static void checkDarkModeInSettings() {
        String darkmodeStatus = MobileActionManager.getElement(HomeConstants.LOCATOR_DARKMODE_TOGGLE).getAttribute("text");
        if (darkmodeStatus.equals("ON")) {
            DARKMODE_STATUS.set(Boolean.TRUE);
        } else {
            DARKMODE_STATUS.set(Boolean.FALSE);
        }
    }

    public static void changeDarkModeStatus() {
        MobileActionManager.click(HomeConstants.LOCATOR_DARKMODE_TOGGLE);
    }

    public static void validateDarkModeStatus() {
        Boolean initialStatus = DARKMODE_STATUS.get();
        Boolean currentStatus = MobileActionManager.getElement(HomeConstants.LOCATOR_DARKMODE_TOGGLE).getAttribute("text").equals("ON");
        Assert.assertFalse(initialStatus && currentStatus);
    }

    public static void logout() {
        MobileActionManager.click(HomeConstants.LOCATOR_NAVIGATIONDRAWER);
        MobileActionManager.click(HomeConstants.LOCATOR_LOGOUTDRAWER);
        MobileActionManager.click(HomeConstants.LOCATOR_LOGOUTCONFIRM_BUTTON);
    }
}
