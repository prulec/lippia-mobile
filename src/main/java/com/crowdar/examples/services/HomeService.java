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

    // DEMO LIPPIA
//    public static void isViewLoaded() {
//        MobileActionManager.waitVisibility(HomeConstants.SIGN_OUT_BUTTON_LOCATOR);
//        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.CHANGE_LANGUAGE_BUTTON_LOCATOR), HomeConstants.VIEW_NOT_DISPLAYED_MESSAGE);
//    }

    // CLOCKIFY
    public static void isViewLoaded() {
        MobileActionManager.waitVisibility(HomeConstants.LOCATOR_ADD_TIME_BUTTON);
        Assert.assertTrue(MobileActionManager.isVisible(HomeConstants.LOCATOR_ADD_TIME_BUTTON), HomeConstants.MESSAGE_VIEW_NOT_DISPLAYED);
    }

    public static void selectTheAddTimeButton() {
        MobileActionManager.click(HomeConstants.LOCATOR_ADD_TIME_BUTTON);
    }
}
