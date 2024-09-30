public class CrapsWithFriends {
    public static void main(String[] args) {
        System.out.println("Starting Craps Game...");

        // First roll
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int firstSum = die1 + die2;
        while (firstSum == 7) {
            die1 = (int) (Math.random() * 6) + 1;
            die2 = (int) (Math.random() * 6) + 1;
            firstSum = die1 + die2;
        }
        System.out.println("Common goal: " + firstSum);
        System.out.println();//for formatting

        int goal = firstSum;

        // booleans to represent players as alive
        boolean playerOne = true;
        boolean playerTwo = true;
        boolean playerThree = true;

        int playerSum;
        while (playerOne || playerTwo || playerThree) {
            for (int i = 1; i < 4; i++) {

                die1 = (int) (Math.random() * 6) + 1;
                die2 = (int) (Math.random() * 6) + 1;
                playerSum = die1 + die2;

                if (playerOne && i == 1) {
                    System.out.println("    Player one has rolled: " + playerSum);
                    if (playerSum == firstSum) {
                        System.out.println("Player one wins!");
                        // end game
                        playerOne = false;
                        playerTwo = false;
                        playerThree = false;
                    }
                    if (playerSum == 7) {
                        System.out.println("Player one has lost!");
                        playerOne = false;
                    }
                }
                if (playerTwo && i == 2) {
                    System.out.println("    Player two has rolled: " + playerSum);
                    if (playerSum == firstSum) {
                        System.out.println("Player two wins!");
                        playerOne = false;
                        playerTwo = false;
                        playerThree = false;
                    }
                    if (playerSum == 7) {
                        System.out.println("Player two has lost!");
                        playerTwo = false;
                    }
                }
                if (playerThree && i == 3) {
                    System.out.println("    Player three has rolled: " + playerSum);
                    if (playerSum == firstSum) {
                        System.out.println("Player three wins!");
                        playerOne = false;
                        playerTwo = false;
                        playerThree = false;
                    }
                    if (playerSum == 7) {
                        System.out.println("Player three has lost!");
                        playerThree = false;
                    }
                }
            }
        }

    }
}
