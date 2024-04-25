/*
 * Course: CS231
 * Name: Joseph-Richard Kwarteng
 * Date: 2/25/2024
 * Description: This class represents a hand in a card game. It manages a collection of cards, allowing cards to be added, removed, and queried. It also provides functionality to calculate the total value of the cards in the hand.
 */


import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;
    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    public Hand(){
        this.hand = new ArrayList<>() ;
    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){
        this.hand.clear();
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        this.hand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        for(Card card:hand){
            if(card == hand.get(index)){
                return card;
            }
        }
        return null;
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int sum=0;
        
        for(Card card:hand){
            sum+=card.getValue();
        }
    
        return sum;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        return ""+hand + " :"+ " "+ getTotalValue();
    }

}
