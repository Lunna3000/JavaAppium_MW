package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
//        MY_LIST_NAME_SUBSTRING_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        CLOSE_ARTICLE_BUTTON = "id:Back";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
