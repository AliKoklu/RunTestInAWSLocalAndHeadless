package Utilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlRequest;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlResponse;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverClass {

    private static RemoteWebDriver driver;

    private static WebDriver driverLocal;

    private static ChromeDriver headLess;

    public static WebDriver GetDriver() {

        System.out.println(driver);
        System.out.println(driverLocal);
        System.out.println(driverLocal);

        if(driver == null && driverLocal == null && headLess == null ) {
            if (GetProperty.init_properties("where").equalsIgnoreCase("local")) {

                ChromeDriverManager.chromedriver().setup();

                driverLocal = new ChromeDriver();

                System.out.println("in the local");
                return driverLocal;
            } else if (GetProperty.init_properties("where").equalsIgnoreCase("AWS")) {

                String arnProject = "arn:aws:devicefarm:us-west-2:381466740250:testgrid-project:ac4bc6fa-5ea3-44c4-ab6a-f765969094e1";

                DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();

                CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder().expiresInSeconds(300)
                        .projectArn(arnProject).build();

                CreateTestGridUrlResponse response = client.createTestGridUrl(request);

                URL testGridUrl = null;

                try {
                    testGridUrl = new URL(response.url());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

                desiredCapabilities.setCapability("browserName", GetProperty.init_properties("browserName"));
                desiredCapabilities.setCapability("browserVersion", GetProperty.init_properties("browserVersion"));
                desiredCapabilities.setCapability("platform", GetProperty.init_properties("platform"));

                driver = new RemoteWebDriver(testGridUrl, desiredCapabilities);

                driver.get(GetProperty.init_properties("URL"));

                return driver;
            } else {

                System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependency\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--allow-running-insecure-content");

                headLess = new ChromeDriver(options);


                return headLess;
            }
        }else if(GetProperty.init_properties("where").equalsIgnoreCase("local")){

            System.out.println("second local");

            return driverLocal;
        }else if(GetProperty.init_properties("where").equalsIgnoreCase("AWS")){
            return driver;
        }else {
            System.out.println("in the html ");
            return headLess;
        }

    }
}
