package stack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        // stack = LIFO data structure. Last-In First-Out
        //         stores objects into a sort of "vertical tower"
        //         push() to add to the top
        //         pop() to remove from the top


        Stack<String> stack = new Stack<>();

//        System.out.println(stack.empty());

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("Doom");
        stack.push("Borderlands");
        stack.push("FFVII");

        System.out.println(stack.empty());

        System.out.println(stack);

        stack.pop();

        System.out.println(stack);

        String currentPop = stack.pop();

        System.out.println("Game has been removed: " + currentPop);

        System.out.println(stack.peek());

        System.out.println(stack.search("Doom"));


        /*
        * java.lang.OutOfMemoryError : Java heap space
        * */
//        for (int i = 0; i < 1000000000; i++) {
//            stack.push("Fallout 76");
//        }


        // uses of stack?
        // 1. undo/redo feature in text editors
        // 2. moving back/forward through browser history
        // 3. backtracking algorithms (maze, file directories)
        // 4. calling functions (call stack)





    }

}
