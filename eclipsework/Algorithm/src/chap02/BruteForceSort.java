package chap02;

public class BruteForceSort{
public static void main( String[]args){
      int[]array= {12,3,45,6,78,9,22,2};
      selectSort(array);//调用，实施选择排序
      //bubbleSort(array);//调用，实施冒泡排序
      display(array);
}
//输出
   public static void display(int a[]){
      for(int i=0;i<a.length;i++)
          System.out.print(a[i]+",");
          System.out.println();//换行
}
//选择排序
   public static void selectSort(int[] a){
      for(int i=0;i<a.length-1;i++ ){    // n-1趟排序
       //在剩下序列中找最小数
       int min=i;
       for(int j=i+1;j<a.length;j++ )
             if (a[j]<a[min] )
                  min = j;
              //交换到剩下序列的首位
              int temp = a[i];
               a[i] = a[min];
               a[min] =temp;
       } 
    }
   
  public static void bubbleSort( int[]a){ //冒泡排序
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
