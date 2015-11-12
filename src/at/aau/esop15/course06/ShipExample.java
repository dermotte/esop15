package at.aau.esop15.course06;

/**
 * @author Dr. Mathias Lux, 12.11.2015.
 */
public class ShipExample {
    // actual position of the ship
    private int positionX, positionY;
    // maximum number for x and y
    private int maxX = 320, maxY = 640;

    public ShipExample() {
        this.positionX = maxX/2;
        this.positionY = maxY/2;
    }

    public void moveShip(int offSetX, int offsetY) {
        positionX += offSetX;
        positionY += offsetY;

        // check for violation of maximum
        if (positionX > maxX)
            positionX = maxX;
        if (positionY > maxY)
            positionY = maxY;
    }

    public int getPositionX() {
        return positionX;
    }


    public int getPositionY() {
        return positionY;
    }

}
