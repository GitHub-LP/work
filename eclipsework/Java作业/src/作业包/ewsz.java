package ��ҵ��;/*����һ�����Ͷ�ά����myList[4][3]������4��3�еľ���
��������в��������������ʼ�����飻���ȫ��Ԫ�أ����С��������ʾ�������ÿ��֮�ͣ�
ÿ��֮�ͣ�����������ȫ��Ԫ�ص�ֵ֮�ͣ������*/
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
			System.out.print("��"+(i+1)+"��֮��Ϊ"+sum+"\t");
			sum=0;
		}
		for(i=0;i<3;i++)
		{
			for(j=0;j<4;j++)
			{
				sum+=mylist[j][i];
			}
			System.out.print("��"+(i+1)+"��֮��Ϊ"+sum+"\t");
			sum=0;
		}
		for(i=0;i<mylist.length;i++)
		{
			for(j=0;j<mylist[i].length;j++)
			{
				sum+=mylist[i][j];
			}		
	}System.out.print("�ܺ�Ϊ"+sum+"\n");
	}
}