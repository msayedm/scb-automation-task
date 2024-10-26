package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UserCartPage extends BasePage {
    public UserCartPage(Page page) {
        super(page);
    }

    Locator checkOutButton = page.locator("a.btn_action.checkout_button");
    Locator removeProduct = page.locator("button.btn_secondary.cart_button").nth(0);

    public void goToCheckOutPage() {
        clickButton(checkOutButton);
    }

    public void removeProducts() {
        clickButton(removeProduct);
        clickButton(removeProduct);
    }
}