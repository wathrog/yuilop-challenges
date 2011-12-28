package org.francesco.yuilop;

import java.util.List;


/**
 * <p>
 * Build a function that given a list of Integers pairs in the range [-65000,65000], that
 * represents {X, Y} Coordinates in a Plane. The function returns the two closest pairs.
 * </p>
 * Example:
 * <ul>
 *   <li>[{0,0}, {1,20}, {5, 2}] returns [{0,0}, {5, 2}]</li>
 *   <li>[{-10,10}, {1,5}, {4, 3}] returns [{1,5}, {4, 3}]</li>
 * </ul>
 * @author francesco
 *
 */
public class MinDistanceProblem {
    
    //Private constructor for implementing a static class
    private MinDistanceProblem() {
    }
    
    /**
     * <p>Find, recursively, the pair of coordinates with the smallest distance given a list of coordinates.</p>
     * @param coordinates the list of coordinates.
     * @return the coordinate pair with the smallest distance.
     */
    public static CoordinatePair minDistance(List<Coordinate> coordinates) {
        //Preconditions: the list size should be greater or equal than 2 (at least one pair)
        if (coordinates.size() < 2) {
            return null;
        }
        //Calling the recursive function passing as partial result our possible maximum in solution space
        return minDistanceRec(coordinates, new CoordinatePair(new Coordinate(65000,65000),new Coordinate(-65000,-65000)));
        
    }
    
    /**
     * <p>Find, recursively, the pair of coordinates with the smallest distance given a list of coordinates and a partial result.</p>
     * 
     * @param coordinates the list of coordinates
     * @param partial the partial result
     * @return the coordinate pair with the smallest distance, either the partial result or a newly found solution.
     */
    private static CoordinatePair minDistanceRec(List<Coordinate> coordinates, CoordinatePair partial) {
        //Exit condition: the list size should be greater or equal than 2 (at least one pair)
        if (coordinates.size() < 2) {
            return partial;
        }
        //Get the head of the list
        Coordinate head = coordinates.get(0);
        //Get the tail of the list
        List<Coordinate> tail = coordinates.subList(1, coordinates.size());
        
        //For each element of the tail...
        for (Coordinate c : tail) {
            //Create a coordinate pair with the head
            CoordinatePair pair = new CoordinatePair(head, c);
            //Update the partial result if needed
            if (partial.getDistance() > pair.getDistance()) {
                partial = pair;
            }
            //Call the recursion step
            partial = minDistanceRec(tail, partial);
        }
        return partial;
    }
    
    

}
