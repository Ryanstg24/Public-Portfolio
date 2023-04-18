#include <iostream>
#include <fstream>
#include "TextRecords.h"
using namespace std;

//Display menu function
TextRecords DisplayMenu() {
    //Declaring Instance of TextRecords
    TextRecords InitialInst;
    //Declaring Variables
    string userInput;
    //Getting initial file input
    InitialInst.fileInput();

    //Initial Menu Display, and gathering user input
    while (true) {
        cout << "Menu Options:" << endl;
        cout << "   1. Search for a specific item and display how many times it was sold." << endl;
        cout << "   2. Display a list of all the items and the amount of times they were sold." << endl;
        cout << "   3. Create a list of all items and the amout of times they appear in histogram form." << endl;
        cout << "   4. Exit" << endl;

        cin >> userInput;

        //If user selects 1, call itemLookup function
        if (userInput == "1") {
            InitialInst.itemLookup();
        }
        //If user selects 2, call printItemsPurchased function
        else if (userInput == "2") {
            InitialInst.printItemsPurchased(cout);
        }
        //If user selects 3, call printItemsHistogram function
        else if (userInput == "3") {
            InitialInst.printItemsHistogram();
        }
        //If user selects 4, exit program
        else if (userInput == "4") {
            cout << "Exiting Program..." << endl;
            break;
        }
        //If user selects anything else, display invalid input
        else {
            cout << "Invalid Input" << endl;
        }
    }
    return InitialInst;
}


int main() {
    //Displaying Menu when program is run
    DisplayMenu();

    return 0;
}