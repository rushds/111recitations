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
        System.out.println();//for formatting//keep this line!

        int goal = firstSum;

        //we should have some variables to represent whether each of our three players is in the game!!
        _______
        _______
        _______

        int playerSum; //to represent the sum a player will roll during their turn, we can reuse this and reassign values 
        
        while (____loop condition_____) {
            __go through each of the three players, and see if they won or lost__
            __update accordingly!!__
            __this might end up being A LOT of code writing, so stick with it!____
            //you can always ask your LA for guidance :p
        }

    }
}
