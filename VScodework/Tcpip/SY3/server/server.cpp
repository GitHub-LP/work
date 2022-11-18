#include "stdafx.h" //默认包含的头文件，用于实现头文件的预编译
#include <WinSock2.h> //用于管理Windows Sockets版本2函数的头文件
#include <string> 
#include <iostream> //用于管理输入输出流的头文件
#pragma comment(lib,"WS2_32.lib")
#define BUF_SIZE 64 //缓冲区大小

int _tmain(int argc, _TCHAR* argv[])
{   
    WSADATA wsaData;   //WSADATA变量，用于初始化WindowsSocket
    SOCKET sServer;//服务器套接字，用于监听客户端请求
    SOCKET sClient;//客户端套接字，用于实现与客户端的通信
    int retVal;//调用各种Socket函数的返回值
    char buf[BUF_SIZE];//用于接受客户端数据的缓冲区

    //初始化套接字动态库
    int iResult = WSAStartup(MAKEWORD(2,2), &wsaData);
    if (iResult != NO_ERROR)
    printf("Error at WSAStartup()\n");
    
    //创建用于监听的套接字
    sServer = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (sServer == INVALID_SOCKET){
        printf("Error at socket(): %ld\n", WSAGetLastError());
        WSACleanup();
        return -1;
    } 
    
     //设置服务器套接字地址
    SOCKADDR_IN addrServ;
    addrServ.sin_family = AF_INET;
    addrServ.sin_port = htons (9990); //监听端口为9990
    addrServ.sin_addr.S_un.S_addr =htonl(INADDR_ANY);
   
    retVal = bind(sServer,(const struct sockaddr*)&addrServ,sizeof(SOCKADDR_IN));
    if(SOCKET_ERROR== retVal){
        printf("bind failed ! \n");
        closesocket(sServer);
        WSACleanup() ;
        return -1;
    }

      retVal = listen(sServer, 1);
	if (SOCKET_ERROR == retVal)
	{
		printf("listen failed  !\n"); 
        closesocket(sServer); 
        WSACleanup();
		return -1;
	}

    int iMode = 1;
    retVal=ioctlsocket(sServer, FIONBIO, (u_long FAR*) &iMode);
    if(retVal == SOCKET_ERROR)
    {
        printf("ioctlsocket failled !\n");
        WSACleanup();
        return -1;
    }

    printf("TCP Server start...\n");
    sockaddr_in addrClient;
    int addrClientlen = sizeof(addrClient);
    while(true)
    {
        sClient = accept(sServer,(sockaddr FAR*) &addrClient,&addrClientlen);
        if(INVALID_SOCKET == sClient)
        {
            int err = WSAGetLastError();
            if(err == WSAEWOULDBLOCK)
            {
                Sleep(100);
                continue;
            }
            else
            {
                printf("accept failed !\n");
                closesocket(sServer);
                WSACleanup();
                return -1;
            }
        }
        break;
    }

    while(true)
    {   
        ZeroMemory(buf,BUF_SIZE);
        retVal = recv(sClient,buf,BUF_SIZE,0);

        if(SOCKET_ERROR == retVal)
        {
            int err = WSAGetLastError();
            if(err == WSAEWOULDBLOCK)
            {
                Sleep(100);
                continue;
            }
            else if(err == WSAETIMEDOUT || err == WSAENETDOWN)
            {
                printf("recv failed !\n");
                closesocket(sServer);
                closesocket(sClient);
                WSACleanup();
                return -1;
            }

        }

        SYSTEMTIME st;
        GetLocalTime(&st);
        char sDateTime[30];
        sprintf(sDateTime,"%4d-%2d-%2d %2d:%2d:%2d",st.wYear,st.wMonth,st.wDay,st.wHour,st.wMinute,st.wSecond);
		//打印输出的信息
        printf("%s,Recv From Client [%s:%d] :%s\n",sDateTime, inet_ntoa(addrClient.sin_addr),addrClient.sin_port, buf);
        //如果客户端发送"quit"字符串，则服务器退出
        if(strcmp(buf, "quit") == 0)
        {
            retVal = send(sClient,"quit",strlen("quit"),0);
            break;
        }
		//否则向客户端发送回显字符串
        else
        {
            char msg[BUF_SIZE];
            sprintf(msg, "Message received - %s", buf);
            while(true)
            {
                retVal = send(sClient,msg, strlen(msg),0);
                if(SOCKET_ERROR == retVal)
                 {
                    int err = WSAGetLastError();
                    if(err == WSAEWOULDBLOCK)
                    {
                        Sleep(500);
                        continue;
                    }
                    else 
                    {
                        printf("send failed !\n");
                        closesocket(sServer);
                        closesocket(sClient);
                        WSACleanup();
                        return -1;
                    }

                }
                break;
            }
        }
    }
}