package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FeedbackPage extends GenericSamplePage {

    //ASSIGNED VALUES
    String nameValue = "Vasja";
    String ageValue = "20";
    String langValue = "FrenchChinese";
    String gendValue = "male";
    String opinValue = "Bad";
    String commentValue = "blah-blah-blah";

    // WEB ELEMENTS

    //name input
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput;

    //age input
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;

    //checkboxes
    @FindBy(how = How.CLASS_NAME, using = "w3-check")
    private List<WebElement> checkBox;

    //Gender radio button
    @FindBy(how = How.CLASS_NAME, using = "w3-radio")
    private List<WebElement> gender;

    //How do you like us dropdown select
    @FindBy(how = How.CLASS_NAME, using = "w3-select")
    private WebElement dropdownElement;

    //comment field
    @FindBy(how = How.NAME, using = "comment")
    private WebElement comment;

    //send button
    @FindBy(how = How.CSS, using = "[type= 'submit']")
    private WebElement button;



    // GETTER/SETTERS/SERVICE METHODS
    public void setName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public String getName() {
        return nameInput.getAttribute("value");
    }

    public void setAge(String age) {
        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public String getAge() {
        return ageInput.getAttribute("value");
    }

    public void setLanguage(String choice) {
        if (choice.contains("English")) {
            checkBox.get(0).click();
        }
        if (choice.contains("French")) {
            checkBox.get(1).click();
        }
        if (choice.contains("Spanish")) {
            checkBox.get(2).click();
        }
        if (choice.contains("Chinese")) {
            checkBox.get(3).click();
        }

    }

    public String getLanguage() {
        String ret = "";
        for(WebElement box : checkBox) {
            if(box.isSelected()) {
                ret = ret + box.getAttribute("value");
            }
        }

        return ret;
    }


    public void setGender(String choice) {
        switch (choice) {
            case "male":
                gender.get(0).click();
                break;
            case "female":
                gender.get(1).click();
                break;
        }
    }

    public String getGender() {
        for (WebElement gen : gender) {
            if (gen.isSelected()) {
                return gen.getAttribute("value");
            }
        }
        return "";
    }

    public void setComment(String comm) {
        comment.clear();
        comment.sendKeys(comm);
    }

    public String getComment() {
        return comment.getAttribute("value");
    }

    public Select getDropDown() {
        return new Select(dropdownElement);
    }

    public void setDdOption(int value) {
        getDropDown().selectByIndex(value);
    }

    public void setDdOption(String value) {
        getDropDown().selectByVisibleText(value);
    }

    public String getDdOption() {
        return getDropDown().getFirstSelectedOption().getText();
    }


    public void clickSubmit() {
        button.click();
    }

    //Refresh all element values taken from the input page
    //copied from Amiran :)
    public void refreshValues(WebDriver driver) {
        nameInput = driver.findElement(By.id("fb_name"));
        ageInput = driver.findElement(By.id("fb_age"));
        checkBox = driver.findElements(By.className("w3-check"));
        gender = driver.findElements(By.className("w3-radio"));
        dropdownElement = driver.findElement(By.className("w3-select"));
        comment = driver.findElement(By.name("comment"));
        button = driver.findElement(By.cssSelector("[type='submit'"));
    }

    //CHECK METHODS

    public void checkNoCheckboxesSelected() {
        for (WebElement box : checkBox) {
            assertFalse(box.isSelected());
        }
    }

    public void checkNoRadioButtonSelected() {
        for (WebElement gen : gender) {
            if ((gen.getAttribute("value").equals("male")) || (gen.getAttribute("value").equals("female"))) {
                assertFalse(gen.isSelected());
            }
        }
    }

    public void checkThatFormIsClean() {
        checkPageHeaderText("Give us your feedback!");
        assertEquals(nameInput.getAttribute("placeholder"), "Name");
        assertEquals(nameInput.getAttribute("value"), "");
        assertEquals(ageInput.getAttribute("placeholder"), "Age");
        assertEquals(ageInput.getAttribute("value"), "");
        checkNoCheckboxesSelected();
        checkNoRadioButtonSelected();
        assertEquals("Choose your option", getDdOption());
        assertEquals(comment.getText(), "");

    }

    public void checkSendButtonFormatting() {
        assertEquals("rgba(33, 150, 243, 1)", button.getCssValue("background-color"));
        assertEquals("rgb(255, 255, 255)", button.getCssValue("text-decoration-color"));
    }

    public void checkAllFields(){
        assertEquals(getName(),nameValue);
        assertEquals(getAge(), ageValue);
        assertEquals(getLanguage(),langValue);
        assertEquals(getGender(),gendValue);
        assertEquals(getDdOption(),opinValue);
        assertEquals(getComment(), commentValue);

    }
}
