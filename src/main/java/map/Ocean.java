package map;

import ships.Fleet;
import ships.Ship;

import static map.TileAction.*;

public class Ocean {
    private int numRow = 10;
    private int numCol = 10;
    private Fleet playerFleet;
    //private Fleet cpuFleet;
    private Grid grid;

    public Ocean(int carrierX,int carrierY, int battleshipX, int battleshipY, int destroyerX, int destroyerY, int submarineX, int submarineY, int patrolBoatX, int patrolBoatY) {
        //cpuFleet = new Fleet(0,0,1,0,2,0,3,0,4,0);
        playerFleet = new Fleet(carrierX, carrierY, battleshipX, battleshipY, destroyerX, destroyerY, submarineX, submarineY, patrolBoatX, patrolBoatY);
        grid = new Grid(numRow, numCol);
        for(Ship ship : playerFleet.getShipList()){
            grid.setShipLocation(ship);
        }
    }

    private boolean validateCoorinateForGridCreation(int postionX, int postionY){
        //Validate position is not currently
        return true;
    }

    public boolean shotFired(int positionX, int positionY){
        boolean shotSucessfull= false;
        switch (grid.getActionOnATile(positionX, positionY)) {
            case Ship_Carrier:
            case Ship_Battleship:
            case Ship_Destoryer:
            case Ship_Submarine:
            case Ship_Patrol_Boat:
                grid.updateTile(positionX, positionY, Hit);
                shotSucessfull = true;
                break;
            case Empty:
                grid.updateTile(positionX, positionY, Miss);
                shotSucessfull = true;
                break;
            case Hit:
            case Miss:
            default:
                shotSucessfull = false;
                break;

        }
        return shotSucessfull;
    }

    public boolean checkForWinCondition(){
        for(int i = 0; i < numRow; i++){
            for(int j = 0; j < numCol; j++){
                switch (grid.getActionOnATile(i, j)){
                    case Ship_Carrier:
                    case Ship_Destoryer:
                    case Ship_Submarine:
                    case Ship_Battleship:
                    case Ship_Patrol_Boat:
                        return true;
                    default:
                        break;
                }
            }
        }
        return false;
    }
}
