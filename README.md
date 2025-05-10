How to Run
=================================================
- Install [Appium](https://appium.io/docs/en/latest/quickstart/install/), UiAutomator2 for Android and XCUITest for iOS
    ```
    npm install -g appium
    appium setup
    ```
- Check Android and iOS drivers are installed successfully
    ```
    appium driver doctor uiautomator2
    appium driver doctor xcuitest
    ```
- Install JDK 11 or above
- Install Android SDK via [Android Studio](https://developer.android.com/studio) and then set ANDROID_HOME
    ```export ANDROID_HOME="~/Library/Android/sdk"```
- Run an Android Emulator via Android Studio
- Install akakce split apks into the emulator  
    ```$ANDROID_HOME/platform-tools/adb install-multiple src/test/resources/apps/akakce-split-apks/*```
- Run ANDROID in emulator ```mvn test```
- Run iOS real device enter your device udid ``` mvn test -DplatformName=iOS -Dudid=00008030-00111C681193402E```

How to for myself
=================================================
- ANDROID:
    - Get split apks files
        - Install the app into my Android phone
        - Connect my phone to PC via usb cable
        - Run ```adb shell pm path com.akakce.akakce```
        - Run ```adb pull /path/to/apk /your/local/folder```
    - Detect correct appActivity  
```$ANDROID_HOME/platform-tools/adb shell cmd package resolve-activity --brief com.akakce.akakce```
Install Appium Inspector
https://github.com/appium/appium-inspector

- iOS: 
    - Switch xcode to developer
    ```sudo xcode-select --switch /Applications/Xcode.app/Contents/Developer/```
    - Getting iOS app file(via https://github.com/majd/ipatool) does not work because iOS app was not build to work on simulator. If we had the code, we could build it for Simulator.
    - Test using real device connected to Mac vid USB
    ```
    npm install -g appium-doctor
    appium-doctor --ios
    brew install carthage
    brew install ffmpeg
    ```
    
