package ��ҵ��;/*��дһ��������������һ��ѧ���İٷ��Ƴɼ���Ȼ�����ת��Ϊ����������
ת������Ϊ90-100��ΪA�ȣ�80-89��ΪB�ȣ�70-79��ΪC�ȣ�60-69��ΪD�ȣ�0-59��ΪE�ȡ�*/

import java.util.Scanner;
public class pdcj {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("������ѧ���ɼ���");
		int cj=input.nextInt();
           if(90<=cj&&cj<=100)
        	  System.out.println("�ȼ�ΪA");
          else if(80<=cj&&cj<=89)
        	  System.out.println("�ȼ�ΪB");
          else if(70<=cj&&cj<=79)
        	  System.out.println("�ȼ�ΪC");
          else if(60<=cj&&cj<=69)
        	  System.out.println("�ȼ�ΪD");
          else if(0<=cj&&cj<=59)
        	  System.out.println("�ȼ�ΪE");
	}

}

