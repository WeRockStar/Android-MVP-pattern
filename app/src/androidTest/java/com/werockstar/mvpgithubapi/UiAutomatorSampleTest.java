package com.werockstar.mvpgithubapi;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class UiAutomatorSampleTest {

    private UiDevice uiDevice;
    private final String packages = "com.werockstar.mvpgithubapi";

    @Before
    public void startGithubActivityScreen() {
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        //Start from home screen
        uiDevice.pressHome();

        String launcherPackage = uiDevice.getLauncherPackageName();

        //Wait for launcher
        uiDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 5000);

        //Launch app
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(packages);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        //Wait for app to appear
        uiDevice.wait(Until.hasObject(By.pkg(packages).depth(0)), 5000);
    }

    @Test
    public void checkUiDevice() {
        assertThat(uiDevice, notNullValue());
    }

    @Test
    public void put_github_werockstar_should_show_Kotchaphan_Muangsan() {
        UiObject2 edtUser =
                uiDevice.findObject(By.res(packages + ":id/edtUsername"));
        edtUser.setText("werockstar");

        UiObject2 btnLoad =
                uiDevice.findObject(By.res(packages + ":id/btnLoad"));
        btnLoad.click();

        uiDevice.wait(Until
                .findObject(By.res(packages + ":id/tvFullName").depth(0)), 5000);

        UiObject2 tvFullName =
                uiDevice.findObject(By.res(packages + ":id/tvFullName"));
        assertEquals("Kotchaphan Muangsan", tvFullName.getText());
    }

    @Test
    public void put_github_amwerockstar_should_show_Kotchaphan_Muangsan() {
        UiObject2 edtUser =
                uiDevice.findObject(By.res(packages + ":id/edtUsername"));
        edtUser.setText("amwerockstar");

        UiObject2 btnLoad =
                uiDevice.findObject(By.res(packages + ":id/btnLoad"));
        btnLoad.click();

        uiDevice.wait(Until
                .findObject(By.res(packages + ":id/tvFullName").depth(0)), 3000);

        UiObject2 tvFullName =
                uiDevice.findObject(By.res(packages + ":id/tvFullName"));
        assertEquals("Kotchaphan Muangsan", tvFullName.getText());
    }

    @Test
    public void put_github_werockstar_should_show_werockstar() {
        UiObject2 edtUser =
                uiDevice.findObject(By.res(packages + ":id/edtUsername"));
        edtUser.setText("werockstar");

        UiObject2 btnLoad =
                uiDevice.findObject(By.res(packages + ":id/btnLoad"));
        btnLoad.click();

        uiDevice.wait(Until
                .findObject(By.res(packages + ":id/tvUsername").depth(0)), 3000);

        UiObject2 tvUsername = uiDevice.findObject(By.res(packages + ":id/tvUsername"));
        assertEquals("WeRockStar", tvUsername.getText());
    }
}
