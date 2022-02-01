


enum winner{firstWinner, secondWinner,gameContinue, noWinner}


public class TicTacToe
{
    private int ROW;
    private int COL;
    private char firstPlayer;
    private char secondPlayer;
    private char type[][];

    public TicTacToe(char firstPlayer, char secondPlayer, int ROW) 
    {
        this.ROW = ROW;
        this.COL = ROW;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        type = new char[ROW][COL];
        for(int i = 0; i < this.ROW; i++)
            for(int j = 0; j < this.COL; j++)
                type[i][j] = ' ';
    }


    public boolean setType(int row, int col, char type) 
    {
        if((row >= 0 && row < ROW) && (col >= 0 && col < COL)) 
        {
            if(this.type[row][col] != ' ')
            {
                System.out.println("This house is full.\nPlease choose another house.");
                return false;
            }
            else
            {
                this.type[row][col] = type;
                return true;
            }
        }
        else
        {
            System.out.println("The row and column must between 0 and " + ROW);
            System.out.println("Please enter correctly -_-");
            return false;
        }
    }

    
    public winner checkEndGame()
    {
        int verify;
        for(int i = 0; i < ROW; i++)
        {
            verify = 1;
            for(int j = 0; j < COL - 1; j++)
            {
                if(type[i][j] == ' ')
                {
                    verify = 0;
                    break;
                }
                if(type[i][j] != type[i][j + 1])
                {
                    verify = 0;
                    break;
                }
            }
            if(verify == 1)
            {
                if(type[i][0] == firstPlayer)
                    return winner.firstWinner;
                
                else if(type[i][0] == secondPlayer)
                    return winner.secondWinner;
            }
        }


        for(int j = 0; j < COL; j++)
        {
            verify = 1;
            for(int i = 0; i < ROW - 1; i++)
            {
                if(type[i][j] == ' ')
                {
                    verify = 0;
                    break;
                }
                if(type[i][j] != type[i + 1][j])
                {
                    verify = 0;
                    break;
                }
            }
            if(verify == 1)
            {
                if(type[0][j] == firstPlayer)
                    return winner.firstWinner;


                if(type[0][j] == secondPlayer)
                    return winner.secondWinner;
            }
        }



        verify = 1;
        for(int i = 0; i < ROW - 1; i++)
        {
            if(type[i][i] == ' ')
                return winner.gameContinue;
            if(type[i][i] != type[i + 1][i + 1])
            {
                verify = 0;
                break;
            }
        }

        if(verify == 1)
        {
            if(type[0][0] == firstPlayer)
                return winner.firstWinner;
            if(type[0][0] == secondPlayer)
                return winner.secondWinner;
        }


        verify = 1;

        for(int i = 0; i < ROW - 1; i++)
        {
            if(type[i][ROW - i - 1] == ' ')
                return winner.gameContinue;
            if(type[i][ROW - i - 1] != type[i + 1][ROW - i - 2])
            {
                verify = 0;
                break;
            }
        }

        if(verify == 1)
        {
            if(type[0][ROW - 1] == firstPlayer)
                return winner.firstWinner;
            if(type[0][ROW - 1] == secondPlayer)
                return winner.secondWinner;
        }


        for(int i = 0; i < ROW; i++)
            for(int j = 0; j < COL; j++)
                if(type[i][j] == ' ')
                    return winner.gameContinue;
                

        return winner.noWinner;
    }


    public void printBoard()
    {
        for(int i = 0; i < COL; i++)
            System.out.print(" _____");
        System.out.print("\n");

        for(int i = 0; i < ROW; i++)
        {
            for(int j = 0; j < COL; j++)
            {
                if(type[i][j] == firstPlayer)
                    System.out.print("|  \033[1;31m"+ type[i][j] +"\033[0;38m  ");
                else if(type[i][j] == secondPlayer)
                    System.out.print("|  \033[1;34m"+ type[i][j] +"\033[0;38m  ");
                else
                    System.out.print("|     ");
            }
            System.out.println("|");

            for(int j = 0; j < COL; j++)
                System.out.print("|\033[4;37m" + i +"___" + j + "\033[0;38m");
            System.out.println("|");
        }
    }

    public winner getFirstWinner() {return winner.firstWinner;}

    public winner getSecondWinner() {return winner.secondWinner;}

    public winner getGameContinue() {return winner.gameContinue;}

    public winner getNoWinner() {return winner.noWinner;}



}







