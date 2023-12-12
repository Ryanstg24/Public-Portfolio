#include <Dice.h>
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

Dice::Dice()
{
    // Initialize random seed
    srand(time(0));
}

vector<string> Dice::roll(int numDice)
{
    vector<string> results;
    for (int i = 0; i < numDice; ++i)
    {
        // Random number between 0 and 5
        int roll = rand() % 6;
        // Player choices on each roll is either L,C,R, or a Dot
        switch (roll)
        {
        case 0:
            results.push_back("L");
            break;
        case 1:
            results.push_back("C");
            break;
        case 2:
            results.push_back("R");
            break;
        default:
            results.push_back(".");
        }
    }
    return results;
}