package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.nio.file.Paths;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void start() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(screenWidth, screenHeight).setRecordVideoDir(Paths.get("./videos/")));
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));

        page = context.newPage();
        page.navigate("https://www.saucedemo.com/v1/index.html");
    }

    @AfterSuite
    public void quit() {
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("./trace.zip")));
        page.close();
        context.close();
        playwright.close();
    }
}
