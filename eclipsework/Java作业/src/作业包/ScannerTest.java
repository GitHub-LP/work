package ��ҵ��;
	import java.util.Scanner;
	public class ScannerTest {
		
		public static void main (String[] args)
	    {      byte num;
	           double dNum;
	           Scanner scanner=new Scanner(System.in);
	           System.out.println("������һ������");
	           num=scanner.nextByte();
	           System.out.println("������һ��С����");
	           dNum=scanner.nextDouble();
	           System.out.println("num="+num+",dNum="+dNum);
	    }
}
