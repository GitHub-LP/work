package test;
import java.util.Scanner;

public class Task03 {
	
	public static void main(String[] args) {
		
		systemInitial();
	
	}	
	private static void systemInitial() {
		System.out.println("��ӭʹ���Զ��⳵ϵͳ��"+"\n"
	+"�⳵����������1���˳��밴�������");
		//��ȡ�û���������
		Scanner scanner =new Scanner(System.in);
		//���û������ֵ�����жϲ�ִ����Ӧ���߼�
		int input = scanner.nextInt();
		if (input==1){
			int count =1;
			System.out.println("   *******��ѡ����һ����*******");
			Car []cars = new Car[] {new PassageCar(),new Pickup(),new Truck()};
			for (Car carList : cars){
				System.out.println(count +"."+carList.toString());
				count++;
				
			}
			selectCar(cars);//��¼��ѡ����
			
		}
		
		System.out.println("�˳�ϵͳ��");
		scanner.close();
		System.exit(0);
	}  
	//��¼��ѡ����
	public static void selectCar(Car[] cars){
		
		System.out.println("***�����복�����ȷ���⳵����������'0'��ʾ����ѡ����"
		+"����'111'��ʾ�˳�ϵͳ����������20����***");
		Scanner scanner =new Scanner(System.in);
		int [] list =new int [20];
		int count = 0;
		while (true){
			int carNum =scanner.nextInt();
			if (carNum!=0) {
				if (carNum <= cars.length) {
					/*��������������<=�����б�ĳ��ȣ��ͽ�
					�û������������ӵ�list��*/
					list[count]=carNum;
					count++;
					if(count>=20) {
						break;
						
					}
					else if (carNum==111) {
						System.out.println("ȡ���⳵���˳�ϵͳ��");
						System.exit(0);
						
					}
					
				}
				
			}
			else {
				break;
			}
			
		}
		System.out.println("ѡ����ϣ������õĳ��������¼��***����"+
		count+"����***");
		int num =0;
		int passengerCapacity =0;//�ؿ���
		double cargoCapacity =0;//�ػ���
		int total =0;//�ܼ�
		int id;
		
		while (num <count) {//�����α�
			num ++;
			id=list[num-1];
			System.out.println(num+"."+cars[id-1].toString());
			passengerCapacity+=getPassengerCapacity(cars[id-1]);
			cargoCapacity+=getICargoCaoacity(cars[id-1]);
			total+=cars[id-1].getCarPrice();
			
	    }
		System.out.println("��ѡ�����ؿ�����Ϊ��"+passengerCapacity+"�ˡ�");
		System.out.println("��ѡ�����ػ�����Ϊ��"+cargoCapacity+"�֡�");
		System.out.println("��ѡ���������Ϊ��"+total+"Ԫ��");
		scanner.close();
		
		}
	//�ۼ��ػ���
	private static double getICargoCaoacity(Object object) {
		if (object instanceof ICargoCapacity) {
			double cargoCapacity =0;
			cargoCapacity+=((ICargoCapacity) object).cargoCapacity();
			return cargoCapacity;
			
		}
		else {
			return 0;
		}
		
	} 
	//�ۼ��ؿ���
	private static double getPassengerCapacity(Object object) {
		if (object instanceof IPassengerCapacity) {
			double passengerCapacity =0;
			passengerCapacity+=((IPassengerCapacity) object).passengerCapacity();
			return passengerCapacity;
			
		}
		else {
			return 0;
		}
		
	} 
	
}	

