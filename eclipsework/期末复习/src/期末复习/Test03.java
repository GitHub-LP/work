package ??ĩ??ϰ;

class Animal {
	void shout() {
		System.out.println("?????У?");
	}
}
class Dog extends Animal {
	void shout() {
		super.shout();
		System.out.println("????????");
	}
}
public class Test03 {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.shout();
	}
}
