#include "stdafx.h"
#include<winsock2.h>
#include<stdio.h>
#pragma comment(lib, "ws2_32.lib");

int main()
{
    char ipStr[20] = {0},subNetMask[20] = {0};
    ULONG ulip , ulMask;  //保存IP和子网掩码的长整型值
    cout << "Input the IP address:";
    cin >> ipStr;
    cout << "Input subNetMask:";
    cin >> subNetMask;
    ulip = inet_addr(ipStr);
    ulMask = inet_addr(subNetMask);
    if(ulip == INADDR_NONE || ulMask == INADDR_NONE)  //无效的子网掩码或IP，返回
    return 0;
    ULONG netWorkAddr = ulip & ulMask;   //求网络地址，该地址为网络字节格式
    ULONG broadCastAdd = ulip | (~ulMask);  //求广播地址，该地址为网络字节格式
    char *strIp;
    in_addr inaddr;
    //求网络地址的字符串形式
    inAddr.S_un.S_addr = netWorkAddr;
    strIp=inet_ntoa(inAddr);
    cout << "NetWork Address:"<<strIp<<end1;
    //求广播地址的字符串形式
    inAddr.S_un.S_addr = broadCastAdd;
    strIp=inet_ntoa(inAddr);
    cout<<"BroadCast Address:" << strIp<<end1;
    //求主机地址个数
    ULONG hostNum = ntoh1(broadCastAdd)-ntoh1(netWorkAddr)-1;
    cout<<"Host number:"<<hostNum<<end1;
    //求主机地址列表
    cout << "Ips in the subnet:"<<end1;
    ULONG hostIp = ntoh1(netWorkAddr);  //将IP地址转换或主机字节格式
    ULONG netIp = 0;
    for (UINT i=1; i<=hostNum;i++)
    {
        hostIp = hostIp+1;
        //将主机字节格式hosstIp转化成字符串格式，并显示
        intAdd.S_un.S_addr=hton1(hoseIp);
        strIp=inet_ntoa(inAddr);
        cunt << strIp << end1;
    }
    system("pause");
    return 0;
}