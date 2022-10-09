package chap03;
public class BinarySearch {
	 public static void main(String[] args) {
         int[] a= {1,5,3,2,8,6,9,7,0,4};
         int key =4;
         insertSort(a);//调用函数，排序
         System.out.println("排序后的数据为:");
         display(a);//输出列表
         System.out.print("查找的数据为:"+key+",下标为:");
         System.out.println(binarySearch(a,key));
    }
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
	 
	 public static int binarySearch( int[] a,int key ) {
		 int low = 0 , high = a.length-1;//初始查找区间
		 while (low<=high) {
		 int mid = ( low+high )/2;//中间位置
		 if ( key == a[mid])
		    return mid; //成功，返回位置
		 else if ( key < a[mid] )
			 low = mid+1; //左半边继续查找
		 else
			 high = mid-1;	 //右半边继续查找
		 }
		 return -1;//失败
	 }
  //输出 
     public static void display(int[] a) {
          for(int i=0; i<a.length; i++)
      System.out.print(a[i]+" ");System.out.println( );//换行
     
    }
}

