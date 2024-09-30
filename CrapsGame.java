public class CrapsGame{
    public static void main(String[] args) {
        System.out.println("Starting Craps Game...");

        // First roll
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int firstSum = die1 + die2;

        System.out.println("First roll: " + firstSum);

        // Check if the first roll is a win or lose condition
        if (firstSum == 7 || firstSum == 11) {
            System.out.println("Congratulations, you win!");
        } else if (firstSum == 2 || firstSum == 3 || firstSum == 12) {
            System.out.println("You lose!");
        } 
        else {
            int goal = firstSum;
            
            System.out.println("Your goal is " + goal + ". Keep rolling to match the goal or roll a 7 to lose.");

            boolean gameContinues = true;

            while (gameContinues) {
                // Roll the dice again
                die1 = (int) (Math.random() * 6) + 1;
                die2 = (int) (Math.random() * 6) + 1;
                int newSum = die1 + die2;

                // Always good to give our user some info so that it isn't just doing a bunch of rolls in the background
                // Sort of how we get loading screens on websites
                System.out.println("New roll: " + newSum);

                // Check if the player wins or loses
                if (newSum == 7) {
                    System.out.println("You lose!");
                    gameContinues = false;
                } else if (newSum == goal) {
                    System.out.println("Congratulations, you win!");
                    gameContinues = false;
                }
            }
        }
    }
}
