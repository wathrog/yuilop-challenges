package org.francesco.yuilop;

/**
 * <p>This class represents a pair of coordinates</p>
 * @author francesco
 *
 */
public class CoordinatePair {
    
    Coordinate c1;
    Coordinate c2;
    
    /**
     * <p>Constructor for a new coordinate pair</p>
     * @param c1 the first coordinate
     * @param c2 the second coordinate
     */
    public CoordinatePair(Coordinate c1, Coordinate c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Coordinate getC1() {
        return c1;
    }

    public Coordinate getC2() {
        return c2;
    }
    
    /**
     * <p>Get the distance between the coordinates of this pair</p>
     * @return the distance between the two coordinates of the pair
     */
    public double getDistance() {
        return Coordinate.getDistance(c1, c2);
    }
    
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append('[');
        ret.append(c1);
        ret.append(',');
        ret.append(c2);
        ret.append(']');
        return ret.toString();
    }
}
