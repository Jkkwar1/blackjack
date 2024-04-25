import matplotlib.pyplot as plt

# Number of games (M) and corresponding standard deviations for each outcome
num_games = [100, 200, 300, 400, 500]
std_deviations_dealer = [17.29, 15.12, 12.45, 10.67, 9.83]  # Example values for dealer wins
std_deviations_ties = [10.18, 9.25, 8.39, 7.61, 6.99]  # Example values for ties
std_deviations_player = [22.53, 20.67, 18.91, 17.22, 15.68]  # Example values for player wins

# Create line plot for dealer wins
plt.figure(figsize=(8, 6))
plt.plot(num_games, std_deviations_dealer, marker='o', color='blue', linestyle='-', linewidth=2, label='Dealer Wins')

# Add line plot for ties
plt.plot(num_games, std_deviations_ties, marker='s', color='green', linestyle='-', linewidth=2, label='Ties')

# Add line plot for player wins
plt.plot(num_games, std_deviations_player, marker='^', color='red', linestyle='-', linewidth=2, label='Player Wins')

# Add legend, title, and labels
plt.title('Standard Deviation vs. Number of Games')
plt.xlabel('Number of Games (M)')
plt.ylabel('Standard Deviation')
plt.grid(True)
plt.legend()
plt.tight_layout()

# Show plot
plt.show()
