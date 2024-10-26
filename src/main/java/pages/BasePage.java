package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    protected static Page page;
    

    public BasePage(Page page) {
        this.page = page;
    }

    protected static void clickButton(Locator locator) {
        locator.click();
    }

    protected static void setText(Locator locator, String userName) {
        locator.type(userName, new Locator.TypeOptions().setDelay(100));
    }
}