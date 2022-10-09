package chap02;
public class Jioujhpx {
	public static void main(String[] args) {
		int[] a = {1,3,5,7,9,2,4,6,8,10};
		boolean oddSort=true;
		boolean evenSort=true; 
		while(oddSort||evenSort) 
		{					
			oddSort =evenSort=false;					
			for(int i=0;i<a.length-1;i+=2) 
			{
				if(a[i]>a[i+1]) 
				{
					int change=a[i];
					a[i]=a[i+1];
					a[i+1]=change;
					evenSort=true;
				} 
			}					
			for(int i=1;i<a.length-1;i+=2) 
			{
				if(a[i]>a[i+1]) 
				{
					int change=a[i];
					a[i]= a[i+1];
					a[i+1]=change;
					oddSort=true;
				}
			}
		}
		for(int i=0;i<a.length;i++) 
		{
			System.out.print(a[i]+" ");
		}				
	}
}
