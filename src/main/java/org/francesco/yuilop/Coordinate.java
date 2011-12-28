package org.francesco.yuilop;

/**
 * <p> Class that represents a coordinate on a two dimensional plane </p>
 * @author francesco
 *
 */
public class Coordinate {
    
    int x;
    int y;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Constructor for a default coordinate {0,0}
     */
    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Constructor for a coordinate
     * @param x the X value
     * @param y the Y value
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * <p> Get the Euclidean distance between two coordinates </p>
     * @param c1 the first coordinate
     * @param c2 the second coordinate
     * @return the Euclidean distance between the two coordinates
     */
    public static double getDistance (Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow((c2.getX() - c1.getX()), 2) + Math.pow((c2.getY() - c1.getY()), 2));
    }
    
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append('{');
        ret.append(this.getX());
        ret.append(',');
        ret.append(this.getY());
        ret.append('}');
        return ret.toString();
    }
    

}
