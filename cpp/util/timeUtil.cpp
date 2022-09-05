#include "timeUtil.h"
using namespace std;

TimeUtil::TimeUtil(/* args */)
{
}

TimeUtil::~TimeUtil()
{
}

void TimeUtil::fun()
{
    time_t t = time(NULL);
    struct tm *stime = localtime(&t);
    // char tmp[32]{0};
    // snprintf(tmp, sizeof(tmp), "%04d-%02d-%02d %02d:%02d:%02d", 1900 + stime->tm_year, 1 + stime->tm_mon, stime->tm_mday, stime->tm_hour, stime->tm_min, stime->tm_sec);
    // cout << tmp << endl;
    char year[5], mon[3], mday[3], hour[3], min[3], sec[3];
    // sprintf(year, "%04d", 1900 + stime->tm_year);
    snprintf(year, 5, "%04d", 1900 + stime->tm_year);
    snprintf(mon, 3, "%02d", 1 + stime->tm_mon);
    snprintf(mday, 3, "%02d", stime->tm_mday);
    snprintf(hour, 3, "%02d", stime->tm_hour);
    snprintf(min, 3, "%02d", stime->tm_min);
    snprintf(sec, 3, "%02d", stime->tm_sec);
    printf("%s-%s-%s %s:%s:%s", year, mon, mday, hour, min, sec);
}

char *TimeUtil::getYear()
{
    time_t t = time(NULL);
    struct tm *stime = localtime(&t);
    snprintf(year, 5, "%04d", 1900 + stime->tm_year);
    printf("%s", year);
    return year;
}