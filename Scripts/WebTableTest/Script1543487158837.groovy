import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.By.ByName as ByName
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

WebUI.navigateToUrl('http://toolsqa.com/')

WebUI.maximizeWindow()

Thread.sleep(1000)

WebDriver driver = DriverFactory.getWebDriver()

Actions action = new Actions(driver);

action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'DEMO SITES')]")));

action.build().perform();

Thread.sleep(100);

driver.findElement(By.xpath("//span[contains(text(),'Automation Practice Table')]")).click();

String expectedText = 'Burj Khalifa'

List<String> rowValues = driver.findElements(By.xpath('//table/tbody/tr/th'))

for (int i = 0; i < rowValues.size(); i++) {
    if (rowValues.get(i).getText().contains(expectedText)) {
        List<String> expectedRowValues = driver.findElements(By.xpath(('//table/tbody/tr[' + (i + 1)) + ']/td'))

        for (WebElement expectedRowValue : expectedRowValues) {
            System.out.println(expectedRowValue.getText())
        }
        
        break
    }
}

WebUI.closeBrowser()