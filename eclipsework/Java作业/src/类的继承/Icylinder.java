package ��ļ̳�;

public class Icylinder {
	final double ��=3.14;
	double high;
	double radius;
	
	public void cylinder(){}
	public void cylinder(double h,double r){
		radius=r;
		high=h;
	}
	public double area(){
		double a;
		a=2*3.14*radius*radius+high*2*3.14*radius;
		return a;
		
	}
	public double bulk(){
		double v;
		int width;
		int length;
		v=length*width*high;
		return v;
	}
	public class testinterface{
		
		public void main(String){
			cylinder cyl1=new cylinder(2.0,5.6);
			cuboid cub1=new cuboid(3.2,1.5,8.1);
			System.out.println("Բ����ı����:"+cyl1.area());
			System.out.println("Բ��������:"+cyl1.bulk());
		}
	}
	
	
