package ÆÚÄ©¸´Ï°;

class ArraySum{
	int a[] = {12,14,8};
	int sum(){
		int s=0;
		for(int i=0;i<3;i++)
			s=s+a[i];
		return s;
	}
}
public class Test05 {
	public static void main(String[] args) {
		System.out.println(new ArraySum().sum());
	}
}

