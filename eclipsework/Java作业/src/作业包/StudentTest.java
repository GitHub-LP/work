package ��ҵ��;

class Student {
          String name;
          int age;
	public Student(String con_name, int con_age){
		name = con_name;
		age = con_age;
	}
     
	public Student(String con_name){
		name = con_name;
	}
	public Student(int con_age){
		age = con_age;
	}
	public void speak(){
		  System.out.println("����"+name+",����"+age+"��");
	}
}
public class StudentTest{
	public static void main(String[] args){
		Student p1 =new Student("����");
		Student p2 =new Student("����",19);
		Student p3 =new Student("ddd",26);
		Student p4 =new Student(null, 0);
		p4.age=20;
		p4.name="aaa";
		
		p1.speak();
		p2.speak();
		p3.speak();
		p4.speak();
	}
}


