#include "cmdUtil.h"
#include "timeUtil.h"

CmdUtil::CmdUtil(/* args */)
{
	SetConsoleOutputCP(65001);
}

CmdUtil::~CmdUtil()
{
}

int CmdUtil::run_cmd(const char *cmd)
{
	char MsgBuff[1024];
	int MsgLen = 1020;
	FILE *fp;
	if (cmd == NULL)
	{
		return -1;
	}
	if ((fp = _popen(cmd, "r")) == NULL)
	{
		return -2;
	}
	else
	{
		memset(MsgBuff, 0, MsgLen);

		//读取命令执行过程中的输出
		while (fgets(MsgBuff, MsgLen, fp) != NULL)
		{
			printf("- %s", MsgBuff);
		}

		//关闭执行的进程
		if (_pclose(fp) == -1)
		{
			return -3;
		}
	}
	return 0;
}

void CmdUtil::run(const char *cmd)
{
	// const char *cmd = "ffmpeg -i D:\\123.mp4 -vf reverse D:\\out\\out1.mp4";
	int ret = 0;
	ret = run_cmd(cmd);
	printf("命令执行结果:%d\r\n", ret);

	TimeUtil time_util = TimeUtil();
	time_util.getYear();
}
