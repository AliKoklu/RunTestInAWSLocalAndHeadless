package StepDefinition;

import Pages.Page;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

public class Steps {

    Page page = new Page();

    @Given("^Handle dropdown$")
    public void handle_dropdown(DataTable allElements) throws Throwable {

        List<List<String>> eachElement = allElements.asLists(String.class);

        for(int i = 0 ; i<eachElement.size() ; i++){

            System.out.println(eachElement.get(i).get(0));
            page.handleDropdown( eachElement.get(i).get(0), eachElement.get(i).get(1));

        }

    }

    @Given("^Enter the value$")
    public void enter_the_value(DataTable allElements) throws Throwable {

        List<List<String>> eachElement = allElements.asLists(String.class);

        for(int i = 0 ; i<eachElement.size() ; i++){
            System.out.println(eachElement.get(i).get(0));
            page.enterData( eachElement.get(i).get(0) , eachElement.get(i).get(1));

        }

    }

    @Given("^Click on the button$")
    public void click_on_the_button(DataTable allElements) throws Throwable {

        List<String> eachElement = allElements.asList(String.class);

        for(int i = 0 ; i<eachElement.size() ; i++){
            System.out.println(eachElement.get(i));
            page.ClickFunction( eachElement.get(i));
        }

    }

    @Then("^Verify this text$")
    public void verify_this_text(DataTable allElements) throws Throwable {

        List<List<String>> eachElement = allElements.asLists(String.class);

        for(int i = 0 ; i<eachElement.size() ; i++){
            System.out.println(eachElement.get(i).get(0));
            page.assertions( eachElement.get(i).get(0) , eachElement.get(i).get(1));
        }
    }




}
