package chap02;
//模式匹配 （字符串匹配）
public class BruteForceMatch {
		public static void main(String[] args) {		
			        String s="There is more to life than increasing its speed";
			        String t="to";
			        int k=BFmatching(s,t); //调用函数，进行匹配
			        if(k!=-1)
			        	System.out.println("在位置"+k+"匹配");
		}
		public static int BFmatching(String s,String t) {
			int i=0;//初始位置
			int j=0;
			while(i<s.length()&&j<t.length()) //当两个串均未处理完
			if(s.charAt(i)==t.charAt(j)) {//若对应字符匹配，继续
			      i++;
			      j++;
			} 
			else{                   //若不匹配，重新开始
			    i=i-j+1;               //回溯
			    j=0;
			}
		if(j==t.length())
			return i;//成功，返回位詈
		else
			return -1;//失败

		}
	}   
