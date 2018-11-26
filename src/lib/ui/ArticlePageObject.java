package lib.ui;

import io.appium.java_client.AppiumDriver;

public class ArticlePageObject extends MainPageObject
{
    private static final String
    OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
    MY_LIST_NAME_SUBSTRING_TPL = "xpath://*[@text='{FOLDER_NAME}']",
    MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
    CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

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
               OPTIONS_BUTTON,
               "Cannot find menu",
               10
       );

       this.waitForElementAndClick(
               OPTIONS_ADD_TO_MY_LIST_BUTTON,
               "Cannot find Add to reading list",
               10
       );

       this.waitForElementAndClick(
               ADD_TO_MY_LIST_OVERLAY,
               "Cannot find button Got In",
               10
       );

       this.waitForElementAndClear(
               MY_LIST_NAME_INPUT,
               "Cannot find input field",
               5
       );


       this.waitForElementAndSendKeys(
               MY_LIST_NAME_INPUT,
               name_of_folder,
               "Cannot find input field",
               5
       );

       this.waitForElementAndClick(
               MY_LIST_OK_BUTTON,
               "Cannot find button OK",
               5
       );
   }

   public void findArticleInMyList(String name_of_folder)
   {
       this.waitForElementAndClick(
               OPTIONS_BUTTON,
               "Cannot find menu",
               10
       );

       this.waitForElementAndClick(
               OPTIONS_ADD_TO_MY_LIST_BUTTON,
               "Cannot find Add to reading list",
               10
       );

       String search_result_xpath = myListName(name_of_folder);
        this.waitForElementAndClick(
                search_result_xpath,
                "Cannot find search result",
                15);
   }

   public void closeArticle()
   {
       this.waitForElementAndClick(
               CLOSE_ARTICLE_BUTTON,
               "Cannot close article, cannot find X link",
               5
       );
   }

}
