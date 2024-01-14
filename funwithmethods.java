public class funwithmethods{
    /**
     * 
     * @param oddsOfHeads – chance of the coin being heads, out of 100
     * @return "Heads" or "Tails" appropriately
     */
    public static String simulateFlip(int oddsOfHeads){
        double randomValue = Math.random() * 100;  // Generate a random number between 0 and 100
        String result;
        if(randomValue <= oddsOfHeads)
            result = "Heads";
        else
            result = "Tails";
        return result;
    }
    public static void main(String [] args){
        //WRITE YOUR CODE HERE 
        //Simulate 5 flips, with different odds each time
        //What inputs would give errors? How could we fix the method to handle error inputs?
    }
}
