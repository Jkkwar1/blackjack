/**
 * Course: CS231
 * Name: Joseph
 * Date: 2/25/2024
 * 
 * Represents a playing card.
 */

public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {
        
        if(1<val && val<12){
        this.value = val;
        }
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
        
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return ""+this.value;
    }
}
