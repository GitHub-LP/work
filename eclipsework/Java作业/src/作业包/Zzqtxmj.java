package ��ҵ��;//������ͼ�ε�����ķ���getArea�����Էֱ����Բ�����Ρ����������������main�����н��в���

import java.util.Scanner;
public class Zzqtxmj {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println();
		double bj,k,g,sd,xd,tg,y,jx,tx;
		Scanner input=new Scanner(System.in);
		System.out.print("������Բ�İ뾶��");
		bj=input.nextInt();
		System.out.print("��������ο�͸ߣ�");
		k=input.nextInt();g=input.nextInt();
		System.out.print("���������ε��ϵ��µ׺͸ߣ�");
		sd=input.nextInt();xd=input.nextInt();tg=input.nextInt();
		y=getArea(bj);
		jx=getArea(k,g);
		tx=getArea(sd,xd,tg);
		System.out.println("Բ�����"+y);
		System.out.println("���ε����"+jx);
		System.out.println("���ε����"+tx);
	}
	public static double getArea(double banjin){ 
		return 3.14*(banjin*banjin);
	}
	public static double getArea(double kuan,double gao){
		return kuan*gao;
	}
	public static double getArea(double sandi,double xiadi,double gao){
		return (sandi+xiadi)*gao/2;
	}
}
