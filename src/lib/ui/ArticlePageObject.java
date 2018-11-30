package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_NAME_SUBSTRING_TPL,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON;

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

   public void addArticlesToMySaved()
   {
       this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
   }

}
