package ��ҵ��;/*����һ�����飬�洢5��ѧ���ɼ���100���ڵ���������
������ʱ��ʾ�û�����������г�ʼ���������ȫ��ѧ���ĳɼ�����߷֡�ƽ���֣�
ͳ�Ƴ�����ƽ���ֵ�������*/

import java.util.Scanner;

public class xscj {

	public static void main(String[] args) {
	    int i=0,x=0,y,count=0,max=0;
		int  mylist[]= new int[5];
		Scanner scanner=new Scanner(System.in);
        System.out.println("���������100���ڵ�����");
        mylist[i]=scanner.nextInt();    
      for(i=0;i<5;i++)
      { if(mylist[i]>max)
        {max=mylist[i];}
         x=x+mylist[i];
              
      }
      y=x/5; 
      for(i=0;i<5;i++)
      {  if(mylist[i]>y)
         count++;
      	}
      System.out.println("�ɼ�="+mylist[i]+"��߷�="+max+"ƽ����="+x/5+"����ƽ��������="+count);	
	}	 
}
