package ��ҵ��;

import java.util.Scanner;

public class TestBreak {

	public static void main(String[] args) {
		int sum=0,i;
	
		for(i=0;i<=20;i++)
		{   if(sum+i>=100)
			 break;
			 sum=sum+i;
		    
				}
		System.out.println(sum);   
	}

}
