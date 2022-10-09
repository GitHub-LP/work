package chap04;
/*
 * 分治
 */
public class DevideConquer {
    //划分
    public static int partition(char r[], int i,int j){
    	char pivot=r[i];  //基准
    	int k=i; //记住基准原来的位置
    	while(i<j){
    		while(i<j&&r[j]>=pivot)  //从右查找一个小的数
    			j--;
    		while(i<j&&r[i]<=pivot)  //从左查找一个大的数
    			i++;
    		if(i<j){ //交换
    			char temp=r[i];
    			r[i]=r[j];
    			r[j]=temp;
    		}
    	}
    	r[k]=r[i];  //将基准交换到最后的正确位置
    	r[i]=pivot;
    	return i;  //返回基准的位置
    }
    //快速排序
    public static void quickSort(char[] r, int low, int high){
    	if(low<high){
    		int k=partition(r,low,high);  //调用函数，划分一次
    		quickSort(r,low,k-1); //对左边子序列排序，递归调用
    		quickSort(r,k+1,high); //对右边子序列排序，递归调用
    	}
    }
    public static void main(String[] args){
    	char[] letter={'E','X','A','M','P','L','E'};
    	quickSort(letter,0,letter.length-1); //函数调用，快速排序
    	for(int i=0;i<letter.length;i++)
    		System.out.print(letter[i]+" ");
    }
}