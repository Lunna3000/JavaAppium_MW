package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUi;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "My favorite articles";
    private static final String name_of_first_article_android = "Ferret";
    private static final String name_of_first_article_ios = "Ferret Subspecies of mammal";
    private static final String name_of_second_article = "Ferret health";

    @Test
    public void testEx5()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("ferret");

        if(Platform.getInstance().isAndroid()){
            SearchPageObject.waitForSearchResultOnIndexOrName("0");
        } else {
            SearchPageObject.waitForSearchResultOnIndexOrName(name_of_first_article_ios);
        }

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();


//      - - - - - - - - - - Добавление второй статьи - - - - - - - - - - - - - - - -

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("ferret");

        if(Platform.getInstance().isAndroid()){
            SearchPageObject.waitForSearchResultOnIndexOrName("1");
        } else {
            SearchPageObject.waitForSearchResultOnIndexOrName(name_of_second_article);
        }

        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();


//      - - - - - - - - - - Удаление статьи - - - - - - - - - - - - - - - -

        NavigationUi NavigationUi = NavigationUIFactory.get(driver);
        NavigationUi.clickMyList();
        MyListPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder);
        }

        // Убеждаемся, что в списке 2 статьи и удаляем одну

        if(Platform.getInstance().isAndroid()){
            SearchPageObject.waitForSearchArticleOnName(name_of_first_article_android);
        } else {
            SearchPageObject.waitForSearchArticleOnName(name_of_first_article_ios);
        }

        SearchPageObject.waitForSearchArticleOnName(name_of_second_article);

        if(Platform.getInstance().isAndroid()){
            MyListPageObject.swipeByArticleToDelete(name_of_first_article_android);
        } else {
            MyListPageObject.swipeByArticleToDelete(name_of_first_article_ios);
        }

// Убеждаемся, что в списке осталась одна статья и проверяем ее

        if(Platform.getInstance().isAndroid()){
            SearchPageObject.waitForSearchArticleOnNameDisappear(name_of_first_article_android);
        } else {
            SearchPageObject.waitForSearchArticleOnNameDisappear(name_of_first_article_ios);
        }

        SearchPageObject.waitForSearchArticleOnName(name_of_second_article);
        SearchPageObject.waitForSearchArticleOnNameAndClick(name_of_second_article);

        if(Platform.getInstance().isAndroid()){
            SearchPageObject.waitForSearchTextTitle(name_of_second_article);
        } else {
            SearchPageObject.waitForSearchTitle();
        }
    }

}
