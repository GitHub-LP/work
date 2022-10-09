package 作业包;
	import java.util.Scanner;
	public class ScannerTest {
		
		public static void main (String[] args)
	    {      byte num;
	           double dNum;
	           Scanner scanner=new Scanner(System.in);
	           System.out.println("请输入一个数：");
	           num=scanner.nextByte();
	           System.out.println("请输入一个小数：");
	           dNum=scanner.nextDouble();
	           System.out.println("num="+num+",dNum="+dNum);
	    }
}
