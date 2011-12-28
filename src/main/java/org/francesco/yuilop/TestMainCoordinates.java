package org.francesco.yuilop;

import java.util.ArrayList;
import java.util.List;

public class TestMainCoordinates {

    public static void main(String[] args) {
        //Example 1
        List<Coordinate> l1 = new ArrayList<Coordinate>();
        l1.add(new Coordinate(0,0));
        l1.add(new Coordinate(1,20));
        l1.add(new Coordinate(5,2));
        
        //Example 2
        List<Coordinate> l2 = new ArrayList<Coordinate>();
        l2.add(new Coordinate(-10,10));
        l2.add(new Coordinate(1,5));
        l2.add(new Coordinate(4,3));
        
        //Empty list (expected NULL)
        List<Coordinate> l3 = new ArrayList<Coordinate>();
        
        //undersize list (expeceted NULL)
        List<Coordinate> l4 = new ArrayList<Coordinate>();
        l4.add(new Coordinate(-10,10));
        
        //2 elements list (expected the two elements as result)
        List<Coordinate> l5 = new ArrayList<Coordinate>();
        l5.add(new Coordinate(-10,10));
        l5.add(new Coordinate(1,5));
        
        System.out.println(MinDistanceProblem.minDistance(l1));
        System.out.println(MinDistanceProblem.minDistance(l2));
        System.out.println(MinDistanceProblem.minDistance(l3));
        System.out.println(MinDistanceProblem.minDistance(l4));
        System.out.println(MinDistanceProblem.minDistance(l5));

    }

}
