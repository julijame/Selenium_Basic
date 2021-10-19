package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void selectCheckBox() throws Exception {
//         TODO:
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));

        WebElement resultButton = driver.findElement(By.cssSelector("#result_button_checkbox"));
        WebElement resultText = driver.findElement(By.cssSelector("#result_checkbox"));

//        check that none of the checkboxes are ticked
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
            checkBox.click();
            assertTrue(checkBox.isSelected()); // checkboxes are selected
            checkBox.click();
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }

//        tick  "Option 2"
        option2.click();

//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        assertFalse(option1.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option2.isSelected());

//        tick  "Option 3"
        option3.click();

//        click result
        resultButton.click();

//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        assertTrue(resultText.getText().equals("You selected value(s): Option 2, Option 3"));
    }


    @Test
    public void selectRadioButton() throws Exception {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));

        WebElement resultButton = driver.findElement(By.cssSelector("#result_button_ratio"));
        WebElement resultText = driver.findElement(By.cssSelector("#result_radio"));

//         TODO:
//        check that none of the radio are selected
        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected()); // radio are NOT selected
            radioButton.click();
            assertTrue(radioButton.isSelected()); // radio are selected
        }
//        select  "Option 3"
            option3.click();

//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
            assertFalse(option1.isSelected());
            assertFalse(option2.isSelected());
            assertTrue(option3.isSelected());

//        select  "Option 1"
            option1.click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());

//        click result
        resultButton.click();

//        check that 'You selected option: Option 1' text is being displayed
        assertTrue(resultText.getText().equals("You selected option: Option 1"));
    }

    @Test
    public void selectOption() throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        WebElement resultButton = driver.findElement(By.cssSelector("#result_button_select"));
        WebElement resultText = driver.findElement(By.cssSelector("#result_select"));

//        select "Option 3" in Select
        dropdown.selectByIndex(3);

//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

//        select "Option 2" in Select
        dropdown.selectByVisibleText("Option 2");

//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

//        click result
        resultButton.click();

//        check that 'You selected option: Option 2' text is being displayed
        assertTrue(resultText.getText().equals("You selected option: Option 2"));
    }


    @Test
    public void chooseDateViaCalendarBonusByRaitis() throws Exception {
//         TODO:
//        saved for myself for future reference

//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
        WebElement datePicker = driver.findElement(By.id("vfb-8"));
        datePicker.click();

        WebElement calWidget = driver.findElement(By.id("ui-datepicker-div"));

        WebElement calBack = calWidget.findElement(By.className("ui-datepicker-prev"));
        WebElement calMonth = calWidget.findElement(By.className("ui-datepicker-month"));
        WebElement calYear = calWidget.findElement(By.className("ui-datepicker-year"));

        while (!((calMonth.getText() + " " + calYear.getText()).equals("July 2007"))) {
            calBack.click();
            Thread.sleep(10);
            calBack = calWidget.findElement(By.className("ui-datepicker-prev"));
            calMonth = calWidget.findElement(By.className("ui-datepicker-month"));
            calYear = calWidget.findElement(By.className("ui-datepicker-year"));
        }

        calWidget.findElement(By.xpath("//a[text()='4']")).click();
        driver.findElement(By.id("result_button_date")).click();
        assertEquals("You entered date: 07/04/2007", driver.findElement(By.id("result_date")).getText());

    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
        String dateToEnter = "05/02/1959";

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
    }
}
