package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListPageObject extends MainPageObject {

    protected static String
    FOLDER_BY_NAME_TPL,
    ARTICLE_BY_TITLE_TPL;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find Add to reading list",
                10
        );
    }


    public void swipeByArticleToDelete(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find article " + article_title
        );

        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article", 10);
        }
    }
}
