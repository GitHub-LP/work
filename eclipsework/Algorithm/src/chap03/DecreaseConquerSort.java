package chap03;

public class DecreaseConquerSort {
      public static void main(String[] args) {
          int[] a= {1,5,3,2,8,6,9,7,0,4};
          insertSort(a);//调用函数，排序
          display(a);//输出列表
     }
    //插入排序     
      public static void insertSort(int[] a) {
    	//从第2个元素开始，依次插入到前面的有序序列中
    	  int j;
    	  for(int i=1;i<a.length;i++){ 
    		   int temp = a[i]; //暂存   
    		  for(j=i-1;j>=0&&temp>a[j];j--)//寻找插入位置
    			  a[j+1]=a[j];//一边寻找一边移动数据
				a[j+1]=temp; //插入
    	  }
     }
   //输出 
      public static void display(int[] a) {
           for(int i=0; i<a.length; i++)
       System.out.print(a[i]+" ");System.out.println( );//换行
     }
}

