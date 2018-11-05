import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevices");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/bollwar/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

//    @Test
//    public void Ex2()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannon find Search Wikipedia input",
//                5
//        );
//
//        WebElement search_string = waitForElementPresent(
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

//    @Test
//    public void Ex3()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannon find Search Wikipedia input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                "pineapple",
//                "Cannon find search string",
//                15
//        );
//
////   В данном шаге проверяется наличие 2й статьи в списке. Если она есть, значит найдено больше одной статьи, то есть "несколько статей"
//        waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index='1']"),
//                "Cannon find publications",
//                5
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Cannon find close button",
//                5
//        );
//
//        waitForElementNoPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index='1']"),
//                "The list is not empty",
//                5
//        );
//    }

//    @Test
//    public void Ex5()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannon find Search Wikipedia input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                "ferret",
//                "Cannon find search string",
//                15
//        );
//
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/page_list_item_container"),
//                "Mistake",
//                15
//        );
//
//        waitForElementAndClick(
//                By.xpath("//android.widgwt.ImageView[@content-desc='More options']"),
//                "Cannot find menu",
//                10
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find Add to reading list",
//                10
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/onboarding_button"),
//                "Cannot find button Got In",
//                10
//        );
//
//        waitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot find input field",
//                5
//        );
//
//        String name_of_folder = "My favorite articles";
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                name_of_folder,
//                "Cannot find input field",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='OK']"),
//                "Cannot find button OK",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find X link",
//                5
//        );
//
////      - - - - - - - - - - Добавление второй статьи - - - - - - - - - - - - - - - -
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannon find Search Wikipedia input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                "ferret",
//                "Cannon find search string",
//                15
//            );
//
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index='1']"),
//                "Mistake",
//                15
//            );
//
//        waitForElementAndClick(
//                By.xpath("//android.widgwt.ImageView[@content-desc='More options']"),
//                "Cannot find menu",
//                10
//            );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='Add to reading list']"),
//                "Cannot find Add to reading list",
//                10
//            );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='" + name_of_folder + "']"),
//                "Cannot find Add to reading list",
//                10
//        );
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot close article, cannot find X link",
//                5
//        );
////      - - - - - - - - - - Удаление статьи - - - - - - - - - - - - - - - -
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find My lists",
//                10
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='" + name_of_folder + "']"),
//                "Cannot find Add to reading list",
//                10
//        );
//
// // Убеждаемся, что в списке 2 статьи
//
//        String name_of_first_article = "Ferret";
//        String name_of_second_article = "Ferretti Group";
//
//
//
//        waitForElementPresent(
//                By.xpath("//*[@text='" + name_of_first_article + "']"),
//                "Cannot find article 'Ferret'",
//                5
//        );
//
//        waitForElementPresent(
//                By.xpath("//*[@text='" + name_of_second_article + "']"),
//                "Cannot find article 'Ferretti Group'",
//                5
//        );
//
//        swipeElementToLeft(
//                By.xpath("//*[@text='" + name_of_first_article + "']"),
//                "Cannot find article 'Ferret'"
//                );
//
//// Убеждаемся, что в списке осталась одна статья
//
//        waitForElementNoPresent(
//                By.xpath("//*[@text='" + name_of_first_article + "']"),
//                "Find article 'Ferret'",
//                5
//        );
//
//        waitForElementPresent(
//                By.xpath("//*[@text='" + name_of_second_article + "']"),
//                "Cannot find article 'Ferretti Group'",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='" + name_of_second_article + "'']"),
//                "Cannot find article 'Ferretti Group'",
//                5
//        );
//
//        waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']//*[@text='" + name_of_second_article + "']"),
//                "Cannot find article 'Ferretti Group'",
//                5
//        );
//
//    }

    @Test

    public void Ex6()
    {

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannon find Search Wikipedia input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Appium",
                "Cannon find search string",
                5
        );


        waitForElementAndClick(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Cannot find article",
                5
        );

        int find_title = assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text")
        );

        Assert.assertTrue(
                "Cannot find title",
                find_title > 0
        );

    }


    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private Boolean waitForElementNoPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
            by,
            error_message,
            10
        );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }
    
    private int assertElementPresent(By by)
    {
        List element = driver.findElements(by);
        return element.size();
    }

}
