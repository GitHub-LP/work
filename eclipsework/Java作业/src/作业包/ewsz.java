package 作业包;/*创建一个整型二维数组myList[4][3]（看作4行3列的矩阵）
并完成下列操作：用随机数初始化数组；输出全部元素（按行、列输出显示）；求出每行之和，
每列之和，并输出；求出全部元素的值之和，并输出*/
import java.util.Random;

public class ewsz {

	public static void main(String[] args) {
		int i,j,sum=0;
		int[][] mylist=new int[4][3];
		Random ran=new Random();
		for(i=0;i<mylist.length;i++)
		{
			for(j=0;j<mylist[i].length;j++)
			{		mylist[i][j]=ran.nextInt(10);
				System.out.print(mylist[i][j]+"\t");				
			}System.out.print("\n");			
		}		
		for(i=0;i<mylist.length;i++)
		{
			for(j=0;j<mylist[i].length;j++)
			{
				sum+=mylist[i][j];
			}
			System.out.print("第"+(i+1)+"行之和为"+sum+"\t");
			sum=0;
		}
		for(i=0;i<3;i++)
		{
			for(j=0;j<4;j++)
			{
				sum+=mylist[j][i];
			}
			System.out.print("第"+(i+1)+"列之和为"+sum+"\t");
			sum=0;
		}
		for(i=0;i<mylist.length;i++)
		{
			for(j=0;j<mylist[i].length;j++)
			{
				sum+=mylist[i][j];
			}		
	}System.out.print("总和为"+sum+"\n");
	}
}