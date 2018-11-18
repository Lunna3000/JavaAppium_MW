package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

//    @Test
//    public void testEx2()
//    {
//
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSearchInput();
//
//        WebElement search_string = MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Cannon find search string",
//                5
//        );
//
//        String text_in_line = search_string.getAttribute("text");
//
//        Assert.assertEquals(
//                "Cannon find Search...",
//                "Search…",
//                text_in_line
//        );
//    }


    @Test
    public void testEx3()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("pineapple");

//   В данном шаге проверяется наличие 2й статьи в списке. Если она есть, значит найдено больше одной статьи, то есть "несколько статей"
        SearchPageObject.waitForSearchResultOnIndex("1");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForSearchResultOnIndexDisappear("1");

    }


    @Test
    public void testEx6()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.waitForSearchResultOnIndex("0");
        SearchPageObject.waitForSearchTitle();
    }


}
