package ��ĩ��ϰ;

class Student{
	private String name;
	private int score;
	public Student() {}
	public Student(String name,int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

public class Test02 {
	public static void main(String[] args) {
		Student stu1 = new Student();
		Student stu2 = new Student("����",90);
		stu1.setName("����");
		stu1.setScore(80);
		System.out.println(stu1.getName() + ":" + stu1.getScore());
		System.out.println(stu2.getName() + ":" + stu2.getScore());
	}
}
