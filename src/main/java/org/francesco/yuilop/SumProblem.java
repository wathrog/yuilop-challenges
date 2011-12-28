package org.francesco.yuilop;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <p>
 * Build a function that given a list of Integers in the range [-65000,65000],
 * the function returns true if any subset of the list summed is equal to zero.
 * False otherwise. Example: [0, 1, 2, -3] returns true. As 1+2+(-3)==0. [1, 2,
 * 3, -8] returns false. As no subset summed is equal 0. [1, 4, 5, 2, -3]
 * returns true.
 * </p>
 * 
 * Assuming that the list does not contain any duplicates
 * 
 * @author francesco
 * 
 */
public class SumProblem {

    public static boolean findSumZero(List<Integer> test) {
        // Storing the positive and negative values in a natural order sorted
        // set
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

        // For each combination of absolute values of negative numbers of the
        // initial set (goal value), try to find the first combination of
        // positive numbers that have the same sum
        // Depth-first approach, in case the probability of finding the same
        // absolute value in a negative and positive numbers pair is high it is
        // probably worth just scanning for this condition
        return combinationSumCombinations(positive, negative);
    }

    /**
     * <p>
     * Recursive algorithm to find if any combination of numbers has sum equals
     * to a given goal
     * </p>
     * 
     * @param numbers
     *            The set of numbers to combine. Having them sorted in natural
     *            order (SortedSet) is optimizing the algorithm by doing pruning
     *            of the result space.
     * @param goal
     *            The result to check
     * @param partial
     *            The partial result so far (used for recursion
     * @return true if any combination of numbers has sum equals to the goal
     */
    private static boolean combinationSumRec(SortedSet<Integer> numbers,
            int goal, int partial) {
        // For each number...
        for (Integer num : numbers) {
            // Calculate the new partial given as previous one plus the number
            // that we are evaluating
            partial += num;
            if (partial == goal) { // Return true if we have a match
                return true;
            }
            if (partial > goal) {
                // Useless to proceed further in this branch as it can not bring
                // any more partial results <= goal (pruning)
                return false;
            }
            // Get a subset with all the remaining nubmers
            SortedSet<Integer> remaining = numbers.tailSet(num + 1);
            // Execute the recursion step
            if (combinationSumRec(remaining, goal, partial)) {
                return true;
            }
        }
        return false;

    }

    /**
     * <p>
     * Primer function for combinationSumRec (no need to pass in a partial
     * value)
     * </p>
     */
    private static boolean combinationSum(SortedSet<Integer> numbers, int goal) {
        return combinationSumRec(numbers, goal, 0);
    }

    /**
     * 
     * <p>
     * Recursive algorithm to find combinations of a set of numbers (toCheck)
     * and verify if any combinations of operands have the same sum
     * </p>
     * 
     * @param operands
     *            The set of numbers to combine and sum for each combination of
     *            input
     * @param toCheck
     *            The target set
     * @param partial
     *            The partial result so far
     * @return true if any combination of operands has sum equals to any
     *         combination of the target set summed
     */
    private static boolean combinationSumCombinationsRec(
        SortedSet<Integer> operands, SortedSet<Integer> toCheck, int partial) {
        // For each number in the target set...
        for (Integer num : toCheck) {
            partial += num; // Calculate the partial sum
            // Verify if any combination of operands summed have the same
            // result, if yes we can return true (result found)
            if (combinationSum(operands, partial)) {
                return true;
            }
            // Get a subset with all the remaining targets
            SortedSet<Integer> remaining = toCheck.tailSet(num + 1);
            // Execute the recursion step
            if (combinationSumCombinationsRec(operands, remaining, partial)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Primer function for combinationSumCombinationsRec (no need to pass in a
     * partial value)
     * </p>
     */
    private static boolean combinationSumCombinations(
            SortedSet<Integer> operands, SortedSet<Integer> toCheck) {
        return combinationSumCombinationsRec(operands, toCheck, 0);
    }

}
