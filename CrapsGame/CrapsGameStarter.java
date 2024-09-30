public class CrapsGame{
    public static void main(String[] args) {
        System.out.println("Starting Craps Game...");

        // First roll
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int firstSum = _____;

        System.out.println("First roll: " + firstSum);

        // Check if the first roll is a win or lose condition
        if ________ 
        {
            System.out.println("Congratulations, you win!");
        } 
        else if ___________ {
            System.out.println("You lose!");
        } 
        else {
            int goal = ________;
            
            System.out.println("Your goal is " + goal + ". Keep rolling to match the goal or roll a 7 to lose.");

            while _________ {
                // Roll the dice again
                die1 = _______
                die2 = _________
                int newSum = ________

                // Always good to give our user some info so that it isn't just doing a bunch of rolls in the background
                // Sort of how we get loading screens on websites
                System.out.println("New roll: " + newSum);

                // Check if the player wins or loses
                _________ a lot is missing here _______;
            }
        }
    }
}
