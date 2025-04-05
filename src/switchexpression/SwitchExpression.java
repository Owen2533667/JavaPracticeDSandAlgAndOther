package switchexpression;

public class SwitchExpression {

    public static void main(String[] args) {

        int dayOfWeek = 3; // Example: Wednesday
        int numLetters = switch (dayOfWeek) {
            case 1, 5, 7 -> 6; // Monday, Friday, Sunday
            case 2 -> 7; // Tuesday
            case 4, 6 -> 8; // Thursday, Saturday
            case 3 -> 9; // Wednesday
            default -> throw new IllegalStateException("Invalid day: " + dayOfWeek);
        };
        System.out.println("Number of letters: " + numLetters);


    }

}
