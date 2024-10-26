package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LogOutPage extends BasePage {
    public LogOutPage(Page page) {
        super(page);
    }

    Locator sideMenu = page.locator("button[style*='width: 100%'][style*='height: 100%'][style*='opacity: 0']");
    Locator logOut = page.locator("#logout_sidebar_link");

    public void openSideMenu() {
        clickButton(sideMenu);
    }

    public void logOut() {
        clickButton(logOut);
    }
}