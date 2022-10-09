package 作业包;
import java.util.Random;

public class Sjscs {
	public static void main(String[] args) {
		int num1,num2,x=1;
		Random ran=new Random();
		while(x>0)
		{   num1=ran.nextInt(100);
		    num2=ran.nextInt(100);
			if(num1==num2)
			{   System.out.println("一号随机数"+num1+"与二号随机数"+num2+"重复\t");
			    break;      }			
			System.out.println(num1+"\t"+num2);			
		}
	}
}