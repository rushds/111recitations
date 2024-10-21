public class BlackJackThree {
    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack!");
            System.out.println("Let's start the game!");    
            System.out.println("How many players?");
            int numPlayers = StdIn.readInt();
            int [] cardSums = new int[numPlayers];
            int dealerCard1 = (int)(Math.random() * 13) + 1;
            int dealerCard2 = (int)(Math.random() * 13) + 1;
            int dealerSum = dealerCard1 + dealerCard2;
            
            if(dealerCard1 > 10){
                dealerCard1 = 10;
            }
            if(dealerCard2 > 10){
                dealerCard2 = 10;
            }
            
            for(int i = 0; i < numPlayers; i++){
                int card1 = (int)(Math.random() * 13) + 1;
                int card2 = (int)(Math.random() * 13) + 1;
                if(card1 > 10){
                    card1 = 10;
                }
                if(card2 > 10){
                    card2 = 10;
                }
                cardSums[i] = card1+card2;
            }

             //reveal dealer cards
             System.out.println("Dealer's cards: " + dealerCard1 + " and " + dealerCard2);
             while(dealerSum < 17){
                 int dealerCard3 = (int)(Math.random() * 13) + 1;
                 if(dealerCard3 > 10){
                     dealerCard3 = 10;
                 }
                 dealerSum += dealerCard3;
                 System.out.println("Dealer drew a " + dealerCard3 + " new total is " + dealerSum);
             }
           
            for(int i = 0; i < numPlayers; i++){
                System.out.println("Player " + i + " card sum: " + cardSums[i]);
                if(cardSums[i] > 21){
                    System.out.println("Player " + i + " bust! Your total is " + cardSums[i] + ". You lost.");
                    continue;
                }
                System.out.println("Player " + i + " do you want to 'hit' or 'stand'? Enter 0 for hit, 1 for stand. ");
                int choice = StdIn.readInt();
                if(choice != 0 && choice != 1){
                    System.out.println("Invalid choice. Please enter 0 for hit or 1 for stand.");
                    choice = StdIn.readInt();
                }       
                // If the player chooses to hit, generate a third card
                if (choice == 0) {
                    int card3 = (int)(Math.random() * 13) + 1;
                    if(card3 > 10){
                        card3 = 10;
                    }
                    System.out.println("You drew a " + card3);
                    cardSums[i] += card3;
                    if(cardSums[i] > 21){
                        System.out.println("Player " + i + " bust! Your total is " + cardSums[i] + ". You lost.");
                    }
                }
                if(choice == 1){
                    System.out.println("Player " + i + " stands with a total of " + cardSums[i]);
                }
            }
            
            // Determine the outcome
            if(dealerSum > 21){
                System.out.println("Dealer bust! Dealer total is " + dealerSum + ". All players win!");
                return;
            }
            int maxValue = -1;
            int winningPlayer = -1;
            for(int i = 0; i < numPlayers; i++){
                if(cardSums[i] > 21){
                    continue;
                }
                if(cardSums[i] > maxValue && cardSums[i] <= 21){
                    maxValue = cardSums[i];
                    winningPlayer = i;
                }
            }
            if(winningPlayer == -1){
                System.out.println("All players bust! Dealer wins!");
                return;
            }
            if(maxValue > dealerSum){
                System.out.println("Player " + winningPlayer + " wins! Player total is " + maxValue + ". Dealer total is " + dealerSum);
            } else if(maxValue < dealerSum){
                System.out.println("Player " + winningPlayer + " loses! Player total is " + maxValue + ". Dealer total is " + dealerSum);
            } else {
                System.out.println("Player " + winningPlayer + " ties with dealer! Player total is " + maxValue + ". Dealer total is " + dealerSum);
            }
        }
}
