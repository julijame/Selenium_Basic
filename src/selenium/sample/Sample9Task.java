package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample9Task {
    WebDriver driver;
    private static WebDriverWait wait;


    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");

 //       wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
        WebElement startGrButton = driver.findElement(By.cssSelector("#start_green"));

//         TODO:
//         * 1) click on start loading green button
        startGrButton.click();

//         * 2) check that button does not appear,
        assertFalse(startGrButton.isDisplayed());

//         * but loading text is seen instead   "Loading green..."
        WebElement grLoading = driver.findElement(By.cssSelector("#loading_green"));
        assertTrue(grLoading.isDisplayed());

//         * 3) check that both button
//         * and loading text is not seen,
        Thread.sleep(5000);
        assertFalse(startGrButton.isDisplayed());
        assertFalse(grLoading.isDisplayed());

//         * success is seen instead "Green Loaded"
        WebElement grLoaded = driver.findElement(By.cssSelector("#finish_green"));
        assertTrue(grLoaded.isDisplayed());
    }

    @Test
    public void loadGreenImplicit() throws Exception {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement startGrButton = driver.findElement(By.cssSelector("#start_green"));
//         TODO:
//         * 1) click on start loading green button
        startGrButton.click();

//         * 2) check that button does not appear,
        assertFalse(startGrButton.isDisplayed());

//         * but loading text is seen instead   "Loading green..."
        WebElement grLoading = driver.findElement(By.cssSelector("#loading_green"));
        assertTrue(grLoading.isDisplayed());

//         * 3) check that both button
//         * and loading text is not seen,
        WebElement grLoaded = driver.findElement(By.cssSelector("#finish_green"));
        assertFalse(startGrButton.isDisplayed());
        assertFalse(grLoading.isDisplayed());

//         * success is seen instead "Green Loaded"
        assertTrue(grLoaded.isDisplayed());
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
        WebElement startGrButton = driver.findElement(By.cssSelector("#start_green"));
        WebDriverWait wait = (WebDriverWait)
                new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);
//         * 1) click on start loading green button
        startGrButton.click();

//         * 2) check that button does not appear,
        assertFalse(startGrButton.isDisplayed());

//         * but loading text is seen instead   "Loading green..."
        WebElement grLoading = driver.findElement(By.cssSelector("#loading_green"));
        assertTrue(grLoading.isDisplayed());

//         * 3) check that both button
//         * and loading text is not seen,
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish_green")));
        WebElement grLoaded = driver.findElement(By.cssSelector("#finish_green"));
        assertFalse(startGrButton.isDisplayed());
        assertFalse(grLoading.isDisplayed());

//         * success is seen instead "Green Loaded"
        assertTrue(grLoaded.isDisplayed());
    }

    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:

         * 0) wait until button to load green and blue appears
         * 1) click on start loading green and blue button
         * 2) check that button does not appear, but loading text is seen instead for green
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
    }

}