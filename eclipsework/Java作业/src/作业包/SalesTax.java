package ��ҵ��;
import java.util.Scanner;
public class SalesTax {
	public static void main (String[] args)
    {    
           Scanner input=new Scanner(System.in);
           System.out.print("���������۶");
           double purchaseAmount=input.nextDouble();
           double tax=purchaseAmount*0.06;
           System.out.println("\"˰��Ϊ\""+(int)(tax*100)/100.0);
    }
}
