package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;

public class FeedbackCheckPage extends GenericSamplePage {

    //ASSIGNED VALUES
    String nameValue = "Vasja";
    String ageValue = "20";
    String langValue = "French,Chinese";
    String gendValue = "male";
    String opinValue = "Bad";
    String commentValue = "blah-blah-blah";


    // WEB ELEMENTS

    //name
    @FindBy(how = How.ID, using = "name")
    private WebElement enteredName;

    //age
    @FindBy(how = How.ID, using = "age")
    private WebElement enteredAge;

    //language
    @FindBy(how = How.ID, using = "language")
    private WebElement enteredLanguage;

    //gender
    @FindBy(how = How.ID, using = "gender")
    private WebElement enteredGender;

    //opinion
    @FindBy(how = How.ID, using = "option")
    private WebElement enteredOpinion;

    //comment
    @FindBy(how = How.ID, using = "comment")
    private WebElement enteredComment;

    //buttonYes
    @FindBy(how = How.CLASS_NAME, using = "w3-green")
    private WebElement buttonYes;

    //buttonNo
    @FindBy(how = How.CLASS_NAME, using = "w3-red")
    private WebElement buttonNo;


    // GETTER/SETTERS/SERVICE METHODS
    public String getEnteredName(){
        return enteredName.getText();
    }
    public String getEnteredAge(){
        return enteredAge.getText();
    }
    public String getEnteredLanguage(){
        return enteredLanguage.getText();
    }
    public String getEnteredGender(){
        return enteredGender.getText();
    }
    public String getEnteredOpinion(){
        return enteredOpinion.getText();
    }
    public String getEnteredComment(){
        return enteredComment.getText();
    }
    public void clickYesButton() {
        buttonYes.click();
    }
    public void clickNoButton() {
        buttonNo.click();
    }

    // CHECKS
    public void checkFeedbackEmpty(){

        assertEquals(getEnteredName(),"");
        assertEquals(getEnteredAge(),"");
        assertEquals(getEnteredLanguage(),"");
        assertEquals(getEnteredGender(),"null");
        assertEquals(getEnteredOpinion(),"null");
        assertEquals(getEnteredComment(),"");
    }

    public void checkFeedbackFilled(){
        assertEquals(getEnteredName(),nameValue);
        assertEquals(getEnteredAge(), ageValue);
        assertEquals(getEnteredLanguage(),langValue);
        assertEquals(getEnteredGender(),gendValue);
        assertEquals(getEnteredOpinion(),opinValue);
        assertEquals(getEnteredComment(),commentValue);
    }

    public void checkButtonsFormatting() {
        //YesButton
        assertEquals("rgba(76, 175, 80, 1)", buttonYes.getCssValue("background-color"));
        assertEquals("rgb(255, 255, 255)", buttonYes.getCssValue("text-decoration-color"));
        //NoButton
        assertEquals("rgba(244, 67, 54, 1)", buttonNo.getCssValue("background-color"));
        assertEquals("rgb(255, 255, 255)", buttonNo.getCssValue("text-decoration-color"));
    }

}

