package handler;

import map.Ocean;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * Usually I would put the following into their own files
 */

/**
 * Create a reusable positional functionality that can be shared across all Obejcts.
 */
public class Position{
    private int _x; // X-Chordinate
    private int _y; // Y-Chordinate

    /**
     * Constructs a default position
     */
    public Position(int x, int y){
        this._x = x;
        this._y = y;
    }
    /**
     * Gets the X Value for the entities current location
     */
    public int getX(){
        return this._x;
    }

     /**
     * Gets the X Value for the entities current location
     */
    public int getY(){
        return this._y;
    }

    /**
     * Sets the value of our X-Chord to our new X position
     */
    public void setX(int x){
        this._x = x;
    }

    /**
     * Move our X-Pos x spaces
     */
    public void moveX(int x){
        this._x += x;
    }
}

 public class Carrier{
     private Position _position;
     
     public Carrier(int x, int y){
         this._position = new Position(x,y); // Sets the starting location
     }
 }

public class PlayerVsCpu {
    private Ocean playerOcean;
    private Ocean cpuOcean;
    private boolean gameInProgress = true;
    // All of the previous items here should be contained in their own objects and re-usability should be as close to 100% as you can get

    public PlayerVsCpu() {
    }
    
    public void displayPlayerTurnCompleteMessage(){
        System.out.println("Player's turn has been completed");
    }


    public boolean tick(){
        boolean playersTurn = playersTurn();
        boolean cpusTurn = cpusTurn();

        // Return if either of these are true
        return playersTurn || cpusTurn;
    }
    public boolean startNewGame(){

        cpuOcean = new Ocean(0,0,1,0,2,0,3,0,4,0);
        playerOcean = new Ocean(carrierX, carrierY, battleshipX, battleshipY, destroyerX, destroyerY, submarineX, submarineY, patrolBoatX, patrolBoatY);
        
        // Just use a while loop, its syntactically much cleaner
        while(gameInProgress){
            gameInProgress = tick(); // Constantly check each cycle is it the game has finished
        }
        
    }

    private boolean playersTurn(){
        //Move your Print logic into each of these functions, its relevant to the player / cpu only that way you can logically condense your code
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
