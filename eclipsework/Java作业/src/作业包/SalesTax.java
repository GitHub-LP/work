package 作业包;
import java.util.Scanner;
public class SalesTax {
	public static void main (String[] args)
    {    
           Scanner input=new Scanner(System.in);
           System.out.print("请输入销售额：");
           double purchaseAmount=input.nextDouble();
           double tax=purchaseAmount*0.06;
           System.out.println("\"税额为\""+(int)(tax*100)/100.0);
    }
}
