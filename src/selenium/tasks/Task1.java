package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() throws InterruptedException {

        WebElement numberInput = driver.findElement(By.id("numb"));
        String letters = "asfas";
//        TODO
//        enter a text instead of a number, check that correct error is seen

        numberInput.clear();
        numberInput.sendKeys(letters);
        driver.findElement(By.className("w3-orange")).click();

        assertTrue(driver.findElement(By.id("ch1_error")).getText().equals("Please enter a number"));



    }

    @Test
    public void errorOnNumberTooSmall() {
//        WebElement numberInput = driver.findElement(By.id("numb"));
//        WebElement numberInput = driver.findElement(By.cssSelector("#numb"));
        WebElement numberInput = driver.findElement(By.xpath("//input[@id = 'numb']"));
        String testNumber = "40";
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        numberInput.clear();
        numberInput.sendKeys(testNumber);
        driver.findElement(By.className("w3-orange")).click();

        assertTrue(driver.findElement(By.id("ch1_error")).getText().equals("Number is too small"));

    }

    @Test
    public void errorOnNumberTooBig() {
        WebElement numberInput = driver.findElement(By.id("numb"));
        String testNumber = "140";

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        numberInput.clear();
        numberInput.sendKeys(testNumber);
        driver.findElement(By.className("w3-orange")).click();

//        System.out.println(driver.findElement(By.id("ch1_error")).getText());
        assertTrue(driver.findElement(By.id("ch1_error")).getText().equals("Number is too big"));
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        WebElement numberInput = driver.findElement(By.id("numb"));
        String testNumber = "81";
//        TODO
        numberInput.clear();
        numberInput.sendKeys(testNumber);
        driver.findElement(By.className("w3-orange")).click();

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00", alert.getText());
        alert.accept();


    }

    @Test
    public void correctSquareRootWithRemainder() {
        WebElement numberInput = driver.findElement(By.id("numb"));
        String testNumber = "62";
//        TODO
        numberInput.clear();
        numberInput.sendKeys(testNumber);
        driver.findElement(By.className("w3-orange")).click();

//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 62 is 7.87", alert.getText());
        alert.accept();
    }
}
