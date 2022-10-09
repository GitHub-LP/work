package 类的继承;

public class Icylinder {
	final double Π=3.14;
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
			System.out.println("圆柱体的表面积:"+cyl1.area());
			System.out.println("圆柱体的体积:"+cyl1.bulk());
		}
	}
	
	
