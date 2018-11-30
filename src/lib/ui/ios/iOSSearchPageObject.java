package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_ARTICLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{NAME_ARTICLE}')]";
        SEARCH_TITLE_TPL = "id:Ferret health";
        SEARCH_CANCEL_BUTTON = "id:Close";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
