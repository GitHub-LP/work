package chap02;

public class Mppx{
public static void main( String[]args){
      int[]array= {12,3,45,6,78,9,22,2};
      bubbleSort(array);//调用，实施冒泡排序
      display(array);
}
//输出
   public static void display(int a[]){
      for(int i=0;i<a.length;i++)
          System.out.print(a[i]+",");
       System.out.println();//换行
}
//冒泡排序
   public static void bubbleSort( int[]a){
	        int temp;
		   boolean flag=true; //初始
		   for(int i=1;i<a.length&&flag;i++){//对每一趟非序
		   boolean flag1=false;//假设已有序
		   for(int j=0; j<a.length-i; j++)
		   if( a[j]>a[j+1]){//相邻元素，若逆序，则交换
		     temp=a[j];
		     a[j]=a[j+1];
		     a[j+1]=temp;
		      flag1=true;//有交换，表示无序
		   }
	}
  }
}