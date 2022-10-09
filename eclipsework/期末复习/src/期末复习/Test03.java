package ÆÚÄ©¸´Ï°;

class Animal {
	void shout() {
		System.out.println("¶¯Îï½Ğ£¡");
	}
}
class Dog extends Animal {
	void shout() {
		super.shout();
		System.out.println("ÍôÍô¡­¡­");
	}
}
public class Test03 {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.shout();
	}
}
