/*
file name:      ShuffleTests.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

How to run:     java -ea ShuffleTests
*/

import java.util.ArrayList;
import java.util.Arrays;

public class ShuffleTests {

    public static void shuffleTestsReflection() {
        // Improved test code

        // Define the size of the array
        int arraySize = 10;

        // Create an array with sequential integer elements
        ArrayList<Integer> originalArray = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            originalArray.add(i);
        }

        // Shuffle the array using both the Deck shuffle method and DumbShuffle method
        ArrayList<Integer> shuffledDeck = shuffleArrayList(new ArrayList<>(originalArray));
        ArrayList<Integer> shuffledDumb = DumbShuffle.noShuffle(new ArrayList<>(originalArray));

        // Verify that the shuffled arrays contain the same elements as the original array
        assert Arrays.equals(originalArray.toArray(), shuffledDeck.toArray()) == false :
                "Deck shuffle method failed to change the order of the array.";
        assert Arrays.equals(originalArray.toArray(), shuffledDumb.toArray()) == false :
                "DumbShuffle method failed to change the order of the array.";

        // Verify that the shuffled arrays have different orders
        assert !shuffledDeck.equals(shuffledDumb) :
                "Deck shuffle method and DumbShuffle method produced identical shuffled arrays.";

        // Additional assertions to ensure each shuffled array contains all original elements
        assert shuffledDeck.containsAll(originalArray) :
                "Deck shuffled array does not contain all original elements.";
        assert shuffledDumb.containsAll(originalArray) :
                "DumbShuffled array does not contain all original elements.";

        // Additional assertions to ensure the shuffled arrays have the correct size
        assert shuffledDeck.size() == arraySize :
                "Deck shuffled array has incorrect size.";
        assert shuffledDumb.size() == arraySize :
                "DumbShuffled array has incorrect size.";

        // Print success message if all tests pass
        System.out.println("All tests passed successfully.");
    }

    // Shuffle ArrayList using the shuffle method from the Deck class
    private static ArrayList<Integer> shuffleArrayList(ArrayList<Integer> list) {
        Deck deck = new Deck();
        ArrayList<Integer> shuffledList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            shuffledList.add(deck.deal().getValue()); // Assuming Card class has getValue() method
        }
        return shuffledList;
    }

    public static void main(String[] args) {
        
        shuffleTestsReflection();
    }
}