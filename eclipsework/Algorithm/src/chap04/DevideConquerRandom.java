package chap04;

public class DevideConquerRandom {
	public static int partition( char[] a, int left,int right ) {//划分:基准采用随机选择
		int pos=(int)(Math.random()*(right-left)+left);//随机取一个位置
		int pivot = a[pos];//设第一个数为基准
		      int i=left,j=right;
		      while (i<j){
		          while( i<j && a[j]>=pivot )
		                 j--;	//从右查找一个小的数
		          while( i<j && a[i]<=pivot )
		                 i++;   //从左查找一个大的数
		          if(i<j){
		          char temp=a[i];//两者交换
		          a[i]=a[j];
		          a[j]=temp;
		          }
		      }
		      a[pos]=a[i];//最后将基准交换到i处
		      a[i]=(char) pivot;
		      return i; //返回基准的位置
    }
 public static void quickSort(char[] a,int left,int right) {    //快速排序
	 if( left<right){ 
		      int k=partition(a,left,right); //调用函数，划分一次
		      quickSort(a , left,k-1);//对左边子序列排列，递归调用
		      quickSort(a,k+1,right); //对右边子序列排列，递归调用
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


