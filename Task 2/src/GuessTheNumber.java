import java.util.Scanner;

public class GuessTheNumber {

    // static method to take integer input without any limit and exception error
    // exception handling and input limit handling
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                if (input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                } else {
                    flag = true;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
            }
        }
        return input;
    }

    // main method
    public static void main(String[] args) {

        // input for start the game
        System.out.println("1. Start the Game \n2. Exit");
        System.out.print("Enter your choice : ");
        int choice = takeIntegerInput(2);
        int nextRound = 1;
        int noOfRound = 0;

        if (choice == 1) {

            // to check next round is there or not
            while (nextRound == 1) {
                // creating object of Game class
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + ++noOfRound + " starts...");

                // to check correct guess and limit cross
                while (!isMatched && !isLimitCross) {
                    isLimitCross = game.takeUserInput();
                    isMatched = game.isCorrectGuess();
                }
                // input for next round
                System.out.println("1. Next Round \n2. Exit");
                System.out.println("Enter your choice : ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}