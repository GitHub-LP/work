#include "stdafx.h" //默认包含的头文件，用于实现头文件的预编译
#include <WinSock2.h> //用于管理Windows Sockets版本2函数的头文件
#include <string> 
#include <iostream> //用于管理输入输出流的头文件
#pragma comment(lib,"WS2_32.lib")
#define BUF_SIZE 64 //缓冲区大小

int _tmain(int argc, _TCHAR* argv[])
{  
    WSADATA wsaData; //用于初始化Windows Socket
    SOCKET sHost;//与服务器进行通信的套接字
    SOCKADDR_IN servAddr;//服务器地址
    char buf[BUF_SIZE];//用于接受数据缓冲区
    int retVal;//调用各种Socket函数的返回值
   
     //初始化套接字动态库
    int iResult = WSAStartup(MAKEWORD(2,2), &wsaData);
    if (iResult != NO_ERROR)
    printf("Error at WSAStartup()\n");
    
    //创建Socket
     sHost = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if( sHost == INVALID_SOCKET)
    {
        printf("Error at socket(): %ld\n", WSAGetLastError());
        WSACleanup();
        return -1;
    } 

    servAddr.sin_family = AF_INET; //设置服务器地址
    servAddr.sin_addr. S_un. S_addr =inet_addr("127.0.0.1"); //用户需要根据实际情况修改,填写自己本机IP
    servAddr.sin_port = htons (9990); //在实际应用中，建议将服务器的IP地址和端口号保存在配置文件中
    int sServerAddlen = sizeof(servAddr); //计算地址的长度

    int iMode = 1;
    retVal=ioctlsocket( sHost, FIONBIO, (u_long FAR*) &iMode);
    if(retVal == SOCKET_ERROR)
    {
        printf("ioctlsocket failled !\n");
        WSACleanup();
        return -1;
    }

    
    //循环等待
    while(true)
    {   //连接服务器
        retVal = connect(sHost,(LPSOCKADDR) &servAddr,sizeof(servAddr));
        if(SOCKET_ERROR == retVal)
        {
            int err = WSAGetLastError();
            if(err == WSAEWOULDBLOCK || err == WSAEINVAL)
            {
                //Sleep(500);
                continue;
            }
            else if(err == WSAEISCONN)  //已建立连接
            {
                break;
            }
            else
            {
                printf("connection failed !\n");
                closesocket(sHost);
                WSACleanup();
                return -1;
            }
        }
    }
     //循环向服务器发送字符串，并显示反馈信息。
    //发送quit将使服务器程序退出，同时客户端程序自身也将退出
    while(true)
    {   //向服务器发送数据
        printf("please input a string to send:");
        //接收输入的数据
        std::string str;
        std::getline(std::cin, str);
        //将用户输入的数据复制到buf中
        ZeroMemory(buf,BUF_SIZE);
        strcpy(buf,str.c_str());
        //循环等待
        while(true)
        {
            retVal = send(sHost,buf,strlen(buf),0);
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
                    closesocket(sHost);
                    WSACleanup();
                    return -1;
                }
           }
           break;
        }
        while(true)
        {
            ZeroMemory(buf,BUF_SIZE);
            retVal = recv(sHost,buf,sizeof(buf)+1,0);
            if(SOCKET_ERROR == retVal)
            {
                int err = WSAGetLastError();
                if(err == WSAEWOULDBLOCK)
                {
                    Sleep(100);
                    printf("waiting back msg !\n");
                    continue;
                }
                else if(err == WSAETIMEDOUT || err == WSAENETDOWN)
                {
                    printf("recv failed !\n");
                    closesocket(sHost);
                    WSACleanup();
                    return -1;
                }
                break;
            }
            break;
        }
        //ZeroMemory(buf,BUF_SIZE);
        //retVal = recv(sHost,buf,sizeof(buf)+1,0);
        printf("Recv From Server: %s\n",buf);
        //如果收到quit，则退出
        if(strcmp(buf,"quit") == 0 )
        {
            printf("quit !\n");
            break;
        }
    }   
}    
