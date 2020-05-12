package ships;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> shipList;

    public Fleet(int carrierX, int carrierY, int battleshipX, int battleshipY, int destoryerX, int destroyerY, int submarineX, int submaireY, int patrolBoatX, int patrolBoatY) {
        shipList = new ArrayList<>();
        Ship carrier = new Ship(ShipName.Carrier, 5, false, carrierX, carrierY);
        Ship battleship = new Ship(ShipName.Battleship, 4, false, battleshipX, battleshipY);
        Ship destroyer = new Ship(ShipName.Destoryer, 3, false, destoryerX, destroyerY);
        Ship submarine = new Ship(ShipName.Submarine, 3, false, submarineX, submaireY);
        Ship partorlBoat = new Ship(ShipName.Patrol_Boat, 2, false, patrolBoatX, patrolBoatY);

        shipList.add(carrier);
        shipList.add(battleship);
        shipList.add(destroyer);
        shipList.add(submarine);
        shipList.add(partorlBoat);
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

    public boolean checkIfShipIsDestoryed(ShipName shipName){
        boolean destroyed = false;
        for(Ship ship : shipList){
            if(ship.getShipName() == shipName){
                destroyed = ship.isDestroyed();
            }
        }
        return destroyed;
    }

    public boolean setShipToDestoryed(ShipName shipName){
        boolean destroyed = false;
        for(Ship ship : shipList){
            if(ship.getShipName() == shipName){
                ship.setDestroyed(true);
                destroyed = true;
            }
        }
        return destroyed;
    }
}
