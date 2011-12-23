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
        
        // For each negative permutation in class K (goal value), try to find one or more
        // Depth-first approach, in case the probability of finding the same absolute value in a negative and positive numbers pair is high it is probably worth just scanning for this condition 
        return combinationSumCombinations(positive, negative);
    }
    
    /**
     * <p>Recursive algorithm to find the 
     * @param numbers
     * @param goal
     * @param partial
     * @return
     */
    private static boolean combinationSumRec(SortedSet<Integer> numbers, int goal, int partial) {
        for (Integer num : numbers) {
            partial += num;
            if (partial == goal) {
                return true;
            }
            if (partial >= goal) {
                return false;
            }
            SortedSet<Integer> remaining = numbers.tailSet(num+1);
            if (combinationSumRec(remaining, goal, partial)) {
                return true;
            }
        }
        return false;
        
    }
    
    private static boolean combinationSum(SortedSet<Integer> numbers, int goal) {
        return combinationSumRec(numbers, goal, 0);
    }
    
    private static boolean combinationSumCombinationsRec(SortedSet<Integer> operands, SortedSet<Integer> toCheck, int partial) {
        for (Integer num : toCheck) {
            partial += num;
            if (combinationSum(operands,partial)) {
                return true;
            }
            SortedSet<Integer> remaining = toCheck.tailSet(num+1);
            if (combinationSumCombinationsRec(operands, remaining, partial)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean combinationSumCombinations(SortedSet<Integer> operands, SortedSet<Integer> toCheck) {
        return combinationSumCombinationsRec(operands, toCheck, 0);
    }

}
