package ��ҵ��;/*�����û���������һ����λ��������������ʽ��
���û�����1ʱ���ɼӷ����㣬���û�����2ʱ���ɼ������㣬���û�����
3ʱ���ɳ˷����㣨���֧if��䣩�������������*/
import java.util.*;
public class Szys {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int num1,num2,num3;
		Random ran=new Random(); 
		num1=(int)(ran.nextDouble()*10);
		num2=(int)(ran.nextDouble()*10);		
		System.out.print("������123����һ����");
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
	



