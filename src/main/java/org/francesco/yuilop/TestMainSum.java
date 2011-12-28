package org.francesco.yuilop;

import java.util.ArrayList;
import java.util.List;

public class TestMainSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //Example 1
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(4);
        l.add(5);
        l.add(2);
        l.add(-3);
        
        //Example 2
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(0);
        l2.add(1);
        l2.add(2);
        l2.add(-3);
        
        //Example 3
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(-8);
        
        //Case with more than one negative number (combinations of the negative numbers as well)
        List<Integer> l4 = new ArrayList<Integer>();
        l4.add(2);
        l4.add(3);
        l4.add(-4);
        l4.add(-1);
        
        System.out.println("Result: " + SumProblem.findSumZero(l));
        System.out.println("Result: " + SumProblem.findSumZero(l2));
        System.out.println("Result: " + SumProblem.findSumZero(l3));
        System.out.println("Result: " + SumProblem.findSumZero(l4));

    }

}
