package test;

public class PassageCar extends Car implements IPassengerCapacity{
     
	public PassageCar() {
    	 carName ="�ֶ���";
    	 carPrice = 1000;
   
	}

	@Override
	public int passengerCapacity() {
		// TODO �Զ����ɵķ������
		int passengerCapacity = 4;
		return passengerCapacity;
	} 
	 public String toString() {
		   return super.toString()+"     �ؿ���:"+passengerCapacity()+"�ˡ�";
		   
	   }

}
