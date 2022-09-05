#ifndef _TIME_UTIL_H_
#define _TIME_UTIL_H_

#include <time.h>
#include <iostream>

class TimeUtil{
private:
    /* data */
    char year[5], mon[3], mday[3], hour[3], min[3], sec[3];

public:
    TimeUtil(/* args */);
    ~TimeUtil();
    char *getYear();
    void fun();
};

#endif /* End _TIME_UTIL_H_*/