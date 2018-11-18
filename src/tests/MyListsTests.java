package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListPageObject;
import lib.ui.NavigationUi;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {


    @Test
    public void testEx5()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("ferret");
        SearchPageObject.waitForSearchResultOnIndex("0");

        String name_of_folder = "My favorite articles";
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();


//      - - - - - - - - - - Добавление второй статьи - - - - - - - - - - - - - - - -

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("ferret");
        SearchPageObject.waitForSearchResultOnIndex("1");
        ArticlePageObject.findArticleInMyList(name_of_folder);
        ArticlePageObject.closeArticle();


//      - - - - - - - - - - Удаление статьи - - - - - - - - - - - - - - - -

        NavigationUi NavigationUi = new NavigationUi(driver);
        NavigationUi.clickMyList();
        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);

        // Убеждаемся, что в списке 2 статьи и удаляем одну

        String name_of_first_article = "Ferret";
        String name_of_second_article = "Ferretti Group";

        SearchPageObject.waitForSearchArticleOnName(name_of_first_article);
        SearchPageObject.waitForSearchArticleOnName(name_of_second_article);

        MyListPageObject.swipeByArticleToDelete(name_of_first_article);

// Убеждаемся, что в списке осталась одна статья и проверяем ее

        SearchPageObject.waitForSearchArticleOnNameDisappear(name_of_first_article);
        SearchPageObject.waitForSearchArticleOnName(name_of_second_article);
        SearchPageObject.waitForSearchArticleOnNameAndClick(name_of_second_article);
        SearchPageObject.waitForSearchTextTitle(name_of_second_article);
    }

}
