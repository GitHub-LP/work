package chap02;

public class Mppx{
public static void main( String[]args){
      int[]array= {12,3,45,6,78,9,22,2};
      bubbleSort(array);//���ã�ʵʩð������
      display(array);
}
//���
   public static void display(int a[]){
      for(int i=0;i<a.length;i++)
          System.out.print(a[i]+",");
       System.out.println();//����
}
//ð������
   public static void bubbleSort( int[]a){
	        int temp;
		   boolean flag=true; //��ʼ
		   for(int i=1;i<a.length&&flag;i++){//��ÿһ�˷���
		   boolean flag1=false;//����������
		   for(int j=0; j<a.length-i; j++)
		   if( a[j]>a[j+1]){//����Ԫ�أ��������򽻻�
		     temp=a[j];
		     a[j]=a[j+1];
		     a[j+1]=temp;
		      flag1=true;//�н�������ʾ����
		   }
	}
  }
}