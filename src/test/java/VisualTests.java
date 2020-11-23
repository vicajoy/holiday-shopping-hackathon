import org.testng.annotations.Test;


public class VisualTests extends BaseTest {

    @Test(priority = 1)
    public void testMainPage() {
        goToMainPage();
        eyesManager.validateWindow("Test 1", "main page");
    }

    @Test(priority = 2)
    public void testFilteredProductGrid() {
        goToMainPage();
        mainPage.filterShoesByBlackColor();
        eyesManager.validateElement(mainPage.getResultGrid(), "Test 2", "filter by color");

    }

    @Test(priority = 3)
    public void testProductDetails() {
        goToMainPage();
        mainPage.selectProductByName("Appli Air x Night");
        eyesManager.validateWindow("Test 3", "product details");
    }
}
