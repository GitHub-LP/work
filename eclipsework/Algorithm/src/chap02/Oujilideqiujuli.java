package chap02;

import java.awt.Point;

public class Oujilideqiujuli {//��ʼ��һ���������
    public static int[] initializationArray(int n){
        int[] result = new int[n];
        for(int i = 0;i < n;i++)
            result[i] = (int)(Math.random()*1000); //������������������1~1000֮�����
        return result;
        
    }
    
    //�������������ֵ
    public static int getArrayMax(int a[] , int first , int end){
        int max = a[first];
        for(int i = first;i < end;i++){
            if(max < a[i])
                max = a[i];
        }
        return max;
    }
    
    //������������Сֵ
    public static int getArrayMin(int a[] , int first , int end){
        int min = a[first];
        for(int i = first;i < end;i++){
            if(min > a[i])
                min = a[i];
        }
        return min;
    }
    
    //��������a[n]����������ֵ
    public static void swapArray(int a[] , int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    //���÷��η�������a[n]�ֳ�����,����a[n1]<m,a[n2]>m(����n1+n2 = n)
    public static int divideArray(int a[],int first,int end){
        int max = getArrayMax(a,first,end);
        int min = getArrayMin(a,first,end);
        double m = (max + min)/2.0;
        //System.out.println("���η������λ��m:"+m);
        int i = first , j = end-1;
        //int a1 = 0;
        for( ;i+1 <= j;){
            while(a[i] < m && i+1 <= j)
                i++; 
            while(a[j] > m && i+1 <= j)
                j--;
        //  a1++;
        //    System.out.println("��"+a1+"�˽���ʱa[i] = "+a[i]+" i = "+i+"  a[j] = "+a[j]+" j = "+j);
            swapArray(a,i,j);   //a[i]����m��ֵ��a[j]С��m��ֵ���н������������λ�ò���
        }
        //System.out.println("����󣬷��ص����jֵ�ǣ�"+(j));
        return j;
    }
    
    //���õݹ鷨�ϲ���̾���ֵ��������̾���ĵ�
    public static int[] getMinDistancePoint(int a[] , int result[],int n ,int first , int end) {
        
        if(end-first <= 1){   //�ݹ���ֹ����
             return result;
        }
 
        int j = divideArray(a,first,end);
        int minDistance = result[1] - result[0];  //��̾�������֮��ľ����С
        if(minDistance > getArrayMin(a,j,end)-getArrayMax(a,first,j))
        {
            result[0] = getArrayMax(a,first,j);   //��̾�����������ֵ��С�ĵ�
            result[1] = getArrayMin(a,j,end);   //��̾�����������ֵ��С�ĵ�
        } 
        int result_one[] = getMinDistancePoint(a,result,2,first,j);   //�ݹ�
        int minDistance_one = result_one[1] - result_one[0]; 
        int result_two[] = getMinDistancePoint(a,result,2,j,end);   //�ݹ�
        int minDistance_two = result_two[1] - result_two[0];
        if(minDistance > minDistance_one)
            result = result_one;
        if(minDistance > minDistance_two)
            result = result_two;
        return result;
    }
    public static void main(String[] args){
        int a[] = new int[10];
        int b[] = new int[2];
        b[0] = 0;
        b[1] = 100;
        a = initializationArray(15);
        String one_text = "";
        for(int i = 0;i < 15;i++){
            one_text += "ֱ�������Point["+i+"] = "+a[i]+"\n";
            //System.out.print("����a["+i+"] = "+a[i]+"\n");
        }
        int result[] = getMinDistancePoint(a,b,2,0,15);
        //System.out.println("result[0] = "+result[0]+"\n"+"result[1] = "+result[1]);
        one_text += "��̾����Ե�1��result[0] = "+result[0]+"\n"+"��̾����Ե�2��result[1] = "+result[1];
        System.out.print(one_text);
    }
}
