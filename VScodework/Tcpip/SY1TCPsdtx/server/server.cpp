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
    
    //创建Socket套接字
    sServer =socket (AF_INET,SOCK_STREAM,IPPROTO_TCP);
    if(INVALID_SOCKET ==sServer){
        printf (" 创建Socket套接字失败 ! \n");
      
        return -1;
    }

    //设置服务器套接字地址
    SOCKADDR_IN addrServ;
    addrServ.sin_family = AF_INET;
    addrServ.sin_port = htons (9990); //监听端口为9990
    addrServ.sin_addr. S_un.S_addr =htonl(INADDR_ANY);
    
    //绑定
    retVal = bind(sServer,(const struct sockaddr*)&addrServ,sizeof(SOCKADDR_IN));
    if(SOCKET_ERROR== retVal){
        printf("绑定失败 ! \n");
        closesocket(sServer);
        WSACleanup() ;
        return -1;
    }

     //监听
    retVal = listen(sServer, 1);
	if (SOCKET_ERROR == retVal)
	{
		printf("监听失败  !\n"); closesocket(sServer); WSACleanup();
		return -1;
	}

    printf("TCP服务启动中……\n");
    sockaddr_in addrClient;//客户端地址
    int addrClientlen = sizeof(addrClient);
    sClient = accept(sServer,(sockaddr FAR*)&addrClient,&addrClientlen);
    if(INVALID_SOCKET == sClient){
        printf("连接失败 ! \n");
        closesocket(sServer);
        WSACleanup();
        return -1;
    }
     
       printf("Socket版本信息如下:\n");
       printf("Version:%d.%d\n",LOBYTE(wsd.wVersion),HIBYTE(wsd.wVersion));
       printf("HighVersion:%d.%d\n",LOBYTE(wsd.wHighVersion),HIBYTE(wsd.wHighVersion));
       printf("Decription:%s\n",wsd.szDescription);
       printf("SystemStatus:%s\n",wsd.szSystemStatus);
       printf("\n");
       printf("来自%s的连接成功!\n", inet_ntoa(addrClient.sin_addr));  
       printf("开始通信:\n");  

         //发送和接收
    while (true)
	{
		ZeroMemory(buf,BUF_SIZE);
		retVal = recv(sClient,buf,BUFSIZ,0);
        printf("客户端消息: %s\n" , buf);
		if (SOCKET_ERROR == retVal)
		{
			printf("接收失败 !\n");
			closesocket(sServer);
			closesocket(sClient);
			WSACleanup();
			return -1;
		}
		// SYSTEMTIME st;
		// GetLocalTime(&st);
		// char sDateTime[30];
		// sprintf(sDateTime,"%4d-%2d-%2d %2d:%2d:%2d",st.wYear,st.wMonth,st.wDay,st.wHour,st.wMinute,st.wSecond);
		// printf("%s,Recv From Client [%s:%d] :%s\n",sDateTime,inet_ntoa(addrClient.sin_addr),addrClient.sin_port,buf);

		if (strcmp(buf,"quit")==0)
		{
			retVal = send(sClient,"quit",strlen("quit"),0);
			break;
		}
		else
		{   
			char msg[BUF_SIZE];
			// sprintf(msg,"Message received - %s",buf);
            //向服务器发送数据
            printf("输入信息: ");//接收输入的数据
            std::string str;
            std::getline(std::cin,str);//将用户输入的数据复制到buf中
            ZeroMemory(msg, BUF_SIZE);
            strcpy(msg,str.c_str());//向服务器发送数据
			retVal = send(sClient,msg,strlen(msg),0);
			if (SOCKET_ERROR == retVal)
			{
				printf("发送失败 !\n");
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
