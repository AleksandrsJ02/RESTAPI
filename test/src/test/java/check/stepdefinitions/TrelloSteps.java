package check.stepdefinitions;

import check.domain.Board;
import check.domain.List;
import check.helpers.TestCaseContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.Test;


import static check.clients.TrelloClient.*;
import static check.constants.ProjectConstants.BOARD_NAME;
import static check.constants.ProjectConstants.BOARD_ID;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo() {
        Response response = getBoardInfo(BOARD_ID);
        Board board = response.as(Board.class);

        Assertions.assertThat(board.getId())
                .as("We asset that the board ID is correct")
                .isEqualTo(BOARD_ID);

        Assertions.assertThat(board.getName())
                .as("We asset that the board name is correct")
                .isEqualTo(BOARD_NAME);

        TestCaseContext.setBoard(board);
    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String title) {
        Response response = changeBoardName(title, TestCaseContext.getBoard().getId());
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);
    }

    @When("I check that the board name was updated to {string}")
    public void checkBoardTitle(String name) {
        Assertions.assertThat(TestCaseContext.getBoard().getName())
                .as("We check that the board name was updated to: " + name)
                .isEqualTo(name);
    }

    @Then("I add a list with title {string} to the board")
    public void addNewList(String name) {
        Response response = createList(name, TestCaseContext.getBoard().getId());
        List list = response.as(List.class);
        TestCaseContext.setList(list);
    }
}
