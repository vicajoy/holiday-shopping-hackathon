import eyes.EyesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

public abstract class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected static EyesManager eyesManager;
    private final String URL = "https://demo.applitools.com/tlcHackathonMasterV2.html";


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        eyesManager = new EyesManager(driver, "AppliFashion");
        eyesManager.setBatchName("Testing Lifecycle");
    }

    public void goToMainPage() {
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
