import java.util.Scanner;





public class Game 
{
    // Fields
    Scanner in = new Scanner(System.in);
    private int ROW;
    private int COL;
    private char firstPlayer;
    private char secondPlayer;
    TicTacToe ticTacToe;

    public int menu()
    {

        while(true)
        {
            System.out.println("\033[H\033[2J");

            System.out.println("\t\t\t\t\t\t\t\t\t\t* * * * * * * * * * * * * * *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*      \033[1;33mTic - Tac - Toe\033[0;38m      *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*    \033[1;34m1 - Single player\033[0;38m      *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*    \033[1;34m2 - Two players\033[0;38m        *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*    \033[1;34m3 - Exit\033[0;38m               *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t*                           *");
            System.out.println("\t\t\t\t\t\t\t\t\t\t* * * * * * * * * * * * * * *");
    
            int choice;
            System.out.println();
            System.out.print("\t\t\t\t\t\t\t\t\t\tPlease enter your choice : ");
    
            choice = in.nextInt();
    
            if(choice > 0 && choice < 4)
                return choice;
            
            System.out.println("\t\t\t\t\t\t\t\t\t\tPlease Enter correctly");
            System.out.print("\t\t\t\t\t\t\t\t\t\tPlease press ENTER key to continue...");

            try {System.in.read();}
            catch (Exception e){}
        }
    }


    public void setInformationForTwoPlaters()
    {
        COL = ROW = 3;
        String current;

        System.out.print("Please enter the symbol of first Player : ");
        current = in.next();
        firstPlayer = current.charAt(0);

        System.out.print("Please enter the symbol of second Player : ");
        current = in.next();
        secondPlayer = current.charAt(0);


        System.out.println("\033[H\033[2J");


        ticTacToe = new TicTacToe(firstPlayer, secondPlayer, ROW);
    }


    public void twoPlayers()
    {
        int turn = 1;
        int row;
        int col;
        while(ticTacToe.checkEndGame() == ticTacToe.getGameContinue())
        {
            if(turn % 2 == 1)
            {
                ticTacToe.printBoard();
                
                System.out.println("\n>>>>Turn of the first Player<<<<\n");


                System.out.print("\nPlease enter the coordinates of the point where you want to place your bead: ");
                while(true)
                {
                    row = in.nextInt();
                    col = in.nextInt();
                    if(ticTacToe.setType(row, col, firstPlayer))
                        break;
                    
                    System.out.print("Please enter correctly : ");
                }
 

                System.out.println("\033[H\033[2J");

                turn++;

                if(ticTacToe.checkEndGame() != ticTacToe.getGameContinue())
                    break;
            }
            else
            {
                ticTacToe.printBoard();


                System.out.println("\n>>>>Turn of the second Player<<<<\n");

                System.out.print("\nPlease enter the coordinates of the point where you want to place your bead: ");
                while(true)
                {
                    row = in.nextInt();
                    col = in.nextInt();
                    if(ticTacToe.setType(row, col, secondPlayer))
                        break;
                    
                    System.out.print("\n\nPlease enter correctly : ");
                }
                System.out.println("\033[H\033[2J");

                turn++;
            }
        }

        setWinnerForTwoPlayers();
    }


    public void setWinnerForTwoPlayers()
    {
        ticTacToe.printBoard();

        System.out.println();
        if(ticTacToe.checkEndGame() == ticTacToe.getNoWinner())
        {
            System.out.println("The is end with no winner!!!");
            return;
        }
        else if(ticTacToe.checkEndGame() == ticTacToe.getFirstWinner())
            System.out.println("First Player is Winner");
        else
            System.out.println("Second Player is Winner");
    }

    


    public void setInformationForSinglePlayer()
    {
        System.out.println("\033[H\033[2J");


        System.out.println("لطفا نماد خود");

    }

    public void singlePlayer()
    {
        int turn = 1;
        int row;
        int col;
        while(ticTacToe.checkEndGame() == ticTacToe.getGameContinue())
        {
            if(turn % 2 == 1)
            {
                ticTacToe.printBoard();
                
                System.out.println("\n>>>>Turn you<<<<\n");


                System.out.print("\nPlease enter the coordinates of the point where you want to place your bead: ");
                while(true)
                {
                    row = in.nextInt();
                    col = in.nextInt();
                    if(ticTacToe.setType(row, col, firstPlayer))
                        break;
                    
                    System.out.print("Please enter correctly : ");
                }
 

                System.out.println("\033[H\033[2J");

                turn++;

                if(ticTacToe.checkEndGame() != ticTacToe.getGameContinue())
                    break;
            }
            else
            {

            }
        }
    }

    public void setWinnerForSinglePlayer()
    {
        
    }

}
