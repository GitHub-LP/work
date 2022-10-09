package 作业包;
import java.util.Random;
import java.util.Scanner;
public class paixu {
	public static void main(String[] args){
		   int[] nums=new int[10];
	        int temp;
	        Random ran=new Random();
	        Scanner s=new Scanner(System.in);
	        System.out.println("随机生成的数组为：");
	        for(int i=0;i<10;i++)
	        {  nums[i]=ran.nextInt(100);
	           System.out.print(nums[i]+" ");
	        }
	        System.out.println();
	        for(int i=1;i<10;i++)
	        {  int j;
	           temp=nums[i];
	           for(j=0;j<i;j++)
	           {  if(nums[j]>nums[i])
	        	   break;
	           }
	           if(j<i)
	           {  for(int k=i-1;k>=j;k--)
	        	   nums[k+1]=nums[k];
	           }
	           nums[j]=temp;
	        }
	        System.out.println("排序后的数组为：");
	        for(int i=0;i<10;i++)
	        {  System.out.print(nums[i]+" ");	
	        }
		}
	}
