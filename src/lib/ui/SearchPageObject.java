package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
        SEARH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]",
        SEARCH_INPUT = "id:org.wikipedia:id/search_src_text",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index='{SUBSTRING}']",
        SEARCH_ARTICLE_TPL = "xpath://*[@text='{NAME_ARTICLE}']",
        SEARCH_TEXT_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text']//*[@text='{TITLE}']",
        SEARCH_TITLE_TPL = "id:org.wikipedia:id/view_page_title_text",
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";

    public  SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchArticle(String substring)
    {
        return SEARCH_ARTICLE_TPL.replace("{NAME_ARTICLE}", substring);
    }

    private static String getResultSearchTitle(String substring)
    {
        return SEARCH_TEXT_TITLE_TPL.replace("{TITLE}", substring);
    }
    /* TEMPLATES METHODS */

//    Переходим в поиск
    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARH_INIT_ELEMENT, "Cannon find and click search init element", 5);
        this.waitForElementPresent(SEARH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 5);
    }

//    Пишем в поиске текст
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 15);
    }

//    Результат поиска
    public void waitForSearchResultOnIndex(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(
                search_result_xpath,
                "Cannot find search result",
                15);
    }

    public void waitForSearchResultOnIndexDisappear(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementNoPresent(
                search_result_xpath,
                "The list is not empty",
                15);
    }

    public void waitForSearchArticleOnName(String substring)
    {
        String search_result_xpath = getResultSearchArticle(substring);

        this.waitForElementPresent(
                search_result_xpath,
                "Cannot find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchArticleOnNameDisappear(String substring)
    {
        String search_result_xpath = getResultSearchArticle(substring);
        this.waitForElementNoPresent(
                search_result_xpath,
                "Find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchArticleOnNameAndClick(String substring)
    {
        String search_result_xpath = getResultSearchArticle(substring);

        this.waitForElementAndClick(
                search_result_xpath,
                "Cannot find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchTextTitle(String substring)
    {
        String search_result_xpath = getResultSearchTitle(substring);

        this.waitForElementPresent(
                search_result_xpath,
                "Cannot find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchTitle()
    {
        this.assertElementPresent(
                SEARCH_TITLE_TPL,
                "Cannot find title"
        );
    }




//    Очищаем строку поиска
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannon find close button", 5);
    }



}
