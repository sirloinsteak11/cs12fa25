/**
 * DO NOT MODIFY THIS FILE
 * This file is for CSE 12 PA2 in Fall 2025,
 * and contains a versatile runtime tester for use with Java's ArrayList Class.
*/

// IMPORTANT: Do not import java.util.ArrayList for Task 1
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * This class provides functionality to test the runtime of ArrayList methods
 * regardless of return type.
 * 
 * Instance variables:
 * numIters - How many times a method will be run
 * nanoToMilli - # of nanoseconds in a millisecond
 * formatOutput - format string to report runtime output
 * listWithInt - ArrayList that is used to execute the methods
 */
public class RuntimeTester {
    private static int numIters = 100000;
    private static double nanoToMilli = 1000000.0;
    private static String formatOutput = "%s took %.3f milliseconds over %d iterations to execute.%n";
    private static ArrayList listWithInt;

    /*
     * This prints the time taken to execute a method numIters times
     * for methods with a return type.
     * 
     * @param s String name of the method to be tested
     * @param method 0-ary lambda expression that returns some value T
     */
    public static <T> T measureTime(String s, Callable<T> method){
        listWithInt = new ArrayList<Integer>();
        long startTime = System.nanoTime();

        try {
            for (int i = 0; i < numIters; i++){
                method.call();
            }
            return method.call();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            long endTime = System.nanoTime();
            System.out.printf(formatOutput, s, (endTime - startTime) / nanoToMilli, numIters);
        }
    }

    /*
     * This prints the time taken to execute a method numIters times
     * for methods without a return type.
     * 
     * @param s String name of the method to be tested
     * @param method 0-ary lambda expression that returns the method
     */
    public static void measureTime(String s, Runnable r){
        listWithInt = new ArrayList<Integer>();
        long startTime = System.nanoTime();

        for (int i = 0; i < numIters; i++){
            r.run();
        }

        long endTime = System.nanoTime();
        System.out.printf(formatOutput, s, (endTime - startTime) / nanoToMilli, numIters);
    }

    /*
     * Executes runtime tests for ArrayList's prepend and append methods.
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        RuntimeTester.measureTime("prepend", () -> listWithInt.add(0, 0));
        RuntimeTester.measureTime("append", () -> listWithInt.add(0));
    }
}
