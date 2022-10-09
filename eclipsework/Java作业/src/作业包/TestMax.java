package 作业包;//方法完成：键盘录入三个数据，返回三个数中的最大值
import java.util.Scanner;
public class TestMax {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num1,num2,num3,k;
		Scanner input=new Scanner(System.in);
		System.out.print("请输入三个数：");
		num1=input.nextInt();
		num2=input.nextInt();
		num3=input.nextInt();
		k=max(num1,num2,num3);
		System.out.println(num1+"和"+num2+"和"+num3+"较大值为"+k);
	}
	public static int max(int x,int y,int z){
		int result;
		if(x>y&&x>z)
			result=x;
		else if(y>x&&y>z)
			result=y;
		 else
		 result=z;
		return result;
	}

}
