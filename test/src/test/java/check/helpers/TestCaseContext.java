package check.helpers;

import check.domain.Board;
import check.domain.List;

public class TestCaseContext {
    private static Board board;
    private static List list;
    public static void init() {
        board = null;
        list = null;
    }
    public static void setBoard(Board board) {
        TestCaseContext.board = board;
    }

    public static Board getBoard() {
        return board;
    }

    public static List getList() {
        return list;
    }

    public static void setList(List list) {
        TestCaseContext.list = list;
    }
}
