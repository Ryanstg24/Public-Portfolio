#ifndef LCRGAME_H
#define LCRGAME_H

#include "Player.h"
#include "Dice.h"
#include "Rules.h"
#include <vector>

// This class manages the game
class LCRGame
{
private:
    std::vector<Player> players;
    Dice dice;

    // Helper methods
    void passChipToLeft(size_t playerIndex);
    void passChipToRight(size_t playerIndex);
    bool checkGameEndCondition();
    void announceWinner();
    bool isValidName(const std::string& name);

public:
    // Constructor
    LCRGame();
    // Method to start and manage the game
    void playGame();
};

#endif
