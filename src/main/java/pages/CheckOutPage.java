package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckOutPage extends BasePage {
    public CheckOutPage(Page page) {
        super(page);
    }

    Locator userFirstName = page.locator("#first-name");
    Locator userLastName = page.locator("#last-name");
    Locator userPostalCode = page.locator("#postal-code");
    Locator userCancelBuy = page.locator("a.cart_cancel_link.btn_secondary");

    public void checkOut(String userEnterUserName, String userEnterPassWord, String userEnterPostalCode) {
        setText(userFirstName, userEnterUserName);
        setText(userLastName, userEnterPassWord);
        setText(userPostalCode, userEnterPostalCode);
    }

    public void cancelCheckOut() {
        clickButton(userCancelBuy);
    }
}