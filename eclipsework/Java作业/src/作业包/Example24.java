package ��ҵ��;

public class Example24 {
	public static void main(String[] args)  {
		int result = 0;
		try {
			result = divide(4,0);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(result);
	}
	public static int divide(int x,int y) throws Exception{
		int result =x/y;
		return result;
	}
	
}