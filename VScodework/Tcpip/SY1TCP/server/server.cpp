#include "stdafx.h"   //默认包含的头文件，用于实现头文件的预编译
#include <WINSOCK2.H> //用于管理Windows Sockets版本2函数的头文件
#include <string> //程序中使用到std:: string
#include <iostream>//用于管理输入输出流的头文件
#pragma comment(lib,"WS2_32.lib")
#define BUF_SIZE 64  //缓冲区大小
int _tmain(int argc, _TCHAR* argv[]){
    WSADATA wsd;   // WSADATA变量，用于初始化WindowsSocket
    SOCKET sServer;//服务器套接字，用于监听客户端请求
    SOCKET sClient;//客户端套接字，用于实现与客户端的通信
    int retVal;//调用各种Socket函数的返回值
    char buf[BUF_SIZE];//用于接受客户端数据的缓冲区
    
    //初始化套接字动态库
    if(WSAStartup(MAKEWORD(2,2),&wsd) != 0){
        printf("WSAStartup failed ! \n");
        return 1;
    }
    
    //创建用于监听的套接字
    sServer =socket (AF_INET,SOCK_STREAM,IPPROTO_TCP);
    if(INVALID_SOCKET ==sServer){
        printf (" socket failed ! \n");
      
        return -1;
    }

    //设置服务器套接字地址
    SOCKADDR_IN addrServ;
    addrServ.sin_family = AF_INET;
    addrServ.sin_port = htons (9990); //监听端口为9990
    addrServ.sin_addr. S_un.S_addr =htonl(INADDR_ANY);

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
    printf("TCP Server start. . . \n");
    
    sockaddr_in addrClient;//客户端地址
    int addrClientlen = sizeof(addrClient);
    sClient = accept(sServer,(sockaddr FAR*)&addrClient,&addrClientlen);
    if(INVALID_SOCKET == sClient){
        printf("accept failed ! \n");
        closesocket(sServer);
        WSACleanup();
        return -1;
    }
     //123
    while (true)
	{
		ZeroMemory(buf,BUF_SIZE);
		retVal = recv(sClient,buf,BUFSIZ,0);
		if (SOCKET_ERROR == retVal)
		{
			printf("recv failed !\n");
			closesocket(sServer);
			closesocket(sClient);
			WSACleanup();
			return -1;
		}
		SYSTEMTIME st;
		GetLocalTime(&st);
		char sDateTime[30];
		sprintf(sDateTime,"%4d-%2d-%2d %2d:%2d:%2d",st.wYear,st.wMonth,st.wDay,st.wHour,st.wMinute,st.wSecond);
		printf("%s,Recv From Client [%s:%d] :%s\n",sDateTime,inet_ntoa(addrClient.sin_addr),addrClient.sin_port,buf);
		if (strcmp(buf,"quit")==0)
		{
			retVal = send(sClient,"quit",strlen("quit"),0);
			break;
		}
		else
		{
			char msg[BUF_SIZE];
			sprintf(msg,"Message received - %s",buf);
			retVal = send(sClient,msg,strlen(msg),0);
			if (SOCKET_ERROR == retVal)
			{
				printf("send failed !\n");
				closesocket(sServer);
				closesocket(sClient);
				WSACleanup();
				return -1;
			}
		}
	}
    //释放套接字
    closesocket(sServer);
    closesocket(sClient);
    WSACleanup();
   
    //暂停，按任意键退出
    system("pause");
    return 0;

}
