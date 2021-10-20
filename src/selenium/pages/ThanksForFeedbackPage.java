package selenium.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class ThanksForFeedbackPage extends GenericSamplePage {

    //ASSIGNED VALUES
    String nameValue = "Vasja";

    // WEB ELEMENTS

    @FindBy(how = How.CLASS_NAME, using = "w3-green")
    private WebElement message;

    // GETTER/SETTERS/SERVICE METHODS
    public String getMessageText() {
        return message.getText();
    }

    // CHECKS
    public void checkMessageContent() {
        assertEquals(getMessageText(),"Thank you, " + nameValue + ", for your feedback!");
        System.out.println(getMessageText());
    }
    public void checkEmptyMessageContent() {
        assertEquals(getMessageText(),"Thank you for your feedback!");
        System.out.println(getMessageText());
    }


    public void checkMessageFormatting(){
        assertEquals("rgba(76, 175, 80, 1)", message.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", message.getCssValue("color"));
    }


}
