package ��ļ̳�;


class Rectangle{
	double length;
	double width;
	double Area;
	public Rectangle(){
		System.out.println("�������=");

	}
	public Rectangle(double length,double width){
		this.length=length;
		this.width=width;
	}
	public double getArea(){
		 Area=length*width;
         return Area; 
	}

}
class Cuboid extends  Rectangle{
	double hight;
	double Volume;
	double super_area;
	
	public Cuboid(double length,double width,double hight,double Volume){
	    super(length,width);
		this.hight=hight;
		}
	public double getVolume() {
		Volume=Area*hight;
		return Volume;
	    }
	public double getsupArea() {
		super_area=2*(length*width+length*hight+width*hight);
		return super_area;
	    }
	
}

public class Test {

	private static int length;
	private static int width;
	private static int hight;

	public static void main(String[] args) {		
		// TODO ??????????????
		Cuboid c=new Cuboid(length= 5,width= 6,hight= 7, hight);
	     System.out.println("���="+c.getArea());
	     System.out.println("�ܳ�="+c.getsupArea());
	     System.out.println("���="+c.getVolume());
	}

}
