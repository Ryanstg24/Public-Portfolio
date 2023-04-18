#include <iostream>
#include <map>
using namespace std;

//Create TestRecords class with private and public sections
class TextRecords {
public:
    void printItemsPurchased(ostream& os);
    void printItemsHistogram();
    void itemLookup();
    int fileInput();
    string fileName;
private:
    //Create map to store items and frequency
    map<string, int> frequencyMap;
};
