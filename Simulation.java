import java.util.ArrayList;

public class Simulation {
    public static void main(String[] args) {
        // Number of simulations
        int numSimulations = 5;

        // Store results for each simulation
        ArrayList<Integer> dealerWins = new ArrayList<>();
        ArrayList<Integer> ties = new ArrayList<>();
        ArrayList<Integer> playerWins = new ArrayList<>();

        // Perform simulations
        for (int j = 0; j < numSimulations; j++) {
            int dealerWinCount = 0;
            int tieCount = 0;
            int playerWinCount = 0;

            for (int i = 0; i < 1000; i++) {
                Blackjack game = new Blackjack();
                int result = game.game(false);
                if (result == -1) {
                    dealerWinCount++;
                } else if (result == 0) {
                    tieCount++;
                } else if (result == 1) {
                    playerWinCount++;
                }
            }

            // Store results for this simulation
            dealerWins.add(dealerWinCount);
            ties.add(tieCount);
            playerWins.add(playerWinCount);
        }

        // Calculate mean and standard deviation for each result
        double meanDealerWins = calculateMean(dealerWins);
        double meanTies = calculateMean(ties);
        double meanPlayerWins = calculateMean(playerWins);
        double stdDevDealerWins = calculateStandardDeviation(dealerWins, meanDealerWins);
        double stdDevTies = calculateStandardDeviation(ties, meanTies);
        double stdDevPlayerWins = calculateStandardDeviation(playerWins, meanPlayerWins);

        // Print results
        System.out.println("Mean Dealer Wins: " + meanDealerWins);
        System.out.println("Standard Deviation of Dealer Wins: " + stdDevDealerWins);
        System.out.println("Mean Ties: " + meanTies);
        System.out.println("Standard Deviation of Ties: " + stdDevTies);
        System.out.println("Mean Player Wins: " + meanPlayerWins);
        System.out.println("Standard Deviation of Player Wins: " + stdDevPlayerWins);
    }

    // Method to calculate mean of an ArrayList
    public static double calculateMean(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return (double) sum / list.size();
    }

    // Method to calculate standard deviation of an ArrayList
    public static double calculateStandardDeviation(ArrayList<Integer> list, double mean) {
        double sumSquaredDiff = 0;
        for (int num : list) {
            sumSquaredDiff += Math.pow(num - mean, 2);
        }
        double variance = sumSquaredDiff / list.size();
        return Math.sqrt(variance);
    }
}
