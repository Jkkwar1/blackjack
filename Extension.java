/**
 * Course: CS231
 * Name: Joseph-Richard Kwarteng
 * Date: 2/25/2024
 * Description: This class represents a Blackjack game, allowing players to play against a dealer. 
 * It includes methods to reset the game, deal cards, and determine the outcome of each round.
 *Description: 
*This program simulates a single game of Blackjack. To run the code, follow these steps:
*1. Ensure you have the Java Development Kit (JDK) installed on your system.
*2. Compile the Java file using the following command in your terminal or command prompt:
*3. Run the compiled Java program using the following command:
*4. By default, the program will simulate a game of Blackjack without verbose output. To enable verbose output, modify the `main` method in the `Blackjack` class by passing `true` as an argument to the `game` method.

*Example:
*public static void main(String[] args) {
*Blackjack blackjack = new Blackjack();
*System.out.println(blackjack.game(false)); // Run the game without verbose output
*}

*This will print out the result of the game (1 for player wins, -1 for dealer wins, 0 for tie) without displaying detailed hand information. To display detailed hand information, change `false` to `true` when calling the `game` method in the `main` method.


*/
public class Extension {
    private Deck deck = new Deck();
    private Hand playerHand = new Hand();
    private Hand dealerHand = new Hand();
    private int reshuffleCutoff;
    private Interactive interactive;
    
    /**
     * Constructs a Blackjack game with the specified reshuffle cutoff.
     * @param reshuffleCutoff the threshold for reshuffling the deck
     */    
    public Extension(int reshuffleCutoff){
        this.reshuffleCutoff = reshuffleCutoff;
    }

     /**
     * Constructs a Blackjack game with a default reshuffle cutoff of 13.
     */
    public Extension(){
        interactive = new Interactive();
    }


    /**
     * Resets the game by reshuffling the deck and clearing the player's and dealer's hands.
     */
    public void reset(){
        if(deck.size()<reshuffleCutoff){
            deck.build();
            deck.shuffle();
            playerHand.reset();
            dealerHand.reset();
        }else{
            playerHand.reset();
            dealerHand.reset();
        }
        
    }

    /**
     * Deals cards to both the player and the dealer.
     */
    public void deal(){
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
    }


    /**
     * Simulates the player's turn in the Blackjack game.
     * @param verbose true if verbose output should be displayed, false otherwise
     * @return true if the player's turn is successful, false if the player busts
     */
    public boolean playerTurn(boolean verbose){
        
            playerHand.add(deck.deal());
            if(verbose){
            System.out.println(">>> Player Turn: " +playerHand);}
        
        
        if(playerHand.getTotalValue() >21){
            if(verbose){
            System.out.println("Player Busts");}
        return false;
    }return true;



    }

    /**
     * Simulates the dealer's turn in the Blackjack game.
     * @param verbose true if verbose output should be displayed, false otherwise
     * @return true if the dealer's turn is successful, false if the dealer busts
     */
    public boolean dealerTurn(boolean verbose){
        while(dealerHand.getTotalValue()<17){
            dealerHand.add(deck.deal());
            if(verbose){
            System.out.println(">>> Dealer Turn: " +dealerHand);}

        }
        if(dealerHand.getTotalValue() >21){
            if(verbose){
            System.out.println("Dealer Busts");}
        return false;
        }
        return true;

    }

    /**
     * Sets the reshuffle cutoff threshold.
     * @param cutoff the new reshuffle cutoff threshold
     */
    public void setReshuffleCutoff(int cutoff){

        this.reshuffleCutoff = cutoff;
    }

    /**
     * Gets the current reshuffle cutoff threshold.
     * @return the reshuffle cutoff threshold
     */
    public int getReshuffleCutoff(){

        return this.reshuffleCutoff;
    }

    public String toString(){
        return deck + "\n"+ playerHand + "\n" +dealerHand;
    }


    
    public boolean  playerTurnInteractive() {
        // Prompt the player for their decision
        String input = interactive.getUserInput("Hit or Stand (h/s)");

        // Process the player's input
        if(input.equalsIgnoreCase("h")){
            // Player chooses to hit
            System.out.println("Player chose to hit.");
            return true; // Player wants to hit
        }
        else if(input.equalsIgnoreCase("s")){
            // Player chooses to stand
            System.out.println("Player chose to stand");
            return false;// Player wants to stand
        }
        else{
            // Invalid input; prompt the player again
            System.out.println("Invalid input. Press h to hit or s to stand");
            return playerTurnInteractive(); // Recursively call the method to prompt the player again
        }



    }

    /**
     * Plays a single game of Blackjack.
     * @param verbose true if verbose output should be displayed, false otherwise
     * @return -1 if the dealer wins, 0 in case of a tie, 1 if the player wins
     */
    public int game(boolean verbose){

        reset(); // Reset the game
        deal(); // Deal cards to player and dealer       
        

        // Display initial hands if verbose mode is enabled
        if(verbose){
        System.out.println("Initial Player Hand: "+ playerHand);
        System.out.println("Initial Dealer Hand: "+ dealerHand);

        }
        // Player's turn
        boolean player = playerTurnInteractive();
        boolean playerAlive = true;
        
        while (player == true && playerAlive) {
            playerAlive = playerTurn(verbose);
            if(playerAlive == true){
            player = playerTurnInteractive();}

            
        }

        // Check if player is still alive and has a total value less than 21
        if(player == false){
                        
        if ( playerHand.getTotalValue()<21){
            // Dealer's turn
            
            // Execute dealer's turn and calculate player and dealer totals
            boolean dealer = dealerTurn(verbose);
            int playerTotal = playerHand.getTotalValue();
            int dealerTotal = dealerHand.getTotalValue();

            // Determine winner based on total values
            if (dealer == false) {
                if(verbose){ 
                    System.out.println("Final Player Hand: "+ playerHand);
                    System.out.println("Final Dealer Hand: "+ dealerHand);  
                    System.out.println("\nPlayer Wins!");}
                return 1; // Player wins
            }
            else if (dealer == true) {
            // Determine winner based on total values
            if (playerTotal > dealerTotal){
                if(verbose){ 
                    System.out.println("Final Player Hand: "+ playerHand);
                    System.out.println("Final Dealer Hand: "+ dealerHand);  
                    System.out.println("\nPlayer Wins!");}
                return 1; // Player wins
            }
            else if (playerTotal < dealerTotal){
                if(verbose){
                    System.out.println("Final Player Hand: "+ playerHand);
                    System.out.println("Final Dealer Hand: "+ dealerHand);
                    System.out.println("Dealer Wins!");}
                return -1; // Dealer wins
            }       
            else if(playerTotal == 21 && dealerTotal ==21){
                // Tie scenario
                if(verbose){
                    System.out.println("Final Player Hand: "+ playerHand);
                    System.out.println("Final Dealer Hand: "+ dealerHand);
                    System.out.println("Push (Tie).");}
                return 0; //Tie
            }
            
        }}
    }return 0; // Default return

}
   
        



    /**
     * Main method to run a Blackjack game.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Extension blackjack = new Extension();
        blackjack.game(true);// Start a new game with verbose output

    }
}


    

