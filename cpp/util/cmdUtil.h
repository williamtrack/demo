#ifndef _CMD_UTIL_H_
#define _CMD_UTIL_H_

#include <stdio.h>
#include <string.h>
#include <windows.h>

class CmdUtil
{
private:
    /* data */
public:
    CmdUtil(/* args */);
    ~CmdUtil();
    int run_cmd(const char *cmd);
    void run(const char *cmd);
};

#endif /* End _CMD_UTIL_H_*/