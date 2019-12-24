package Connect4;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {


    @Test
    public void testInitialCondition() {
        Board board = new Board();
        Assert.assertEquals(0, board.getTotalMovesPlayed());
        Assert.assertEquals(board.getCurrentPlayer(), Chip.RED);
    }


    @Test
    public void totalMovesAndCurrentPlayerTest1() {
        Board board = new Board("1");
        Assert.assertEquals(1, board.getTotalMovesPlayed());
        Assert.assertEquals(board.getCurrentPlayer().toString(), "YELLOW");
    }

    @Test
    public void totalMovesAndCurrentPlayerTest2() {
        Board board = new Board("12");
        Assert.assertEquals(2, board.getTotalMovesPlayed());
        Assert.assertEquals(board.getCurrentPlayer().toString(), "RED");
    }

    @Test
    public void totalMovesAndCurrentPlayerTest3() {
        Board board = new Board("154");
        Assert.assertEquals(3, board.getTotalMovesPlayed());
        Assert.assertEquals(board.getCurrentPlayer().toString(), "YELLOW");
    }

    @Test
    public void insertionTest1() {
        Board board = new Board("12");
        String str = "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "R Y _ _ _ _ _ \n";
        Assert.assertEquals(str, board.toString());
    }

    @Test
    public void insertionTest2() {
        Board board = new Board("1122");
        String str = "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "Y Y _ _ _ _ _ \n" +
                "R R _ _ _ _ _ \n";
        Assert.assertEquals(str, board.toString());
    }

    @Test
    public void insertionTest3() {
        Board board = new Board("123456");
        String str = "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ \n" +
                "R Y R Y R Y _ \n";
        Assert.assertEquals(str, board.toString());
    }

    @Test
    public void findEmptyRowTest1() {
        Board board = new Board("1");
        Assert.assertEquals(4, board.findEmptyRow(1));

    }

    @Test
    public void findEmptyRowTest2() {
        Board board = new Board("111");
        Assert.assertEquals(2, board.findEmptyRow(1));

    }

    @Test
    public void findEmptyRowTest3() {
        Board board = new Board("2");
        Assert.assertEquals(4, board.findEmptyRow(2));
    }

    @Test
    public void findEmptyRowTest4() {
        Board board = new Board("555555");
        Assert.assertEquals(-1, board.findEmptyRow(5));
    }

    @Test
    public void getChipTest1() {
        Board board = new Board("1");
        Assert.assertEquals("RED", board.getChip(5, 0).toString());
    }

    @Test
    public void getChipTest2() {
        Board board = new Board("11");
        Assert.assertEquals("YELLOW", board.getChip(4, 0).toString());
    }

    @Test
    public void getChipTest3() {
        Board board = new Board();
        Assert.assertEquals("_", board.getChip(5, 1).toString());
    }

    @Test
    public void configurationTest1() {
        Board board = new Board("111");
        Assert.assertEquals("111", board.getConfiguration());
    }

    @Test
    public void configurationTest2() {
        Board board = new Board("234234");
        Assert.assertEquals("234234", board.getConfiguration());
    }

    @Test
    public void configurationTest3() {
        Board board = new Board("5432");
        Assert.assertEquals("5432", board.getConfiguration());
    }

    @Test
    public void verticalWinnerTest() {
        Board board = new Board("1212121");
        Assert.assertEquals(true, board.hasWinningCondition());
    }

    @Test
    public void horizontalWinnerTest() {
        Board board = new Board();
        board.insertChipAt(1);
        board.insertChipAt(1);
        board.insertChipAt(2);
        board.insertChipAt(2);
        board.insertChipAt(3);
        board.insertChipAt(3);
        board.insertChipAt(4);
        Assert.assertEquals(true, board.hasWinningCondition());
    }

    @Test
    public void rightDiagonalWinnerTest() {
        Board board = new Board("12233434454");
        Assert.assertEquals(true, board.hasWinningCondition());
    }

    @Test
    public void leftDiagonalWinnerTest1() {
        Board board = new Board("12");
        Assert.assertEquals(false, board.hasWinningCondition());
    }
    @Test
    public void leftDiagonalWinnerTest2() {
        Board board = new Board("43322121131");
        Assert.assertEquals(true, board.hasWinningCondition());
    }
}