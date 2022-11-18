#include "stdafx.h"
#include <Winsock2.h>


int _tmain(int argc, _TCHAR* argv[])
{
    WORD dwVersionReq = MAKEWORD(1,1);
    WSAData wsData = {0};
    //加载套接字库
    if (0 != WSAStartup(dwVersionReq,&wsData))
    {
        WSACleanup();
        return 0;
    }
    //socket版本确认
    if (LOBYTE(wsData.wVersion) != 1 || HIBYTE(wsData.wVersion != 1))
    {
        WSACleanup();
        return 0;
    }

    //创建服务套接字
    SOCKET socketSrv = socket(AF_INET,SOCK_DGRAM,0/*自动选择协议*/);

    //对socket绑定端口号和IP地址
    SOCKADDR_IN addrServer;
    addrServer.sin_family = AF_INET;
    addrServer.sin_port = htons(6000);
    addrServer.sin_addr.S_un.S_addr = htonl(ADDR_ANY);
    bind(socketSrv,(SOCKADDR*)&addrServer,sizeof(addrServer));


    //保存client端socket信息
    SOCKADDR_IN addClient;
    int len = sizeof(SOCKADDR_IN);
       printf("Socket版本信息如下:\n");
       printf("Version:%d.%d\n",LOBYTE(wsData.wVersion),HIBYTE(wsData.wVersion));
       printf("HighVersion:%d.%d\n",LOBYTE(wsData.wHighVersion),HIBYTE(wsData.wHighVersion));
       printf("Decription:%s\n",wsData.szDescription);
       printf("SystemStatus:%s\n",wsData.szSystemStatus);
       printf("\n");
       printf("来自127.0.0.1的连接成功!\n");  
       printf("开始通信:\n");  
    while (1)
    {
        //等待并接收数据
        char szBuffer[100] = {0};
        recvfrom(socketSrv,szBuffer,100,0,(SOCKADDR*)&addClient,&len);
        printf("From client:%s\n",szBuffer);
        if (strcmp(szBuffer,"quit")==0)
		{
			send(socketSrv,"quit",strlen("quit"),0);
            printf("结束通信\n");
			break;
		}
        else{
              //发送数据
        char szSendBuf[100];
		printf("server:");//接收输入的数据
		scanf("%s",&szSendBuf);
        sendto(socketSrv, szSendBuf, 100,0,(SOCKADDR*)&addClient,len);
        }
    }
    //关闭套接字
    closesocket(socketSrv);
    //关闭winsocket库
    WSACleanup();
    system("pause");
    return 0;
}