#include "stdafx.h"
#include <WINSOCK2.H>   		// 用于管理Windows Sockets版本2函数的头文件
#pragma comment(lib,"WS2_32.lib")   
#include <iostream>

int _tmain(int argc, _TCHAR* argv[])
{
	WSADATA wsaData;				// WSADATA变量，用于初始化Windows Socket
	SOCKET SendSocket;			// 发送消息的SOCKET
	sockaddr_in RecvAddr;			// 服务器端地址
	int Port = 27015;					// 服务器端侦听地址
	char SendBuf[1024];			// 发送数据的缓冲区
	int BufLen = 1024;				// 缓冲区大小

	//---------------------------------------------
	// 初始化SOCKET
	WSAStartup(MAKEWORD(2, 2), &wsaData);
	//---------------------------------------------
	// 创建SOCKET对象
	SendSocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);

	//---------------------------------------------
	// 设置服务器地址
	RecvAddr.sin_family = AF_INET;
	RecvAddr.sin_port = htons(Port);
	RecvAddr.sin_addr.s_addr = inet_addr("127.0.0.1");

	//---------------------------------------------
	// 向服务器发送数据报
	printf("Sending a datagram to the receiver...\n");
	while (true)
	{
		printf("Please Input:");
		std::cin.getline(SendBuf, 1024);
		sendto(SendSocket,
			SendBuf,
			BufLen,
			0,
			(SOCKADDR*)&RecvAddr,
			sizeof(RecvAddr));
		if (strcmp(SendBuf, "quit") == 0)
		{
			std::cout << "clent quit！" << std::endl;
			break;
		}
	}
	//---------------------------------------------
	// 发送完成，关闭SOCKET
	printf("Finished sending. Closing socket.\n");
	closesocket(SendSocket);

	//---------------------------------------------
	// 释放资源，并退出
	printf("Exiting.\n");
	WSACleanup();
	return 0;
}
