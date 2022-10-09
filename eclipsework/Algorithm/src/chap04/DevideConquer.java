package chap04;
/*
 * ����
 */
public class DevideConquer {
    //����
    public static int partition(char r[], int i,int j){
    	char pivot=r[i];  //��׼
    	int k=i; //��ס��׼ԭ����λ��
    	while(i<j){
    		while(i<j&&r[j]>=pivot)  //���Ҳ���һ��С����
    			j--;
    		while(i<j&&r[i]<=pivot)  //�������һ�������
    			i++;
    		if(i<j){ //����
    			char temp=r[i];
    			r[i]=r[j];
    			r[j]=temp;
    		}
    	}
    	r[k]=r[i];  //����׼������������ȷλ��
    	r[i]=pivot;
    	return i;  //���ػ�׼��λ��
    }
    //��������
    public static void quickSort(char[] r, int low, int high){
    	if(low<high){
    		int k=partition(r,low,high);  //���ú���������һ��
    		quickSort(r,low,k-1); //��������������򣬵ݹ����
    		quickSort(r,k+1,high); //���ұ����������򣬵ݹ����
    	}
    }
    public static void main(String[] args){
    	char[] letter={'E','X','A','M','P','L','E'};
    	quickSort(letter,0,letter.length-1); //�������ã���������
    	for(int i=0;i<letter.length;i++)
    		System.out.print(letter[i]+" ");
    }
}