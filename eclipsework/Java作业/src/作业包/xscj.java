package 作业包;/*创建一个数组，存储5个学生成绩（100以内的整数），
在运行时提示用户键盘输入进行初始化；再输出全部学生的成绩、最高分、平均分，
统计出超过平均分的人数。*/

import java.util.Scanner;

public class xscj {

	public static void main(String[] args) {
	    int i=0,x=0,y,count=0,max=0;
		int  mylist[]= new int[5];
		Scanner scanner=new Scanner(System.in);
        System.out.println("请输入五个100以内的数：");
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
      System.out.println("成绩="+mylist[i]+"最高分="+max+"平均分="+x/5+"超出平均分人数="+count);	
	}	 
}
