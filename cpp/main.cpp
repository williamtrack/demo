#include "util/cmdUtil.h"
#include "util/createProcessUtil.h"

#include <stdio.h>
#include <string>
#include <iostream>
using namespace std;

void test();
void io(int argc, char *args[]);

int main(int argc, char *args[])
{
    // io(argc,args);
    
    test();
    getchar();
    return 0;
}

void test()
{
    // CmdUtil cmdUtil;
    // cmdUtil.run("git status");
    // system("ipconfig");
    createProcessTest();
}

void io(int argc, char *args[])
{
    int i, j;
    printf("hello world!\n");
    printf("argc:%d\nargv:\n", argc);
    for (i = 0; i < argc; i++)
    {
        printf("%d:%s\n", i, args[i]);
    }
    char m[20];
    cin.getline(m, 5);
    cout << m << endl;
}