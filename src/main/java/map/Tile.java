package map;

public class Tile {
    private TileAction tileAction;

    public Tile() {
        this.tileAction = TileAction.Empty;
    }

    public TileAction getTileAction() {
        return tileAction;
    }

    public void setTileAction(TileAction tileAction) {
        this.tileAction = tileAction;
    }
}
