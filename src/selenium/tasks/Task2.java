package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.FeedbackCheckPage;
import selenium.pages.FeedbackPage;
import selenium.pages.ThanksForFeedbackPage;

import java.io.File;

public class Task2 {
    WebDriver driver;
    static FeedbackPage feedbackPage;
    static FeedbackCheckPage feedbackCheckPage;
    static ThanksForFeedbackPage thanksForFeedbackPage;

    //TO FINISH
    // move assigned value to separate file
    // langValue - array instead of String?

    //ASSIGNED VALUES
    String nameValue = "Vasja";
    String ageValue = "20";
    String langValue = "FrenchChinese";
    String gendValue = "male";
    String opinValue = "Bad";
    String commentValue = "blah-blah-blah";


    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        feedbackPage = PageFactory.initElements(driver, FeedbackPage.class);
        feedbackCheckPage = PageFactory.initElements(driver, FeedbackCheckPage.class);
        thanksForFeedbackPage = PageFactory.initElements(driver,ThanksForFeedbackPage.class);

    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void forDebug()  throws Exception{
        feedbackPage.clickSubmit();
        feedbackCheckPage.checkButtonsFormatting();
    }


    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
        feedbackPage.checkThatFormIsClean();

//         check that the button send is blue with white letters
        feedbackPage.checkSendButtonFormatting();


    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        feedbackPage.clickSubmit();

//         check fields are empty or null
        feedbackCheckPage.checkFeedbackEmpty();

//         check button colors
//         (green with white letter and red with white letters)
        feedbackCheckPage.checkButtonsFormatting();
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:

//         fill the whole form, click "Send"
        feedbackPage.setName(nameValue);
        feedbackPage.setAge(ageValue);
        feedbackPage.setLanguage(langValue);
        feedbackPage.setGender(gendValue);
        feedbackPage.setDdOption(opinValue);
        feedbackPage.setComment(commentValue);

        feedbackPage.clickSubmit();

//         check fields are filled correctly
        feedbackCheckPage.checkFeedbackFilled();

//         check button colors
//         (green with white letter and red with white letters)
        feedbackCheckPage.checkButtonsFormatting();
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        feedbackPage.setName(nameValue);

//         click "Send"
        feedbackPage.clickSubmit();

//         click "Yes"
        feedbackCheckPage.clickYesButton();

//         check message text: "Thank you, NAME, for your feedback!"
        thanksForFeedbackPage.checkMessageContent();

//         color of text is white with green on the background
        thanksForFeedbackPage.checkMessageFormatting();
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        feedbackPage.clickSubmit();

//         click "Yes"
        feedbackCheckPage.clickYesButton();

//         check message text: "Thank you for your feedback!"
        thanksForFeedbackPage.checkEmptyMessageContent();

//         color of text is white with green on the background
        thanksForFeedbackPage.checkMessageFormatting();
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        feedbackPage.setName(nameValue);
        feedbackPage.setAge(ageValue);
        feedbackPage.setLanguage(langValue);
        feedbackPage.setGender(gendValue);
        feedbackPage.setDdOption(opinValue);
        feedbackPage.setComment(commentValue);


//         click "Send"
        feedbackPage.clickSubmit();

//         click "No"
        feedbackCheckPage.clickNoButton();

//         check fields are filled correctly
        feedbackPage.refreshValues(driver);
        feedbackPage.checkAllFields();




    }
}
