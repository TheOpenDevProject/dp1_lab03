package map;

import ships.Ship;
import ships.ShipOrientation;

public class Grid {
    private Tile[][] tiles;

    public Grid(int numRow, int numCol) {
        tiles = new Tile[numRow][numCol];
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                tiles[i][j] = new Tile();
            }
        }
    }

    public boolean setShipLocation(Ship ship) {
        TileAction tileAction;
        switch (ship.getShipName()) {
            case Battleship:
                tileAction = TileAction.Ship_Battleship;
                break;
            case Carrier:
                tileAction = TileAction.Ship_Carrier;
                break;
            case Destoryer:
                tileAction = TileAction.Ship_Destoryer;
                break;
            case Submarine:
                tileAction = TileAction.Ship_Submarine;
                break;
            case Patrol_Boat:
                tileAction = TileAction.Ship_Patrol_Boat;
                break;
            default:
                tileAction = TileAction.Empty;
                break;
        }
        if (ship.getShipOrientation() == ShipOrientation.Horizontal) {
            for (int i = ship.getxPosition(); i < ship.getxPosition() + ship.getSize(); i++) {
                updateTile(i, ship.getyPostition(), tileAction);
            }
        } else if (ship.getShipOrientation() == ShipOrientation.Vertical) {
            for (int i = ship.getyPostition(); i < ship.getyPostition() + ship.getSize(); i++) {
                updateTile(ship.getxPosition(), i, tileAction);
            }
        }
        return true;
    }

    public boolean updateTile(int row, int col, TileAction tileAction) {
        tiles[row][col].setTileAction(tileAction);
        return true;
    }

    public TileAction getActionOnATile(int row, int col){
        return tiles[row][col].getTileAction();
    }
}
