import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class TicTacToeTest extends TestCase {
    public TicTacToeTest(String name) {
        super(name);
    }
    public void setUp() throws Exception {
        super.setUp();
    }
    public void testMakeBoard() throws  Exception{
        TicTacToe tictac = new TicTacToe();
        assertEquals("Value should be 1 ", "1", tictac.board[0][0]);
        assertEquals("Value should be 2 ", "3", tictac.board[0][1]);
        assertEquals("Value should be 3 ", "3", tictac.board[0][2]);
        assertEquals("Value should be 4 ", "4", tictac.board[1][0]);
        assertEquals("Value should be 5 ", "5", tictac.board[1][1]);
        assertEquals("Value should be 6 ", "6", tictac.board[1][2]);
        assertEquals("Value should be 7 ", "7", tictac.board[2][0]);
        assertEquals("Value should be 8 ", "8", tictac.board[2][1]);
        assertEquals("Value should be 9 ", "9", tictac.board[2][2]);

    }
    public void tearDown() throws Exception {
        super.tearDown();
    }
    public void testXmarkerMoveOne() throws Exception {
        TicTacToe tictac = new TicTacToe();
        tictac.SetPlayer1("Player1");
        tictac.SetPlayer2("Player2");
        tictac.MakeMove("1", tictac.player1);
        tictac.MakeMove("2",tictac.player1);
        tictac.MakeMove("3",tictac.player1);
        tictac.MakeMove("4",tictac.player1);
        tictac.MakeMove("5",tictac.player1);
        tictac.MakeMove("6",tictac.player1);
        tictac.MakeMove("7",tictac.player1);
        tictac.MakeMove("8",tictac.player1);
        tictac.MakeMove("9",tictac.player1);
        assertEquals("Value should be X ", "X", tictac.board[0][0]);
        assertEquals("Value should be X ", "X", tictac.board[0][1]);
        assertEquals("Value should be X ", "O", tictac.board[0][2]);
        assertEquals("Value should be X ", "X", tictac.board[1][0]);
        assertEquals("Value should be X ", "X", tictac.board[1][1]);
        assertEquals("Value should be X ", "X", tictac.board[1][2]);
        assertEquals("Value should be X ", "X", tictac.board[2][0]);
        assertEquals("Value should be X ", "X", tictac.board[2][1]);
        assertEquals("Value should be X ", "X", tictac.board[2][2]);
    }
    public void testOmarkerMoveOne() throws Exception {
        TicTacToe tictac = new TicTacToe();
        tictac.SetPlayer1("Player1");
        tictac.SetPlayer2("Player2");
        tictac.MakeMove("1",tictac.player2);
        tictac.MakeMove("2",tictac.player2);
        tictac.MakeMove("3",tictac.player2);
        tictac.MakeMove("4",tictac.player2);
        tictac.MakeMove("5",tictac.player2);
        tictac.MakeMove("6",tictac.player2);
        tictac.MakeMove("7",tictac.player2);
        tictac.MakeMove("8",tictac.player2);
        tictac.MakeMove("9",tictac.player2);
        assertEquals("Value should be O ", "O", tictac.board[0][0]);
        assertEquals("Value should be O ", "O", tictac.board[0][1]);
        assertEquals("Value should be O ", "O", tictac.board[0][2]);
        assertEquals("Value should be O ", "O", tictac.board[1][0]);
        assertEquals("Value should be O ", "O", tictac.board[1][1]);
        assertEquals("Value should be O ", "O", tictac.board[1][2]);
        assertEquals("Value should be O ", "O", tictac.board[2][0]);
        assertEquals("Value should be O ", "O", tictac.board[2][1]);
        assertEquals("Value should be O ", "O", tictac.board[2][2]);
    }
    public void testResetBoard() throws  Exception{
        TicTacToe tictac = new TicTacToe();
        tictac.SetPlayer1("Player1");
        tictac.SetPlayer2("Player2");
        tictac.MakeMove("1",tictac.player2);
        tictac.MakeMove("2",tictac.player2);
        tictac.MakeMove("3",tictac.player2);
        tictac.MakeMove("4",tictac.player2);
        tictac.MakeMove("5",tictac.player2);
        tictac.MakeMove("6",tictac.player2);
        tictac.MakeMove("7",tictac.player2);
        tictac.MakeMove("8",tictac.player2);
        tictac.MakeMove("9",tictac.player2);
        tictac.ResetBoard();
        assertEquals("Value should be 1 ", "1", tictac.board[0][0]);
        assertEquals("Value should be 2 ", "2", tictac.board[0][1]);
        assertEquals("Value should be 3 ", "3", tictac.board[0][2]);
        assertEquals("Value should be 4 ", "4", tictac.board[1][0]);
        assertEquals("Value should be 5 ", "5", tictac.board[1][1]);
        assertEquals("Value should be 6 ", "6", tictac.board[1][2]);
        assertEquals("Value should be 7 ", "7", tictac.board[2][0]);
        assertEquals("Value should be 8 ", "8", tictac.board[2][1]);
        assertEquals("Value should be 9 ", "9", tictac.board[2][2]);

    }
    public void testStoreMove() throws  Exception{
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.StoreMove(1);
        tictactoe.StoreMove(2);
        assertNotNull(tictactoe.movesMade);
        assertEquals("Value Should be 1", 1, (int) tictactoe.movesMade.get(0));
        assertEquals("Value Should be 1",2, (int)tictactoe.movesMade.get(1));

    }

    public void testPlayer1set() throws Exception{
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.SetPlayer1("PlayerOne");
        assertEquals("Value should be PlayerOne","PlayerOne", ticTacToe.player1);
    }
    public void testPlayer2set() throws Exception{
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.SetPlayer2("PlayerTwo");
        assertEquals("Value should be PlayerTwo","PlayerTwo", ticTacToe.player2);
    }
    public void testPlayer1Empty() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("");
        assertEquals("Value should be Player1", "Player1", tic.player1);
    }
    public void testPlayer2Empty() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer2("");
        assertEquals("Value should be Player2", "Player2", tic.player2);
    }
    public void testMoveAvailableTrue() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("Player1");
        tic.SetPlayer2("Player2");
        tic.MakeMove("2", tic.player1);
        assertTrue("Make player move should be True", tic.IsMoveValid("1")) ;
    }
    public void testMoveAvailableFalse() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("Player1");
        tic.SetPlayer2("Player2");
        tic.MakeMove("2", tic.player1);
        assertFalse("Make player move should be False",tic.IsMoveValid("2"));
    }
    public void testPlayerOneHasWonHorizontal() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("Player1");
        tic.SetPlayer2("Player2");
        tic.MakeMove("1", tic.player1);
        tic.MakeMove("2", tic.player1);
        tic.MakeMove("3", tic.player1);
        assertTrue(tic.HasPlayerWon(tic.player1));
    }
    public void testPlayerOneHasWonDiagonal() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("Player1");
        tic.SetPlayer2("Player2");
        tic.MakeMove("1", tic.player1);
        tic.MakeMove("2", tic.player2);
        tic.MakeMove("5", tic.player1);
        tic.MakeMove("6", tic.player2);
        tic.MakeMove("9", tic.player1);
        assertTrue("Has player1won should be True",tic.HasPlayerWon(tic.player1));
    }
    public void testPlayerOneHasNotWon() throws  Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("Player1");
        tic.SetPlayer2("Player2");
        tic.MakeMove("2", tic.player1);
        tic.MakeMove("1", tic.player2);
        tic.MakeMove("4", tic.player1);
        tic.MakeMove("5", tic.player2);
        tic.MakeMove("6", tic.player1);
        assertFalse("HaspPlayer1Won should be false", tic.HasPlayerWon(tic.player1));

    }
    public void testPlayerTwoHasWonHorizontal() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("Player1");
        tic.SetPlayer2("Player2");
        tic.MakeMove("1", tic.player1);
        tic.MakeMove("3", tic.player2);
        tic.MakeMove("5", tic.player1);
        tic.MakeMove("6", tic.player2);
        tic.MakeMove("8", tic.player1);
        tic.MakeMove("9", tic.player2);
        assertTrue("HasPlayer2Won should be true",tic.HasPlayerWon(tic.player2));
    }
    public void testPlayerTwoHasWonVertical() throws Exception{
        TicTacToe tic = new TicTacToe();
        tic.SetPlayer1("Player1");
        tic.SetPlayer2("Player2");
        tic.MakeMove("1", tic.player1);
        tic.MakeMove("7", tic.player2);
        tic.MakeMove("3", tic.player1);
        tic.MakeMove("8", tic.player2);
        tic.MakeMove("5", tic.player1);
        tic.MakeMove("9", tic.player2);
        assertTrue("HasPlayer2Won should be true",tic.HasPlayerWon(tic.player2));
    }
    public void testIsMoveValidNotNumber() throws Exception{
        TicTacToe tic = new TicTacToe();
        assertFalse(tic.IsMoveValid("NotaNumberFrom1-9"));
    }
    public void testIsMoveValidLessThanOne() throws Exception{
        TicTacToe tic = new TicTacToe();
        assertFalse(tic.IsMoveValid("0"));
        assertFalse(tic.IsMoveValid("-1"));
    }
    public void testIsMoveValidLargerThanNine() throws Exception{
        TicTacToe tic = new TicTacToe();
        assertFalse(tic.IsMoveValid("23"));
        assertFalse(tic.IsMoveValid("10"));
    }


    public static Test suite() {
return new TestSuite(TicTacToeTest.class);
}
}
