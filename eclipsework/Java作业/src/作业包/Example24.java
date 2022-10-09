package 作业包;

public class Example24 {
	public static void main(String[] args)  {
		int result = 0;
		try {
			result = divide(4,0);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(result);
	}
	public static int divide(int x,int y) throws Exception{
		int result =x/y;
		return result;
	}
	
}