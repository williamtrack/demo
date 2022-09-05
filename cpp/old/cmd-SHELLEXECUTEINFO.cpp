#include <Windows.h>
#include <iostream>
#include <tchar.h>

using namespace std;

int doshell()
{
	string strFfmpegPath = "D:/pro/media/ffmpeg-2022-08-10-git-8fc7f0fdec-full_build/bin/ffmpeg.exe";  //ffmpeg.exe所在的位置的完整路径
	// string strCmdContent = "/c " + strFfmpegPath 
    // + " -i " 
    // + "C:/Users/William/Desktop/test.mp4 " 
    // + "-c:v copy -c:a copy -aspect 4:3 "
    // + "C:/Users/William/Desktop/out.mp4 ";

    string strCmdContent = "/c " + strFfmpegPath
    + " -i " 
    + "C:/Users/William/Desktop/test.jpg ";

	SHELLEXECUTEINFO ShExecInfo = { 0 };
	ShExecInfo.cbSize = sizeof(SHELLEXECUTEINFO);
	ShExecInfo.fMask = SEE_MASK_NOCLOSEPROCESS;
	ShExecInfo.hwnd = NULL;
	ShExecInfo.lpVerb = NULL;
	ShExecInfo.lpFile = _T("C:/Windows/System32/cmd.exe");
	ShExecInfo.lpParameters = strCmdContent.c_str();
	ShExecInfo.lpDirectory = NULL;
	ShExecInfo.nShow = SW_HIDE;
	ShExecInfo.hInstApp = NULL;
	ShellExecuteEx(&ShExecInfo);
	WaitForSingleObject(ShExecInfo.hProcess, INFINITE);

	cout << "调用结束" << endl;
	return 0;
}