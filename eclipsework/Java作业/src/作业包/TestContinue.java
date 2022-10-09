package 作业包;
import java.util.Scanner;
public class TestContinue {
	
	public static void main(String[] args) {
		int sum=0,i,n=0;
        Scanner input=new Scanner(System.in);
        for(i=1;i<=100;i++)
        {  if(i%5!=0)
     	   {sum=sum+i;
     	    n++;
     	   }
        }
        System.out.println("和为"+sum+" 次数为"+n);
	}

}
