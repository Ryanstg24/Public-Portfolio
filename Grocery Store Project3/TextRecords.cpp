#include <iostream>
#include <string>
#include <fstream>
#include "TextRecords.h"
using namespace std;

//Takes in file name and reads file | Also Creates Frequency.dat file
int TextRecords::fileInput(){
    //Declaring Variables
    ifstream inFS;

    //Prompt user for file name
    cout << "Enter file name:" << endl;
    cin >> fileName;

    inFS.open(fileName);
    if (!inFS.is_open()) {
        cout << "Could not open file " << fileName << endl;
        return 1;
    }
    //Read file
    while (!inFS.eof()) {
        string itemName;
        inFS >> itemName;
        //Adding to frequency map and increments
        frequencyMap[itemName]++;
    }
    //Close file
    inFS.close();

    //Creates Frequency.dat file
    ofstream backupFile("frequency.dat");
    printItemsPurchased(backupFile);
    backupFile.close();

    return 0;
}

//Menu Option 1, Print just one items frequency
void TextRecords::itemLookup() {
    //Declaring Variables
    string itemLookup;
    ifstream inFS;

    cout << "Enter item name: ";
    cin >> itemLookup;
    //If item is not found, display item not found
    if (frequencyMap.find(itemLookup) == frequencyMap.end()) {
        cout << "Item not found." << endl;
        return;
    }

    //Display item and frequency
    cout << itemLookup << " " << frequencyMap[itemLookup] << endl;
}

//Menu Option 2, Print all items frequency
void TextRecords::printItemsPurchased(ostream& os) {
    for (const auto& item : frequencyMap) {
        //Prints to file
        os << item.first << " " << item.second << endl;
    }
}

//Menu Option 3, Print all items frequency in histogram form
void TextRecords::printItemsHistogram() {
    for (const auto& item : frequencyMap) {
        cout << item.first << " ";
        //Prints * for each frequency
        for (int i = 0; i < item.second; i++) {
            cout << "*";
        }
        cout << endl;
    }
}
