package 作业包;//编写一个程序读入任意个整数,并把他们加起来,而输入0（则标记数就是０）标志输入结束

import java.util.Scanner;

public class Ryqh {
       
	public static void main(String[] args) {
		int sum=0;
		Scanner input=new Scanner(System.in);
		System.out.print("请输入任意个数以0结尾：");
		int x=input.nextInt();
		while(x!=0)
		{  sum=sum+x;
		   System.out.println("和为"+sum);   
		   x=input.nextInt();      }
		
	}

}
