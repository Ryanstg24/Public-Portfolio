#include <Rules.h>
#include <iostream>
#include <fstream>

using namespace std;

void displayRules(const string &filename)
{
    ifstream file(filename);
    if (!file)
    {
        // File opening failed
        cerr << "Unable to open file: " << filename << endl;
        return;
    }

    // File opened successfully, read and display its content
    string line;
    while (getline(file, line))
    {
        cout << line << endl;
    }
    file.close();
}
