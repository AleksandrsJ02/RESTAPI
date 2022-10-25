package check.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo() {
        System.out.println("1st has been executed");
    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String title) {
        System.out.println("The title is changed to: " + title);
    }

    @When("I check that the board name was updated to {string}")
    public void checkBoardTitle(String name) {
        System.out.printf("The board name was updated to: " + name);
    }

    @Then("I add a list with title {string} to the board")
    public void addNewList(String name) {
        System.out.printf("New list is added with name: " + name);
    }
}
