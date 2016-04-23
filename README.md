#### Android MVP Pattern
Model View Presenter 

##### Dependency for unit and ui testing
```groovy
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    testCompile 'junit:junit:4.12'
    androidTestCompile 'com.android.support.test:runner:0.4.1'
    androidTestCompile 'com.android.support.test:rules:0.4.1'
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2.2'
    compile 'com.squareup.retrofit2:retrofit-mock:2.0.1'
    compile 'org.mockito:mockito-core:2.0.44-beta'
    compile 'com.android.support.test.espresso:espresso-idling-resource:2.2.2'
    compile 'com.android.support.test.espresso:espresso-contrib:2.2.2'
    androidTestCompile 'com.android.support.test.uiautomator:uiautomator-v18:2.1.1'

    ...
}
```

##### Run Test
- ./gradlew test
- ./gradlew connectedDebugAndroidTest

#### UiAutomator
```java
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
```