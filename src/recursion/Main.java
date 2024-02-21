package recursion;

import static java.nio.file.Files.walk;

public class Main {
    public static void main(String[] args) {

        // recursion = Apply the result of a procedure, to a procedure.
        //             A recursive method calls itself. Can be a substitute for iteration.
        //             Divide a problem into sub-problems of the same type ass the original.
        //             Commonly used with advanced sorting algorithms and navigating trees.

        //             Advantages
        //             ----------
        //             easier to read/write
        //             easier to debug

        //             Disadvantages
        //             -------------
        //             sometimes slower
        //             uses more memory




        //walkIteration(5);


        walkRecursive(5);

        System.out.println(factorial(7));

        System.out.println(power(2, 8));




    }

    private static int power(int base, int exponent) {

        if (exponent < 1) return 1; // base case
        return base * power(base, exponent - 1); // recursive case

    }

    //the product of an integer and all the integers below it; e.g. factorial four (4!) is equal to 24.
    private static int factorial(int num) {
        if (num < 1) return 1; // base case
        return num * factorial(num - 1); // recursive case
    }


    private static void walkIteration(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("You take a step!");
        }
    }

    private static void walkRecursive(int steps) {
        if (steps < 1) return;
        System.out.println("You take a step!");
        walkRecursive(steps - 1);
    }
}
