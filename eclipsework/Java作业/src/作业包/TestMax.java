package ��ҵ��;//������ɣ�����¼���������ݣ������������е����ֵ
import java.util.Scanner;
public class TestMax {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int num1,num2,num3,k;
		Scanner input=new Scanner(System.in);
		System.out.print("��������������");
		num1=input.nextInt();
		num2=input.nextInt();
		num3=input.nextInt();
		k=max(num1,num2,num3);
		System.out.println(num1+"��"+num2+"��"+num3+"�ϴ�ֵΪ"+k);
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
