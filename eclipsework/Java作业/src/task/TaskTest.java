package task;

public class TaskTest {

	public static void main(String[] args) {
	     //ʵ�������Զ���
		 Computer c = new Computer();
		 //������������ꡢ��˷硢�ͼ����豸
		 c.add(new Mouse());
		 c.add(new Mic());
		 c.add(new KeyBoard());
		 c.powerOn(); //��������
		 System.out.println();
		 c.powerOff(); //�رյ���
		}
	}
