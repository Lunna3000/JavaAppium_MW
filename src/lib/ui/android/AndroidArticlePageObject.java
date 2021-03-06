package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject
{
  static {
      OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
      OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
      ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
      MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
      MY_LIST_NAME_SUBSTRING_TPL = "xpath://*[@text='{FOLDER_NAME}']";
      MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
      CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
  }

  public AndroidArticlePageObject(AppiumDriver driver)
  {
      super(driver);
  }

}
