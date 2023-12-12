// Exceptions.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>

// Added this class to throw a custom exception
class CustomException : public std::exception {
public:
    const char* what() const _NOEXCEPT override { // Changed to _NOEXCEPT
        return "Custom Exception: Error In The Custom Logic";
    }
};

bool do_even_more_custom_application_logic()
{
    // Throw Standard Exception
    throw std::runtime_error("Standard Exception: Problem in Even More Custom Logic");

    // Unreachable Code
    std::cout << "Running Even More Custom Application Logic." << std::endl;

    return true;
}
void do_custom_application_logic()
{
    // Added Try Catch Block to catch the exception thrown by do_even_more_custom_application_logic
    std::cout << "Running Custom Application Logic." << std::endl;
    try {
        if (do_even_more_custom_application_logic())
        {
            std::cout << "Even More Custom Application Logic Succeeded." << std::endl;
        }
    } catch (const std::exception& e) {
        std::cout << "Exception: " << e.what() << std::endl;
    } catch (...) {
        std::cout << "Unknown Exception" << std::endl;
        throw;
    }
    std::cout << "Leaving Custom Application Logic." << std::endl;
    throw CustomException(); // Throw our Custom Exception
}

float divide(float num, float den)
{
    // Added if statement to throw an exception if the denominator is 0
    if (den == 0) {
        throw std::invalid_argument("Divide by zero error");
    }
    return (num / den);
}

void do_division() _NOEXCEPT // Changed to _NOEXCEPT
{
    float numerator = 10.0f;
    float denominator = 0;

    // Added an exception handler to capture ONLY the exception thrown by divide.
    try {
        auto result = divide(numerator, denominator);
        std::cout << "divide(" << numerator << ", " << denominator << ") = " << result << std::endl;
    } catch (const std::exception& e) {
        std::cout << "Exception in division: " << e.what() << std::endl;
    }
}

int main()
{
    std::cout << "Exceptions Tests!" << std::endl;

    // Created exception handlers
    try {
        do_division();
        do_custom_application_logic();
    } catch (const CustomException& e) {
        std::cout << "Custom Exception caught: " << e.what() << std::endl;
    } catch (const std::exception& e) {
        std::cout << "Standard Exception caught: " << e.what() << std::endl;
    } catch (...) {
        std::cout << "Unknown Exception caught" << std::endl;
    }

    std::cout << "Exceptions Tests Complete!" << std::endl;
    return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu