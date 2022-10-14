package chap04;

public class DevideConquerRandom {
	public static int partition( char[] a, int left,int right ) {//����:��׼�������ѡ��
		int pos=(int)(Math.random()*(right-left)+left);//���ȡһ��λ��
		int pivot = a[pos];//���һ����Ϊ��׼
		      int i=left,j=right;
		      while (i<j){
		          while( i<j && a[j]>=pivot )
		                 j--;	//���Ҳ���һ��С����
		          while( i<j && a[i]<=pivot )
		                 i++;   //�������һ�������
		          if(i<j){
		          char temp=a[i];//���߽���
		          a[i]=a[j];
		          a[j]=temp;
		          }
		      }
		      a[pos]=a[i];//��󽫻�׼������i��
		      a[i]=(char) pivot;
		      return i; //���ػ�׼��λ��
    }
 public static void quickSort(char[] a,int left,int right) {    //��������
	 if( left<right){ 
		      int k=partition(a,left,right); //���ú���������һ��
		      quickSort(a , left,k-1);//��������������У��ݹ����
		      quickSort(a,k+1,right); //���ұ����������У��ݹ����
		      }
             }
 public static void display( char[] a) {
	 for( int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
	    System.out.println();
		 }
public static void main(String[] args) {
	char[] a= {'E','X','A','M','P','L','E'};
	quickSort(a,0,a.length-1);
    display(a);
    }
 }

