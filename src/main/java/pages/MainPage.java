package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private final By blackColorCheckbox = By.id("LABEL__containerc__104");
    private final By filterBtn = By.id("filterBtn");
    private final By resultItem = By.className("grid_item");
    private final By resultGrid = By.id("product_grid");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public By getResultGrid() {
        return resultGrid;
    }

    /**
     * Filters shoes by black color by clicking the Black checkbox on the sidebar
     */
    public void filterShoesByBlackColor() {
        click(blackColorCheckbox);
        click(filterBtn);
    }

    /**
     * Clicks on the product by its name and redirects to the Product Details page
     *
     * @param productName String - name of the product to select
     */
    public void selectProductByName(String productName) {
        waitForVisibilityOf(resultItem);
        for (WebElement element : findAll(resultItem)) {
            if (element.getText().contains(productName)) {
                element.click();
                break;
            }
        }
    }
}

