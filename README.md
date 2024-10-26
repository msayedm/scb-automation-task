This project automates a set of end-to-end test cases on an e-commerce application using Playwright with Java. The primary scenarios covered include login, product sorting, adding and removing items from the cart, and checkout flow. The project follows the Page Object Model (POM) design pattern and utilizes TestNG as the test framework.

The project automates the following workflow:
- Login
- Sorting the products
- Add products from landing page
- Remove product from landing page
- View cart products
- Fill Checkout form
- Canceling checkout
- Remove products from cart
- Checkout of empty cart
- Logout


Technical Stack:
- Language: Java
- Framework: TestNG
- Automation Tool: Playwright
- Design Pattern: Page Object Model (POM)


Test Execution:
The full regression suite can be executed through the testng.xml file. This file is configured to include all relevant test cases for the specified scenarios.

Steps to Run the Test Suite:
- Clone the repository to your local machine.
- Ensure that Maven is installed and configured on your system.
- Run the TestNG suite from the testng.xml file in your IDE or execute it from the command line:mvn test -DsuiteXmlFile=testng.xml

Trace, Screenshots, and Video:

Instead of a logger, this project captures screenshoots and videos

Trace File (trace.zip): A comprehensive trace of each test run, saved as trace.zip for debugging purposes.

To view the trace file, use the following command from the root directory:mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="show-trace trace.zip"


Project Structure:

The project is organized using the Page Object Model, where each page in the application is represented by a corresponding class. The primary folders and files include:

src/main/java: Contains page classes.

src/test/java: Contains TestNG test classes.

testng.xml: Configures and runs the regression suite.
