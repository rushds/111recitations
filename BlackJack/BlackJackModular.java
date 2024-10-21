public class BlackJackModular {
    public static int randomCard(){
        int randomCard = (int)(Math.random() * 13) + 1;
        if(randomCard > 10){
            randomCard = 10;
        }
        return randomCard;
    }

    public static int dealDealerCards(){
        int dealerCard1 = randomCard();
        int dealerCard2 = randomCard();
        System.out.println("Dealer's first card: " + dealerCard1 + ". Second card hidden!");
        return dealerCard1 + dealerCard2;
    }
    
    public static void dealPlayerCards(int [] cardSums, int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            int card1 = randomCard();
            int card2 = randomCard();
            cardSums[i] = card1+card2;
        }
    }

    public static int finalDealerHand(int dealerSum){
        while(dealerSum < 17){
            int dealerCard3 = randomCard();
            dealerSum += dealerCard3;
            System.out.println("Dealer drew a " + dealerCard3 + " new total is " + dealerSum);
        }
        // Determine the outcome
        if(dealerSum > 21){
            System.out.println("Dealer bust! Dealer total is " + dealerSum + ". All players win!");
            return -999; 
        }

        return dealerSum;
    }

    public static int findWinningPlayer(int [] cardSums, int numPlayers){
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
            return winningPlayer;
    }

    public static void playRounds(int [] cardSums, int numPlayers){
        for(int i = 0; i < numPlayers; i++){
            if(cardSums[i] > 21){
                System.out.println("Player " + i + " bust! Your total is " + cardSums[i] + ". You lost.");
                continue;
            }
            System.out.println("Player " + i + " card sum: " + cardSums[i]);
            System.out.println("Do you want to 'hit' or 'stand'? Enter 0 for hit, 1 for stand. ");
            int choice = StdIn.readInt();
            while(choice != 0 && choice != 1){
                System.out.println("Invalid choice. Please enter 0 for hit or 1 for stand.");
                choice = StdIn.readInt();
            }       
            // If the player chooses to hit, generate a third card
            if (choice == 0) {
                int card3 = randomCard();
                System.out.println("You drew a " + card3);
                cardSums[i] += card3;
                if(cardSums[i] > 21){
                    System.out.println("Player " + i + " bust! Your total is " + cardSums[i] + ". You lost.\n");
                }
                else {
                    System.out.println("Player " + i + " , your total is " + cardSums[i] + ".\n");
                }
            }
            if(choice == 1){
                System.out.println("Player " + i + " stands with a total of " + cardSums[i] + "\n");
            }
        }
    }
    public static void main(String[] args) {
            System.out.println("Welcome to BlackJack!");
            System.out.println("Let's start the game!");    
            System.out.println("How many players?");
            int numPlayers = StdIn.readInt();
            int [] cardSums = new int[numPlayers];

            int dealerSum = dealDealerCards();
            
            dealPlayerCards(cardSums, numPlayers);
            
            playRounds(cardSums, numPlayers);

            if(finalDealerHand(dealerSum) == -999) return;

            int endWinner = findWinningPlayer(cardSums, numPlayers);

            if(endWinner== -1){
                System.out.println("All players bust! Dealer wins!");
                return;
            }

            int maxValue = cardSums[endWinner];
            if(maxValue > dealerSum){
                System.out.println("Player " + endWinner + " wins! Player total is " + maxValue + ". Dealer total is " + dealerSum);
            } else if(maxValue < dealerSum){
                System.out.println("Player " + endWinner + " loses! Player total is " + maxValue + ". Dealer total is " + dealerSum);
            } else {
                System.out.println("Player " + endWinner + " ties with dealer! Player total is " + maxValue + ". Dealer total is " + dealerSum);
            }
        }
}
