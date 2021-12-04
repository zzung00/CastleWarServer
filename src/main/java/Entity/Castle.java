package Entity;

import java.awt.geom.Rectangle2D;

public class Castle {
    private double x, y;
    private int hp;

    public Castle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
