/*
 * Course: CS231
 * Name: Joseph-Richard Kwarteng
 * Date: 2/25/2024
 * Description: This class represents a deck of cards. It manages a collection of Card objects, allowing cards to be dealt, the deck to be shuffled, and the number of cards left in the deck to be determined.
 */


import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();
    Random rand = new Random();
    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        build();
        shuffle();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        // Clear the deck to ensure it's empty before building a new one
        this.deck.clear();

        // Add cards with value 10 (representing face cards) to the deck
        for(int i = 0;i<16;i++){
            Card card10 = new Card(10);
            this.deck.add(card10);
        }
        // Add a few cards with random values between 2 and 10 to the deck
        for(int i=0;i<3;i++){
            Card card4 = new Card(rand.nextInt(2, 10));
            this.deck.add(card4);
        }

        // Add an Ace card with value 11 to the deck
        Card card11 = new Card(11);
        deck.add(card11);

        // Add remaining cards with random values between 2 and 12 to the deck
        for (int i=0;i<32;i++){
            Card card4 = new Card(rand.nextInt(2, 12));
            this.deck.add(card4);
        }
    
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return this.deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        // Retrieve and remove the first card from the deck
        Card topCard = this.deck.get(0);
        this.deck.remove(0);
        return topCard;
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        //Implementing Fisher-Yates algorithm in the shuffle method
        for(int i= this.deck.size()-1;i>0;i--){
            Random rand1 = new Random();
            int j = rand1.nextInt(0,this.deck.size());
            Card temp = this.deck.get(i);
            this.deck.set(i, this.deck.get(j));
            this.deck.set(j,temp);
        }
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        return ""+this.deck;

    }
}
