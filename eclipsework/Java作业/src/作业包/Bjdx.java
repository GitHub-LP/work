package 作业包;
import java.util.Scanner;
public class Bjdx {

		public static void main(String[] args) {
			int y;
			Scanner input=new Scanner(System.in);
			System.out.print("请输入两个数：");
			int n=input.nextInt();
			int m=input.nextInt();
            y=(n>m)?n:m;
            System.out.println("最大值为"+y);
	}
}

