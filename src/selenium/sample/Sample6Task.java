package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
        System.out.println("Find element by id using xPath:");
        System.out.println("\t text is 'Heading_2 text', let's check:" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        System.out.println("\t text is 'Heading_2 text', let's check:" +
                driver.findElement(By.xpath("//*[text()='Heading 2 text']")).getText());

//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text is 'Test Text 1', let's check:" +
                driver.findElement(By.xpath("//*[text()='Test Text 1']")).getText());
        System.out.println("\t text is 'Test Text 1', let's check:" +
                driver.findElement(By.xpath("//div[@id='test1']/p[@class='test']")).getText());

//        1-2 ways to find text: "Test Text 2"

        System.out.println("\t text is 'Test Text 2', let's check:" +
                driver.findElement(By.xpath("//p[@class='twoTest']")).getText());
        System.out.println("\t text is 'Test Text 2', let's check:" +
                driver.findElement(By.xpath("//div/p[@class='twoTest']")).getText());

//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text is 'Test Text 3', let's check:" +
                driver.findElement(By.xpath("//div[@id='test3']/p[@class='test'][1]")).getText());
        System.out.println("\t text is 'Test Text 3', let's check:" +
                driver.findElement(By.xpath("//div[@id='test3']//p[1]")).getText());
        System.out.println("\t text is 'Test Text 3', let's check:" +
                driver.findElement(By.xpath("//*[text()='Test Text 3']")).getText());

//        1-2 ways to find text: "Test Text 4"
        System.out.println("\t text is 'Test Text 4', let's check:" +
                driver.findElement(By.xpath("//div[@id='test3']/p[@class='test'][2]")).getText());
        System.out.println("\t text is 'Test Text 4', let's check:" +
                driver.findElement(By.xpath("//div[@id='test3']//p[2]")).getText());
        System.out.println("\t text is 'Test Text 4', let's check:" +
                driver.findElement(By.xpath("//*[text()='Test Text 4']")).getText());

//        1-2 ways to find text: "Test Text 5"
        System.out.println("\t text is 'Test Text 3', let's check:" +
                driver.findElement(By.xpath("//div[@id='test2']/p[@class='test'][1]")).getText());
        System.out.println("\t text is 'Test Text 5', let's check:" +
                driver.findElement(By.xpath("//div[@id='test2']//p[1]")).getText());
        System.out.println("\t text is 'Test Text 5', let's check:" +
                driver.findElement(By.xpath("//*[text()='Test Text 5']")).getText());

//        1-2 ways to find text: "This is also a button"
        System.out.println("\t text is 'This is also a button', let's check:" +
                driver.findElement(By.xpath("//input[@name='randomButton2']")).getAttribute("value"));
        System.out.println("\t text is 'This is also a button', let's check:" +
                driver.findElement(By.xpath("//input[@id='buttonId']")).getAttribute("value"));
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("Find element by id using css:");
        System.out.println("\t text is 'Heading_2 text', let's check:" +
                driver.findElement(By.cssSelector("#heading_2")).getText());


//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text is 'Test Text 1', let's check:" +
                driver.findElement(By.cssSelector("div#test1>p.test")).getText());
        System.out.println("\t text is 'Test Text 1', let's check:" +
                driver.findElement(By.cssSelector("p.test:nth-child(1)")).getText());

//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text is 'Test Text 2', let's check:" +
                driver.findElement(By.cssSelector("p.twoTest")).getText());
        System.out.println("\t text is 'Test Text 2', let's check:" +
                driver.findElement(By.cssSelector("div>p.twoTest")).getText());


//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text is 'Test Text 3', let's check:" +
                driver.findElement(By.cssSelector("div#test3>p.test:nth-child(1)")).getText());
        System.out.println("\t text is 'Test Text 3', let's check:" +
                driver.findElement(By.cssSelector("div#test3>p:nth-child(1)")).getText());

//        1-2 ways to find text: "This is also a button"
        System.out.println("\t text is 'This is also a button', let's check:" +
                driver.findElement(By.cssSelector("input[name='randomButton2']")).getAttribute("value"));
        System.out.println("\t text is 'This is also a button', let's check:" +
                driver.findElement(By.cssSelector("input#buttonId")).getAttribute("value"));

    }
}
