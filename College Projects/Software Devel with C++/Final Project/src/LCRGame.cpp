#include "LCRGame.h"
#include <iostream>
#include <string>

using namespace std;

LCRGame::LCRGame()
{
    // Initializes the game
}

void LCRGame::playGame()
{
    // Display the game rules
    displayRules("resources/Rules.txt");

    // Initialize players
    cout << "Welcome to LCR Game! How many players are playing? (Minimum 3)" << endl;
    int numPlayers;

    // Validate Player input with error handling
    while (true)
    {
        if (cin >> numPlayers)
        {
            if (numPlayers >= 3)
            {
                break;
            }
            else
            {
                cout << "At least 3 players are required. Please enter a valid number of players: ";
            }
        }
        else
        {
            cout << "Invalid input. Please enter a number: ";
            cin.clear();                                         // Clear the error flag
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Ignore invalid input
        }
    }

    // Getting player names
    for (int i = 1; i <= numPlayers; ++i)
    {
        string playerName;
        while (true)
        {
            cout << "Enter name for Player " << i << " (letters only): ";
            cin >> playerName;
            if (isValidName(playerName))
                break;
            cout << "Invalid name. Please use only letters." << endl;
        }
        players.emplace_back(playerName);
    }

    // Game logic
    int centerChips = 0;
    bool gameInProgress = true;
    while (gameInProgress)
    {
        for (size_t i = 0; i < players.size(); ++i)
        {
            Player &currentPlayer = players[i];

            // Only proceed if player has chips
            if (currentPlayer.GetChips() > 0)
            {
                string command;
                // Error handling if roll is not typed
                do
                {
                    cout << currentPlayer.GetName() << "'s turn. Type 'roll' to roll the dice: ";
                    cin >> command;
                    if (command == "roll")
                        break;
                    cout << "Invalid input. Please type 'roll' to roll the dice." << endl;
                } while (command != "roll");

                // Roll the dice
                if (command == "roll")
                {
                    int numDice = min(currentPlayer.GetChips(), 3);
                    auto diceResults = dice.roll(numDice);

                    // Output the results of the dice roll
                    cout << "Rolling " << numDice << " dice..." << endl;
                    for (const auto &result : diceResults)
                    {
                        cout << "Rolled: " << result << " ,";

                        // Conduct the action based on the dice roll & output the action
                        if (result == "L")
                        {
                            passChipToLeft(i);
                            cout << "Passed a chip to the left." << endl;
                        }
                        else if (result == "C")
                        {
                            currentPlayer.RemoveChip();
                            centerChips++;
                            cout << "Placed a chip in the center." << endl;
                        }
                        else if (result == "R")
                        {
                            passChipToRight(i);
                            cout << "Passed a chip to the right." << endl;
                        }
                        else
                        {
                            cout << "No action needed." << endl;
                        }
                    }
                }
            }
            else
            {
                cout << currentPlayer.GetName() << " has no chips and skips their turn." << endl;
            }

            // Output current state of player
            // Even though players chips might be hidden in a tactical game, we will show it for debugging purposes & submission purposes
            cout << currentPlayer.GetName() << " has " << currentPlayer.GetChips() << " chips." << endl;

            // Check for game end condition
            if (checkGameEndCondition())
            {
                announceWinner();
                // Set the flag to false to end the while loop
                gameInProgress = false;
                // Break out of the for loop
                break;
            }
        }
    }
}

// Announce the winner
void LCRGame::announceWinner()
{
    size_t winningPlayerIndex = 0;
    int maxChips = 0;
    for (size_t i = 0; i < players.size(); ++i)
    {
        if (players[i].GetChips() > maxChips)
        {
            maxChips = players[i].GetChips();
            winningPlayerIndex = i;
        }
    }
    cout << "Game over! Winner is " << players[winningPlayerIndex].GetName() << " with " << maxChips << " chips." << endl;
}

// Pass a chip to the left player
void LCRGame::passChipToLeft(size_t playerIndex)
{
    size_t leftPlayerIndex = (playerIndex == 0) ? players.size() - 1 : playerIndex - 1;
    if (players[playerIndex].GetChips() > 0)
    {
        players[playerIndex].RemoveChip();
        players[leftPlayerIndex].AddChip();
    }
}

// Pass a chip to the right player
void LCRGame::passChipToRight(size_t playerIndex)
{
    size_t rightPlayerIndex = (playerIndex + 1) % players.size();
    if (players[playerIndex].GetChips() > 0)
    {
        players[playerIndex].RemoveChip();
        players[rightPlayerIndex].AddChip();
    }
}

// Check if the game has ended
bool LCRGame::checkGameEndCondition()
{
    int playersWithChips = 0;
    for (const auto &player : players)
    {
        if (player.GetChips() > 0)
        {
            playersWithChips++;
        }
    }
    // Game ends if only one player has chips left

    // Was initially kept for debugging purposes but kept for submission purposes
    cout << "Players with chips: " << playersWithChips << endl;
    return playersWithChips <= 1;
}

// Validate player name
bool LCRGame::isValidName(const std::string &name)
{
    return all_of(name.begin(), name.end(), [](char c)
                  { return isalpha(c); });
}