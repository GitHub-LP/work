package chap02;

public class BruteForceSort{
public static void main( String[]args){
      int[]array= {12,3,45,6,78,9,22,2};
      selectSort(array);//���ã�ʵʩѡ������
      //bubbleSort(array);//���ã�ʵʩð������
      display(array);
}
//���
   public static void display(int a[]){
      for(int i=0;i<a.length;i++)
          System.out.print(a[i]+",");
          System.out.println();//����
}
//ѡ������
   public static void selectSort(int[] a){
      for(int i=0;i<a.length-1;i++ ){    // n-1������
       //��ʣ������������С��
       int min=i;
       for(int j=i+1;j<a.length;j++ )
             if (a[j]<a[min] )
                  min = j;
              //������ʣ�����е���λ
              int temp = a[i];
               a[i] = a[min];
               a[min] =temp;
       } 
    }
   
  public static void bubbleSort( int[]a){ //ð������
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
