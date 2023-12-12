#ifndef DICE_H
#define DICE_H

#include <string>
#include <vector>

class Dice
{
public:
    // Default constructor
    Dice();

    // Rolls the specified number of dice
    std::vector<std::string> roll(int numDice);
};

#endif
