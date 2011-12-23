package org.francesco.yuilop;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Build a function that given a list of Integers in the range [-65000,65000], the function
 * returns true if any subset of the list summed is equal to zero. False otherwise.
 * Example:
 * [0, 1, 2, -3] returns true. As 1+2+(-3)==0.
 * [1, 2, 3, -8] returns false. As no subset summed is equal 0.
 * [1, 4, 5, 2, -3] returns true.
 * 
 * Assuming that the list does not contain any duplicates
 * 
 * @author francesco
 *
 */
public class SumProblem {
    
    public static boolean findSumZero(List<Integer> test) {
        // Storing the positive and negative values in a natural order sorted set
        SortedSet<Integer> negative = new TreeSet<Integer>();
        SortedSet<Integer> positive = new TreeSet<Integer>();
        
        // Scan the input list and separate positive ints from negative ints.
        // Exit on Zero as we have found a solution {0}
        for (Integer num : test) {
            if (num == 0) {
                return true;
            } else if (num > 0) {
                positive.add(num);
            } else {
                negative.add(Math.abs(num));
            }
        }
        
        // For each negative number (goal value), try to find one or more
        // Depth-first approach, in case the probability of finding the same absolute value in a negative and positive numbers pair is high it is probably worth just scanning for this condition
        for (Integer goalSum : negative) {
            for (Integer tmp : positive ) {
                //X==Y case
                if (tmp.equals(goalSum)) {
                    return true;
                }
                //If we are currently evaluating a number that is greater than the goal value, we can stop and proceed with the next.
                if (tmp > goalSum) {
                    break;
                }
                
                //TODO
                
            }
        }
        
        return false;
    }

}
