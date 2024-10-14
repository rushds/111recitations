public class BlackJackOne{
    public static void main(String[] args) {

        System.out.println("Welcome to BlackJack!");
        System.out.println("Let's start the game!");    
        
        int dealerCard1 = (int)(Math.random() * 13) + 1;
        int dealerCard2 = (int)(Math.random() * 13) + 1;
        int playerCard1 = (int)(Math.random() * 13) + 1;
        int playerCard2 = (int)(Math.random() * 13) + 1;
        //10, 11, 12 should all be 10 bcs face cards have val 10
        if(dealerCard1 > 10){
            dealerCard1 = 10;
        }
        if(dealerCard2 > 10){
            dealerCard2 = 10;
        }
        if(playerCard1 > 10){
            playerCard1 = 10;
        }
        if(playerCard2 > 10){
            playerCard2 = 10;
        }

        int playerCard3 = 0; // Optional third card if the player chooses to hit

        // Reveal the player's cards and the dealer's first card
        System.out.println("Your cards: " + playerCard1 + " and " + playerCard2);
        System.out.println("Dealer's face-up card: " + dealerCard1);

        // Ask the player what they want to do
        Stdout.println("Do you want to 'hit' or 'stand'? Enter 0 for hit, 1 for stand. ");
        int choice = StdIn.readInt();
        if(choice != 0 && choice != 1){
            System.out.println("Invalid choice. Please enter 0 for hit or 1 for stand.");
            choice = StdIn.readInt();
        }       
        // If the player chooses to hit, generate a third card
        if (choice == 0) {
            playerCard3 = (int)(Math.random() * 13) + 1;
            if(playerCard2 > 10){
                playerCard2 = 10;
            }
            System.out.println("You drew a " + playerCard3);
        }

        // Calculate the sums of the player's cards and the dealer's cards
        int playerSum = playerCard1 + playerCard2 + playerCard3;
        int dealerSum = dealerCard1 + dealerCard2;

        // Determine the outcome
        if (playerSum > 21) {
            System.out.println("Bust! Your total is " + playerSum + ". You lose.");
        } else if (playerSum == 21) {
            System.out.println("Blackjack! Your total is 21. You win!");
        } else if (playerSum < dealerSum) {
            System.out.println("Your total is " + playerSum + ". Dealer's total is " + dealerSum + ". You lose.");
        } else if (playerSum > dealerSum) {
            System.out.println("Your total is " + playerSum + ". Dealer's total is " + dealerSum + ". You win!");
        } else {
            System.out.println("It's a tie! Your total is " + playerSum + ". Dealer's total is " + dealerSum + ".");
        }

    }
}