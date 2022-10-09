package chap03;
public class BinarySearch {
	 public static void main(String[] args) {
         int[] a= {1,5,3,2,8,6,9,7,0,4};
         int key =4;
         insertSort(a);//���ú���������
         System.out.println("����������Ϊ:");
         display(a);//����б�
         System.out.print("���ҵ�����Ϊ:"+key+",�±�Ϊ:");
         System.out.println(binarySearch(a,key));
    }
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
	 
	 public static int binarySearch( int[] a,int key ) {
		 int low = 0 , high = a.length-1;//��ʼ��������
		 while (low<=high) {
		 int mid = ( low+high )/2;//�м�λ��
		 if ( key == a[mid])
		    return mid; //�ɹ�������λ��
		 else if ( key < a[mid] )
			 low = mid+1; //���߼�������
		 else
			 high = mid-1;	 //�Ұ�߼�������
		 }
		 return -1;//ʧ��
	 }
  //��� 
     public static void display(int[] a) {
          for(int i=0; i<a.length; i++)
      System.out.print(a[i]+" ");System.out.println( );//����
     
    }
}

