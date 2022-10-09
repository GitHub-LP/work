package 作业包;//输入一个整数判断奇数偶数
import java.util.Scanner;
public class shu {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("请输入一个整数：");
		int score=input.nextInt();
          if(score%2==0)
        	  System.out.println("这是一个偶数");
        	  else
        		  System.out.println("这是一个奇数") ;
	}

}
