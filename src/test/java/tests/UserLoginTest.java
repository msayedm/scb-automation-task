package tests;

import org.testng.annotations.Test;
import pages.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UserLoginTest extends BaseTest {
    UserLoginPage userPage;
    InventoryPage invPage;
    UserCartPage userCart;
    CheckOutPage userCheckOut;
    LogOutPage logOutPage;

    @Test(priority = 1)
    public void userCanNotLoginWithWrongData() {
        userPage = new UserLoginPage(page);
        userPage.login("locked_out_user", "secret_sauce");
        assertThat(page.locator(".error-button")).isVisible();
        userPage.clearData();
    }

    @Test(priority = 2)
    public void userCanLoginWithRightData() {
        userPage = new UserLoginPage(page);
        userPage.login("standard_user", "secret_sauce");
        assertThat(page).hasURL("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test(priority = 3)
    public void userCanSortByHighToLow() {
        invPage = new InventoryPage(page);
        invPage.userSorting("Price (high to low)");
    }

    @Test(priority = 4)
    public void userCanSortByLowToHigh() {
        invPage = new InventoryPage(page);
        invPage.userSorting("Price (low to high)");
    }

    @Test(priority = 5)
    public void userAddItem() {
        invPage = new InventoryPage(page);
        invPage.addItem();
        assertThat(page.locator(".btn_secondary.btn_inventory").nth(0)).isVisible();
    }

    @Test(priority = 6)
    public void userRemoveItem() {
        invPage = new InventoryPage(page);
        invPage.removeItem();
        assertThat(page.locator("button.btn_primary.btn_inventory").nth(0)).isVisible();
    }

    @Test(priority = 7)
    public void userOpenCart() {
        invPage = new InventoryPage(page);
        invPage.openCart();
        assertThat(page.locator(".cart_item").nth(0)).isVisible();
    }

    @Test(priority = 8)
    public void userGoToCheckOut() {
        userCart = new UserCartPage(page);
        userCart.goToCheckOutPage();
        assertThat(page).hasURL("https://www.saucedemo.com/v1/checkout-step-one.html");
    }

    @Test(priority = 9)
    public void userFillCheckOutData() {
        userCheckOut = new CheckOutPage(page);
        userCheckOut.checkOut("Test", "Test", "1111");
    }

    @Test(priority = 10)
    public void userCancelBuy() throws InterruptedException {
        userCheckOut = new CheckOutPage(page);
        userCheckOut.cancelCheckOut();
        assertThat(page).hasURL("https://www.saucedemo.com/v1/cart.html");

    }

    @Test(priority = 11)
    public void userEmptyCart() throws InterruptedException {
        userCart = new UserCartPage(page);
        userCart.removeProducts();
        assertThat(page).hasURL("https://www.saucedemo.com/v1/cart.html");

    }

    @Test(priority = 12)
    public void userCheckOutOfEmptyCart() {
        userCart = new UserCartPage(page);
        userCart.goToCheckOutPage();
        assertThat(page).hasURL("https://www.saucedemo.com/v1/checkout-step-one.html");
    }

    @Test(priority = 13)
    public void userLogOut() {
        logOutPage = new LogOutPage(page);
        logOutPage.openSideMenu();
        logOutPage.logOut();
        assertThat(page).hasURL("https://www.saucedemo.com/v1/index.html");
    }
}