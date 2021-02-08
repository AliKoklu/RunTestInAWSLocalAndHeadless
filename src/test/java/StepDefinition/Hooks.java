package StepDefinition;

import Pages.Page;
import Utilities.DriverClass;
import Utilities.GetProperty;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    WebDriver driver;
    Page page = new Page();


    @Before
    public void BeforeMethod(){
        driver = DriverClass.GetDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        page.input_user_login.sendKeys(GetProperty.init_properties("username"));
        page.input_user_password.sendKeys(GetProperty.init_properties("password"));
        page.signUnButton.click();

        if(GetProperty.init_properties("where").equalsIgnoreCase("local")||GetProperty.init_properties("where").equalsIgnoreCase("AWS")) {
            page.button_advanced.click();
            page.button_proceed_link.click();
        }
    }

    @After
    public void AfterMethod(Scenario scenario) throws IOException {


        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }



        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }
}
