import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 19.11.2012
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToe{

    protected String player1;
    protected String player2;
    protected String[][] board;
    protected ArrayList<Integer> movesMade;

    public TicTacToe(){
        movesMade = new ArrayList<Integer>();
        board = new String[3][3];
        int count = 1;
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){

                board[i][j] = Integer.toString(count);
                count++;
            }
        }
    }
    public void ResetBoard(){
        int count = 1;
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.board[i][j] = Integer.toString(count);
                count++;
            }
        }
    }
    public void StoreMove(int move){
        this.movesMade.add(move);
    }
    public boolean IsMoveValid(String input){
        try{
            int move = Integer.parseInt(input);
            if((move<1)){
                return false;
            }
            if(move>9){
                return false;
            }
            for(Integer i : this.movesMade){
                if(i == move ) return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;

    }
    public void Quit(String input){
        if(input.equals("quit")){
            System.out.println("Game Over");
            System.exit(0);
        }
    }
    public void SetPlayer1(String player1){
        if(player1.isEmpty()){
            player1 = "Player1";
        }
        this.player1 = player1;
    }
    public void SetPlayer2(String player2){
        if(player2.isEmpty()){
            player2 = "Player2";
        }
        this.player2 = player2;
    }
    public void MakeMove(String input,String player){

        String marker;
        if(player.equals(this.player1)){
            marker = "X";
        }
        else{
            marker = "O";
        }

        int move = Integer.parseInt(input);
        StoreMove(move);
        if(input.equals("1")){
            this.board[0][0] = marker;
        }
        if(input.equals("2")){
            this.board[0][1] = marker;
        }
        if(input.equals("3")){
            this.board[0][2] = marker;
        }
        if(input.equals("4")){
            this.board[1][0] = marker;
        }
        if(input.equals("5")){
            this.board[1][1] = marker;
        }
        if(input.equals("6")){
            this.board[1][2] = marker;
        }
        if(input.equals("7")){
            this.board[2][0] = marker;
        }
        if(input.equals("8")){
            this.board[2][1] = marker;
        }
        if(input.equals("9")){
            this.board[2][2] = marker;
        }

    }
    public void PrintBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("|"+this.board[i][j]+"|");
            }
            System.out.println( );

        }
    }
    public boolean HasPlayerWon(String player){

        String marker;
        if(player.equals(this.player1)){
            marker = "X";
        }
        else{
            marker = "O";
        }

        for(int i = 0 ; i < 3 ; i++){
            //athugum hvort spilari sé með lárétta línu
            if(this.board[i][0].equals(marker)&&this.board[i][1].equals(marker)&&this.board[i][2].equals(marker)){
                return true;
            }
        }
        for(int j = 0;  j < 3 ; j++){
            //athugum hvort spilari sé með lóðrétta línu
            if(this.board[0][j].equals(marker)&&this.board[1][j].equals(marker)&&this.board[2][j].equals(marker)){
                return true;
            }
        }
        //athugum hvort spilari sé með ská línu
        if(this.board[0][0].equals(marker)&&this.board[1][1].equals(marker)&&this.board[2][2].equals(marker)){
            return true;
        }
        else if(this.board[0][2].equals(marker)&&this.board[1][1].equals(marker)&&this.board[2][0].equals(marker)){
            return true;
        }
        //Spilari hefur ekki unnið ennþá.
        return false;
    }
    public void WaitForMove(String input, String player){
        MakeMove(input,player);

        if(HasPlayerWon(player)){
            Win(player);
        }

    }
    public String ReadPlayerInput(String player, BufferedReader keyboard)throws IOException{
        System.out.println(player+" make your move");
        String input = keyboard.readLine();
        if(IsMoveValid(input)){
            return input;
        }
        else{
            System.out.println("This move is not valid or is not available");
            System.out.println("Please choose a number between 1-9");
        }
        return ReadPlayerInput(player, keyboard);
    }
    public void Win(String player){
        System.out.println(player+ " has Won the game!");
        System.out.println("------------------------------");
        PrintBoard();
        System.out.println("------------------------------");
        System.out.println("Game Over Thanks for playing");
        System.out.println();
        System.out.println("Credits:");
        System.out.println("Ólafur Björn Magússon");
        System.out.println("Sindri Már Sigfússon");
        System.out.println("Heimir Már Helgason");
        System.out.println("Halldór Vilhjálmsson");
        System.out.println("og svo Logi það er fullt nafn hans.");
        System.exit(0);

    }

    public static void main(String[] args) throws  IOException{
        TicTacToe tic = new TicTacToe();
        System.out.println("-----------------Welcome to the game of TIC TAC TOE----------------------");
        System.out.println("To make your move enter a number between 1-9");
        System.out.println("To enter quit to leave the game.");
        tic.PrintBoard();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(in);

        System.out.println("Enter Player 1 name :");
        String player1input = keyboard.readLine();
        tic.SetPlayer1(player1input);

        System.out.println("Enter Player 2 name :");
        String player2input = keyboard.readLine();
        tic.SetPlayer2(player2input);

        System.out.println("Player name 1:"+ tic.player1 );
        System.out.println("Player name 2:"+ tic.player2 );


        while(true){

            String input1 = tic.ReadPlayerInput(tic.player1, keyboard);
            tic.WaitForMove(input1, tic.player1);

            tic.PrintBoard();
            tic.Quit(input1);

            String input2 = tic.ReadPlayerInput(tic.player2, keyboard);
            tic.WaitForMove(input2, tic.player2);

            tic.PrintBoard();
            tic.Quit(input1);
        }
    }
}
