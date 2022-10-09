package 作业包;/*根据用户输入生成一个个位数的四则运算表达式，
当用户输入1时生成加法运算，当用户输入2时生成减法运算，当用户输入
3时生成乘法运算（多分支if语句），并输出计算结果*/
import java.util.*;
public class Szys {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int num1,num2,num3;
		Random ran=new Random(); 
		num1=(int)(ran.nextDouble()*10);
		num2=(int)(ran.nextDouble()*10);		
		System.out.print("请输入123任意一个：");
		int score=input.nextInt();
          if(score==1)
          { num3=num1+num2;
        	  System.out.println(num1+"+"+num2+"="+num3);}
          else if(score==2)
          {  num3=num1-num2;
        	  System.out.println(num1+"-"+num2+"="+num3);}
          else if(score==3)
          { num3=num1*num2;
        	  System.out.println(num1+"*"+num2+"="+num3);}
	}
}
	



