#include "stdafx.h"
#include <Winsock2.h>

int _tmain(int argc, _TCHAR* argv[])
{
    //指定wind socket版本
    WORD dwVersionReq = MAKEWORD(1,1);
    WSAData wsData = {0};

    //加载套接字库dll
    if (0 != WSAStartup(dwVersionReq,&wsData))
    {
        WSACleanup();
        return 0;
    }

    //版本判断
    if (LOBYTE(wsData.wVersion) != 1 || HIBYTE(wsData.wVersion != 1))
    {
        WSACleanup();
        return 0;
    }

    //创建套接字
    SOCKET socketClient = socket(AF_INET,SOCK_DGRAM,0);
    
    //填充服务器socket信息
    SOCKADDR_IN addrServer;
    int nLength = sizeof(addrServer);
    addrServer.sin_family = AF_INET;
    //服务器的应用程序端口
    addrServer.sin_port = htons(6000);
    //服务器的IP地址,同一台电脑就是本地IP
    addrServer.sin_addr.S_un.S_addr = inet_addr("127.0.0.1");
    printf("开始通信:\n");
    while (true){
           //发送数据
    char szClientBuf[100];
	printf("Client:");//接收输入的数据
	scanf("%s",&szClientBuf);
    sendto(socketClient,szClientBuf,100,0,(SOCKADDR*)&addrServer,nLength);
    
    //接收数据
    char szRecvBuf[100] = {0};
    recvfrom(socketClient,szRecvBuf,100,0,(SOCKADDR*)&addrServer,&nLength);
    printf("From Server:%s\n", szRecvBuf);
	}   
    //关闭套接字
    closesocket(socketClient);
    //关闭winsocket库
    WSACleanup();

    system("pause");
    return 0;
}