


public class Main {
    public static void main(String[] args) 
    {
        Game game = new Game();

        switch(game.menu())
        {
            case 1:
            {

                break;
            }
            case 2:
            {
                game.setInformationForTwoPlaters();

                game.twoPlayers();

                break;
            }
            case 3:
            {
                return;
            }
        }


    }  



}









