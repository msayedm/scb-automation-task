package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UserLoginPage extends BasePage {
    Locator userName = page.locator("#user-name");
    Locator passWord = page.locator("#password");
    Locator button = page.locator("#login-button");


    public UserLoginPage(Page page) {
        super(page);
    }

    public void login(String userEnterUserName, String userEnterPassWord) {
        setText(userName, userEnterUserName);
        setText(passWord, userEnterPassWord);
        clickButton(button);
    }

    public void clearData() {
        userName.clear();
        passWord.clear();
    }
}