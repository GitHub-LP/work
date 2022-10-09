package 作业包;//重载求图形的面积的方法getArea，可以分别针对圆、矩形、梯形求面积，并在main方法中进行测试

import java.util.Scanner;
public class Zzqtxmj {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println();
		double bj,k,g,sd,xd,tg,y,jx,tx;
		Scanner input=new Scanner(System.in);
		System.out.print("请输入圆的半径：");
		bj=input.nextInt();
		System.out.print("请输入矩形宽和高：");
		k=input.nextInt();g=input.nextInt();
		System.out.print("请输入梯形的上底下底和高：");
		sd=input.nextInt();xd=input.nextInt();tg=input.nextInt();
		y=getArea(bj);
		jx=getArea(k,g);
		tx=getArea(sd,xd,tg);
		System.out.println("圆的面积"+y);
		System.out.println("矩形的面积"+jx);
		System.out.println("梯形的面积"+tx);
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
