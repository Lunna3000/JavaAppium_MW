package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{

    static {
        SEARH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index='{SUBSTRING}']";
        SEARCH_ARTICLE_TPL = "xpath://*[@text='{NAME_ARTICLE}']";
        SEARCH_TEXT_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text']//*[@text='{TITLE}']";
        SEARCH_TITLE_TPL = "id:org.wikipedia:id/view_page_title_text";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
    }

    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
