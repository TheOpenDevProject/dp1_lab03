package ships;

public class Ship {
    private ShipName shipName;
    private int size;
    private boolean destroyed;
    private int xPosition;
    private int yPostition;
    private ShipOrientation shipOrientation;

    public Ship(ShipName shipName, int size, boolean destroyed, int xPosition, int yPostition) {
        this.shipName = shipName;
        this.size = size;
        this.destroyed = destroyed;
        this.xPosition = xPosition;
        this.yPostition = yPostition;
        this.shipOrientation = ShipOrientation.Horizontal;
    }

    public ShipName getShipName() {
        return shipName;
    }

    public void setShipName(ShipName shipName) {
        this.shipName = shipName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPostition() {
        return yPostition;
    }

    public void setyPostition(int yPostition) {
        this.yPostition = yPostition;
    }

    public ShipOrientation getShipOrientation() {
        return shipOrientation;
    }

    public void setShipOrientation(ShipOrientation shipOrientation) {
        this.shipOrientation = shipOrientation;
    }
}
