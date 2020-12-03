package eyes;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EyesManager {

    private Eyes eyes;
    private String appName;
    private WebDriver driver;

    public EyesManager(WebDriver driver, String appName) {
        this.driver = driver;
        this.appName = appName;
        eyes = new Eyes(new VisualGridRunner(5));
        eyes.setApiKey(System.getenv("API_KEY"));
        eyes.setConfiguration(getConfig());
    }

    /**
     * Sets the name for the batch of tests
     *
     * @param batchName String - e.g. Testing Lifecycle
     */
    public void setBatchName(String batchName) {
        eyes.setBatch(new BatchInfo(batchName));
    }

    /**
     * Takes screenshot of the entire window and compares with the baseline
     *
     * @param testName String - name of the test in Applitools, e.g. Test 1
     * @param stepName String - name of the screenshot, e.g. main page
     */
    public void validateWindow(String testName, String stepName) {
        eyes.open(driver, appName, testName);
        eyes.setMatchLevel(MatchLevel.STRICT);
        eyes.checkWindow(stepName);
        eyes.close();
    }

    /**
     * Takes screenshot of element by given locator and compares with the baseline
     *
     * @param testName String - name of the test in Applitools, e.g. Test 1
     * @param stepName String - name of the screenshot, e.g. main page
     * @param locator  By - locator to validate
     */
    public void validateElement(By locator, String testName, String stepName) {
        eyes.open(driver, appName, testName);
        eyes.setMatchLevel(MatchLevel.STRICT);
        eyes.checkElement(locator, stepName);
        eyes.close();
    }

    /**
     * Returns configuration of browser types and viewport sizes for Visual Grid Runner
     *
     * @return configuration of the runner
     */
    private static Configuration getConfig() {
        Configuration vgConfig = new Configuration();
        vgConfig.addBrowser(1200, 800, BrowserType.CHROME);
        vgConfig.addBrowser(1200, 800, BrowserType.FIREFOX);
        vgConfig.addBrowser(1200, 800, BrowserType.EDGE);
        vgConfig.addBrowser(1200, 800, BrowserType.SAFARI);
        vgConfig.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
        return vgConfig;
    }
}