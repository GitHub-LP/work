package chap02;
//ģʽƥ�� ���ַ���ƥ�䣩
public class BruteForceMatch {
		public static void main(String[] args) {		
			        String s="There is more to life than increasing its speed";
			        String t="to";
			        int k=BFmatching(s,t); //���ú���������ƥ��
			        if(k!=-1)
			        	System.out.println("��λ��"+k+"ƥ��");
		}
		public static int BFmatching(String s,String t) {
			int i=0;//��ʼλ��
			int j=0;
			while(i<s.length()&&j<t.length()) //����������δ������
			if(s.charAt(i)==t.charAt(j)) {//����Ӧ�ַ�ƥ�䣬����
			      i++;
			      j++;
			} 
			else{                   //����ƥ�䣬���¿�ʼ
			    i=i-j+1;               //����
			    j=0;
			}
		if(j==t.length())
			return i;//�ɹ�������λ�
		else
			return -1;//ʧ��

		}
	}   
