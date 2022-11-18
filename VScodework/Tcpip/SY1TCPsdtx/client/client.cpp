#include "stdafx.h"   //默认包含的头文件，用于实现头文件的预编译
#include <WINSOCK2.H> //用于管理Windows Sockets版本2函数的头文件
#include <string> //程序中使用到std:: string
#include <iostream>//用于管理输入输出流的头文件
#pragma comment(lib,"WS2_32.1ib")
#define BUF_SIZE 64  //缓冲区大小

int _tmain(int argc,_TCHAR* argv[]){
    WSADATA wsd; //用于初始化Windows Socket
    SOCKET sHost;//与服务器进行通信的套接字
    SOCKADDR_IN servAddr;//服务器地址
    char buf[BUF_SIZE];//用于接受数据缓冲区
    int retVal;//调用各种Socket函数的返回值

    //初始化套接字动态库
    if(WSAStartup(MAKEWORD(2,2),&wsd) != 0){
        printf("WSAStartup failed ! \n");
        return 1;
      }

    //创建Socket
    sHost = socket(AF_INET, SOCK_STREAM,IPPROTO_TCP);
    if(INVALID_SOCKET == sHost){
      printf(" socket failed !\n");
      WSACleanup();
      return -1;
    }

    servAddr. sin_family = AF_INET; //设置服务器地址
    servAddr. sin_addr. S_un. S_addr =inet_addr("127.0.0.1"); //用户需要根据实际情况修改,填写自己本机IP
    servAddr. sin_port = htons (9990); //在实际应用中，建议将服务器的IP地址和端口号保存在配置文件中
    int sServerAddlen = sizeof(servAddr); //计算地址的长度

    //连接服务器
    retVal =connect(sHost,(LPSOCKADDR)&servAddr, sizeof(servAddr));
    if(SOCKET_ERROR== retVal){
      printf("连接失败! \n");
      closesocket(sHost);
      WSACleanup();
      return -1;
    }

    //循环向服务器发送字符串，并显示反馈信息。
    //发送quit将使服务器程序退出，同时客户端程序自身也将退出
    while(true)
    { 
      char msg[BUF_SIZE];
      //向服务器发送数据
      printf("输入信息: ");//接收输入的数据
      std::string str;
      std::getline(std::cin,str);//将用户输入的数据复制到buf中
      ZeroMemory(msg, BUF_SIZE);
      strcpy(msg,str.c_str());//向服务器发送数据
      retVal = send(sHost, msg,strlen(msg), 0);
      if(SOCKET_ERROR== retVal){
        printf("发送失败 ! \n");
        closesocket(sHost);
        WSACleanup() ;
        return -1;
      }
    ZeroMemory(buf,BUF_SIZE);
    //接收服务器回传的数据
    retVal = recv(sHost,buf,BUFSIZ,0);
    printf("服务器消息: %s\n" , buf);
    //如果收到quit，则退出
    if(strcmp(buf,"quit") == 0){
      printf(" quit! \n");
       break;
    }
}

  //释放资源
  closesocket(sHost);WSACleanup() ;
  //暂停，按任意键继续system("pause");
  return 0;
}
