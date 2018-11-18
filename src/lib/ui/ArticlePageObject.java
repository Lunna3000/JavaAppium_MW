package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject
{
    private static final String
    OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_NAME_SUBSTRING_TPL = "//*[@text='{FOLDER_NAME}']",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";

   public ArticlePageObject(AppiumDriver driver)
   {
       super(driver);
   }

    private static String myListName(String name_of_folder)
    {
        return MY_LIST_NAME_SUBSTRING_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }


   public void addArticleToMyList(String name_of_folder)
   {

       this.waitForElementAndClick(
               By.xpath(OPTIONS_BUTTON),
               "Cannot find menu",
               10
       );

       this.waitForElementAndClick(
               By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
               "Cannot find Add to reading list",
               10
       );

       this.waitForElementAndClick(
               By.id(ADD_TO_MY_LIST_OVERLAY),
               "Cannot find button Got In",
               10
       );

       this.waitForElementAndClear(
               By.id(MY_LIST_NAME_INPUT),
               "Cannot find input field",
               5
       );


       this.waitForElementAndSendKeys(
               By.id(MY_LIST_NAME_INPUT),
               name_of_folder,
               "Cannot find input field",
               5
       );

       this.waitForElementAndClick(
               By.xpath(MY_LIST_OK_BUTTON),
               "Cannot find button OK",
               5
       );
   }

   public void findArticleInMyList(String name_of_folder)
   {
       this.waitForElementAndClick(
               By.xpath(OPTIONS_BUTTON),
               "Cannot find menu",
               10
       );

       this.waitForElementAndClick(
               By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
               "Cannot find Add to reading list",
               10
       );

       String search_result_xpath = myListName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(search_result_xpath),
                "Cannot find search result",
                15);
   }

   public void closeArticle()
   {
       this.waitForElementAndClick(
               By.xpath(CLOSE_ARTICLE_BUTTON),
               "Cannot close article, cannot find X link",
               5
       );
   }

}
