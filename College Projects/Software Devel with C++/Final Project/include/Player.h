#pragma once

#include <string>

class Player
{
private:
    /// Declaring private variables
    std::string m_name;
    int m_chips;

public:
    // Each player starts with 3 chips
    Player(const std::string &name) : m_name(name), m_chips(3) {}

    // Getters and setters

    // Set the name of the player
    void SetName(const std::string &name)
    {
        m_name = name;
    }

    // Get the name of the player
    const std::string &GetName() const
    {
        return m_name;
    }

    // Get the number of chips the player has
    int GetChips() const
    {
        return m_chips;
    }

    // Add a chip to player
    void AddChip()
    {
        m_chips++;
    }

    // Remove a chip from player
    void RemoveChip()
    {
        if (m_chips > 0)
        {
            m_chips--;
        }
    }
};