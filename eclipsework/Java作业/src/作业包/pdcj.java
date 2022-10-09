package 作业包;/*编写一个程序，让用输入一个学生的百分制成绩，然后把它转换为五等制输出，
转换规则为90-100分为A等，80-89分为B等，70-79分为C等，60-69分为D等，0-59分为E等。*/

import java.util.Scanner;
public class pdcj {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("请输入学生成绩：");
		int cj=input.nextInt();
           if(90<=cj&&cj<=100)
        	  System.out.println("等级为A");
          else if(80<=cj&&cj<=89)
        	  System.out.println("等级为B");
          else if(70<=cj&&cj<=79)
        	  System.out.println("等级为C");
          else if(60<=cj&&cj<=69)
        	  System.out.println("等级为D");
          else if(0<=cj&&cj<=59)
        	  System.out.println("等级为E");
	}

}

