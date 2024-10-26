package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class InventoryPage extends BasePage {
    Locator addFirstProduct = page.locator("button.btn_primary.btn_inventory").nth(0);
    Locator addSecondProduct = page.locator("button.btn_primary.btn_inventory").nth(1);
    Locator addLastProduct = page.locator("button.btn_primary.btn_inventory").nth(2);
    Locator removeProduct = page.locator(".btn_secondary.btn_inventory").nth(0);
    Locator sorting = page.locator(".product_sort_container");
    Locator cart = page.locator("span.fa-layers-counter.shopping_cart_badge");

    public InventoryPage(Page page) {
        super(page);
    }

    public void userSorting(String label) {
        sorting.selectOption(new SelectOption().setLabel(label)); //"Price (high to low)"
    }

    public void addItem() {
        clickButton(addFirstProduct);
        clickButton(addSecondProduct);
        clickButton(addLastProduct);
    }

    public void removeItem() {
        clickButton(removeProduct);
    }

    public void openCart() {
        clickButton(cart);
    }
}