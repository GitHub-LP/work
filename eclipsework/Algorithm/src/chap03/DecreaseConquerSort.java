package chap03;

public class DecreaseConquerSort {
      public static void main(String[] args) {
          int[] a= {1,5,3,2,8,6,9,7,0,4};
          insertSort(a);//���ú���������
          display(a);//����б�
     }
    //��������     
      public static void insertSort(int[] a) {
    	//�ӵ�2��Ԫ�ؿ�ʼ�����β��뵽ǰ�������������
    	  int j;
    	  for(int i=1;i<a.length;i++){ 
    		   int temp = a[i]; //�ݴ�   
    		  for(j=i-1;j>=0&&temp>a[j];j--)//Ѱ�Ҳ���λ��
    			  a[j+1]=a[j];//һ��Ѱ��һ���ƶ�����
				a[j+1]=temp; //����
    	  }
     }
   //��� 
      public static void display(int[] a) {
           for(int i=0; i<a.length; i++)
       System.out.print(a[i]+" ");System.out.println( );//����
     }
}

