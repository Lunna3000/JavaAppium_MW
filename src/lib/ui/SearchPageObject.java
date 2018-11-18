package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
        SEARH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
        SEARCH_INPUT = "org.wikipedia:id/search_src_text",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index='{SUBSTRING}']",
        SEARCH_ARTICLE_TPL = "//*[@text='{NAME_ARTICLE}']",
        SEARCH_TEXT_TITLE_TPL = "//*[@resource-id='org.wikipedia:id/view_page_title_text']//*[@text='{TITLE}']",
        SEARCH_TITLE_TPL = "org.wikipedia:id/view_page_title_text",
        SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn";

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
        this.waitForElementAndClick(By.xpath(SEARH_INIT_ELEMENT), "Cannon find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
    }

//    Пишем в поиске текст
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Cannot find and type into search input", 15);
    }

//    Результат поиска
    public void waitForSearchResultOnIndex(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(
                By.xpath(search_result_xpath),
                "Cannot find search result",
                15);
    }

    public void waitForSearchResultOnIndexDisappear(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementNoPresent(
                By.xpath(search_result_xpath),
                "The list is not empty",
                15);
    }

    public void waitForSearchArticleOnName(String substring)
    {
        String search_result_xpath = getResultSearchArticle(substring);

        this.waitForElementPresent(
                By.xpath(search_result_xpath),
                "Cannot find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchArticleOnNameDisappear(String substring)
    {
        String search_result_xpath = getResultSearchArticle(substring);
        this.waitForElementNoPresent(
                By.xpath(search_result_xpath),
                "Find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchArticleOnNameAndClick(String substring)
    {
        String search_result_xpath = getResultSearchArticle(substring);

        this.waitForElementAndClick(
                By.xpath(search_result_xpath),
                "Cannot find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchTextTitle(String substring)
    {
        String search_result_xpath = getResultSearchTitle(substring);

        this.waitForElementPresent(
                By.xpath(search_result_xpath),
                "Cannot find article" + search_result_xpath,
                5
        );
    }

    public void waitForSearchTitle()
    {
        this.assertElementPresent(
                By.id(SEARCH_TITLE_TPL),
                "Cannot find title"
        );
    }




//    Очищаем строку поиска
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannon find close button", 5);
    }



}
