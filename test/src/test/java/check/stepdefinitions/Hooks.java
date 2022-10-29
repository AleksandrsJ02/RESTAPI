package check.stepdefinitions;

import check.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static check.clients.TrelloClient.changeBoardName;
import static check.clients.TrelloClient.deleteList;
import static check.constants.ProjectConstants.BOARD_NAME;

public class Hooks {

    @Before
    public void beforeHook() {
        TestCaseContext.init();
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook() {
        changeBoardName(BOARD_NAME, TestCaseContext.getBoard().getId());
        deleteList(TestCaseContext.getList().getId());
        System.out.println("THE SCENARIO HAS ENDED");
    }
}
