// recvfrom.cpp : 定义控制台应用程序的入口点。
#include "stdafx.h"
#include <stdio.h>
#include "winsock2.h"
#pragma comment(lib,"WS2_32.lib")   

int _tmain(int argc, _TCHAR* argv[])
{
	WSADATA wsaData;					// WSADATA变量，用于初始化Windows Socket
	SOCKET RecvSocket;				// 发送消息的SOCKET	
	sockaddr_in RecvAddr;				// 服务器端地址
	int Port = 27015;						// 服务器端侦听地址
	char RecvBuf[1024];					// 发送数据的缓冲区
	int  BufLen = 1024;					// 缓冲区大小
	sockaddr_in SenderAddr;			// 发送者的地址
	int SenderAddrSize = sizeof(SenderAddr);
	//-----------------------------------------------
	// 初始化Winsock
	WSAStartup(MAKEWORD(2, 2), &wsaData);

	//-----------------------------------------------
	// 创建接收数据报的SOCKET
	RecvSocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);

	//-----------------------------------------------
	// 将SOCKET与指定端口和0.0.0.0绑定
	RecvAddr.sin_family = AF_INET;
	RecvAddr.sin_port = htons(Port);
	RecvAddr.sin_addr.s_addr = htonl(INADDR_ANY);
	bind(RecvSocket, (SOCKADDR*)&RecvAddr, sizeof(RecvAddr));
	
	//-----------------------------------------------
	// 调用recvfrom()函数在绑定的SOCKET上接收数据
	printf("Receiving datagrams...\n");
	while (true)
	{
		int val = recvfrom(RecvSocket,
			RecvBuf,
			BufLen,
			0,
			(SOCKADDR*)&SenderAddr,
			&SenderAddrSize);
		if (val > 0)
			if (strcmp(RecvBuf, "quit") == 0)
			{
				printf("clent quit！\n");
				break;
			}
		printf("Client Message:[IP:%s  PORT:%d]:", inet_ntoa(SenderAddr.sin_addr), SenderAddr.sin_port);
		printf("%s\n", RecvBuf);
	}

	//-----------------------------------------------
	// 关闭SOCKET，结束接收数据
	printf("Finished receiving. Closing socket.\n");

	closesocket(RecvSocket);

	//-----------------------------------------------
	// 释放资源，退出
	printf("Exiting.\n");
	WSACleanup();
	return 0;
}
