package menu;

import handler.PlayerVsCpu;
import map.Ocean;

import java.util.Scanner;

public class MainMenu {

    public void main(){
    }

    private boolean startGame(){
        //Need to get user inputs for board
        PlayerVsCpu playerVsCpu = new PlayerVsCpu();
        playerVsCpu.startNewGame();
        return true;
    }

    private boolean stopGame(){
        return true;
    }

    public void mainMenuHandler(){
        //Select an flow
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean stopGame = false;
        do{
            //TBD: remove line below
            startGame();
            if (choice == 1) {
                startGame();
            } else if (choice == 2) {
                stopGame = stopGame();
            } else {
                System.out.println("Enter 1 to start, 2 to end");
                choice = input.nextInt();
            }
        }while(!stopGame);
    }
}
