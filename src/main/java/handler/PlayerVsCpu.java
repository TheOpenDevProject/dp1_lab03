package handler;

import map.Ocean;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerVsCpu {
    private Ocean playerOcean;
    private Ocean cpuOcean;

    public PlayerVsCpu() {
    }

    public boolean startNewGame(){
        boolean gameInProgress = true;
        int carrierX = 0;
        int carrierY = 0;
        int battleshipX = 1;
        int battleshipY = 0;
        int destroyerX = 2;
        int destroyerY = 0;
        int submarineX = 3;
        int submarineY = 0;
        int patrolBoatX = 4;
        int patrolBoatY = 0;
        cpuOcean = new Ocean(0,0,1,0,2,0,3,0,4,0);
        playerOcean = new Ocean(carrierX, carrierY, battleshipX, battleshipY, destroyerX, destroyerY, submarineX, submarineY, patrolBoatX, patrolBoatY);
        do{
            if(playersTurn()){
                System.out.println("Player's turn has been completed");
            }else{
                System.out.println("Player wins");
                gameInProgress = false;
                break;
            }

            if(cpusTurn()){
                System.out.println("CPU's turn has been completed");
            }else{
                System.out.println("CPU wins");
                gameInProgress = false;
            }
        }while(gameInProgress);
        return true;
    }

    private boolean playersTurn(){
        boolean turnCompleted = false;
        do {
            turnCompleted = checkPlayerGridIfAlreadyFiredShotOnLocation(ThreadLocalRandom.current().nextInt(0, 10), ThreadLocalRandom.current().nextInt(0, 10));
        }while(!turnCompleted);
        return checkForWinCondition(playerOcean);
    }

    private boolean cpusTurn(){
        boolean turnCompleted = false;
        do {
            turnCompleted = checkCPUGridIfAlreadyFiredShotOnLocation(ThreadLocalRandom.current().nextInt(0, 10), ThreadLocalRandom.current().nextInt(0, 10));
        }while(!turnCompleted);
        return checkForWinCondition(cpuOcean);
    }

    private boolean checkPlayerGridIfAlreadyFiredShotOnLocation(int positionX, int positionY){
        return playerOcean.shotFired(positionX, positionY);
    }

    private boolean checkCPUGridIfAlreadyFiredShotOnLocation(int positionX, int positionY){
        return cpuOcean.shotFired(positionX, positionY);
    }

    private boolean checkForWinCondition(Ocean ocean){
        return ocean.checkForWinCondition();
    }
}
