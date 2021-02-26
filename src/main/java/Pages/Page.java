package Pages;

import Utilities.DriverClass;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page {


    WebDriver driver;

    public Page(){

        // Page factory is getting the driver from the driver class and it is sharing the driver with the elements in this class
        // in this way we are able to work with one browser and able to find the elements in the web page
        driver = DriverClass.GetDriver();
        PageFactory.initElements( driver , this );

    }

//    login page
    @FindBy(id = "user_login")
    public WebElement input_user_login;

    @FindBy(id = "user_password")
    public WebElement input_user_password;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signUnButton;

    @FindBy(id = "details-button")
    public WebElement button_advanced;

    @FindBy(id = "proceed-link")
    public WebElement button_proceed_link;



//    Menu

    @FindBy(linkText = "Account Summary")
    public WebElement button_Account_Summary;

    @FindBy(linkText = "Account Activity")
    public WebElement button_Account_Activity;

    @FindBy(xpath = "//a[text()='Transfer Funds']")
    public WebElement button_Transfer_Funds;

    @FindBy(linkText = "Pay Bills")
    public WebElement button_Pay_Bills;

    @FindBy(linkText = "My Money Map")
    public WebElement button_My_Money_Map;

    @FindBy(linkText = "Online Statements")
    public WebElement button_Online_Statements;

//  TransferFounds

    @FindBy(id = "tf_fromAccountId")
    public WebElement dropdown_tf_fromAccountId;

    @FindBy(id = "tf_toAccountId")
    public WebElement dropdown_tf_toAccountId;

    @FindBy(id = "tf_amount")
    public WebElement input_tf_amount;

    @FindBy(id = "tf_description")
    public WebElement input_tf_description;

    @FindBy(id = "btn_submit")
    public WebElement button_btn_submit;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement text_Success_message;

// Pay bills

    @FindBy(xpath = "//a[text()='Pay Bills']")
    public WebElement Button_Pay_Bills;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    public WebElement Button_Add_New_Payee;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement Button_Purchase_Foreign_Currency;

    @FindBy(id = "add_new_payee")
    public WebElement Button_add_inthe_new_payee;

    @FindBy(id = "np_new_payee_name")
    public WebElement input_Payee_Name;

    @FindBy(id = "np_new_payee_address")
    public WebElement input_np_new_payee_address;

    @FindBy(id = "np_new_payee_account")
    public WebElement input_np_new_payee_account;

    @FindBy(id = "np_new_payee_details")
    public WebElement input_np_new_payee_details;

    @FindBy(id = "alert_content")
    public WebElement text_success_message_addNewPayee;

    @FindBy(id = "sp_payee")
    public WebElement dropdown_payee;

    @FindBy(id = "sp_account")
    public WebElement dropdown_sp_account;

    @FindBy(id = "sp_amount")
    public WebElement input_sp_amount;

    @FindBy(id = "sp_date")
    public WebElement input_sp_date;

    @FindBy(id = "sp_description")
    public WebElement input_sp_description;

    @FindBy(id = "pay_saved_payees")
    public WebElement button_pay_saved_payees;

    @FindBy(id = "pc_currency")
    public WebElement dropdown_pc_currency;

    @FindBy(id = "pc_amount")
    public WebElement input_pc_amount;

    @FindBy(id = "pc_inDollars_true")
    public WebElement radioButton_pc_inDollars_true;

    @FindBy(id = "purchase_cash")
    public WebElement button_purchase_cash;




    public void handleDropdown(String elementName ,String whichData){

        Select select;

        WebElement element = null;

        if(elementName.equalsIgnoreCase("dropdown_tf_toAccountId")){
            element = dropdown_tf_toAccountId;
        }else if(elementName.equalsIgnoreCase("dropdown_tf_fromAccountId")){
            element = dropdown_tf_fromAccountId;
        }else if(elementName.equalsIgnoreCase("dropdown_payee")){
            element = dropdown_payee;
        }else if(elementName.equalsIgnoreCase("dropdown_sp_account")){
            element = dropdown_sp_account;
        }else if(elementName.equalsIgnoreCase("dropdown_pc_currency")){
            element = dropdown_pc_currency;
        }

        select = new Select(element);

        select.selectByIndex(Integer.parseInt(whichData));
    }

    public void ClickFunction(String elementName){

        WebElement element = null;

        if(elementName.equalsIgnoreCase("signUnButton")){
            element = signUnButton;
        }else if(elementName.equalsIgnoreCase("button_Account_Summary")){
            element = button_Account_Summary;
        }else if(elementName.equalsIgnoreCase("button_Account_Activity")){
            element = button_Account_Activity;
        }else if(elementName.equalsIgnoreCase("button_Transfer_Funds")){
            element = button_Transfer_Funds;
        }else if(elementName.equalsIgnoreCase("button_Pay_Bills")){
            element = button_Pay_Bills;
        }else if(elementName.equalsIgnoreCase("button_My_Money_Map")){
            element = button_My_Money_Map;
        }else if(elementName.equalsIgnoreCase("button_Online_Statements")){
            element = button_Online_Statements;
        }else if(elementName.equalsIgnoreCase("button_btn_submit")){
            element = button_btn_submit;
        }else if(elementName.equalsIgnoreCase("Button_Add_New_Payee")){
            element = Button_Add_New_Payee;
        }else if(elementName.equalsIgnoreCase("Button_add_inthe_new_payee")){
            element = Button_add_inthe_new_payee;
        }else if(elementName.equalsIgnoreCase("button_pay_saved_payees")){
            element = button_pay_saved_payees;
        }else if(elementName.equalsIgnoreCase("radioButton_pc_inDollars_true")){
            element = radioButton_pc_inDollars_true;
        }else if(elementName.equalsIgnoreCase("button_purchase_cash")){
            element = button_purchase_cash;
        }else if(elementName.equalsIgnoreCase("Button_Purchase_Foreign_Currency")){
            element = Button_Purchase_Foreign_Currency;
        }



        waitUntilVisible(element);
        waitUntilClickable(element);

        element.click();
    }

    public void enterData(String whichElement, String value){

        WebElement element = null;

        if(whichElement.equalsIgnoreCase("input_tf_amount")){
            element = input_tf_amount;
        }else if(whichElement.equalsIgnoreCase("input_tf_description")){
            element = input_tf_description;
        }else if(whichElement.equalsIgnoreCase("input_Payee_Name")){
            element = input_Payee_Name;
        }else if(whichElement.equalsIgnoreCase("input_np_new_payee_address")){
            element = input_np_new_payee_address;
        }else if(whichElement.equalsIgnoreCase("input_np_new_payee_account")){
            element = input_np_new_payee_account;
        }else if(whichElement.equalsIgnoreCase("input_np_new_payee_details")){
            element = input_np_new_payee_details;
        }else if(whichElement.equalsIgnoreCase("input_sp_amount")){
            element = input_sp_amount;
        }else if(whichElement.equalsIgnoreCase("input_sp_date")){
            element = input_sp_date;
        }else if(whichElement.equalsIgnoreCase("input_sp_description")){
            element = input_sp_description;
        }else if(whichElement.equalsIgnoreCase("input_pc_amount")){
            element = input_pc_amount;
        }

        element.sendKeys(value);

    }

    public void assertions(String elementName,String ExpectedText){

        WebElement element = null;

        if(elementName.equalsIgnoreCase("text_Success_message")){
            element = text_Success_message;
        }else if(elementName.equalsIgnoreCase("text_success_message_addNewPayee")){
            element = text_success_message_addNewPayee;
        }



        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(ExpectedText) , element.getText());

    }

    public void waitUntilVisible(WebElement whichElement){

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(whichElement));

    }

    public void waitUntilClickable(WebElement whichElement){

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.elementToBeClickable(whichElement));

    }

}
