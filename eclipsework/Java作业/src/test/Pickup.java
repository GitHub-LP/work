package test;

public class Pickup extends Car implements IPassengerCapacity,ICargoCapacity{
   public Pickup(){
	   carName ="������";
	   carPrice =500.0;
	   
   }
   @Override
   public double cargoCapacity() {
   	// TODO �Զ����ɵķ������
   	 int cargoCapacity = 5;
   	   return cargoCapacity;
   }
   @Override
   public int passengerCapacity() {
   	// TODO �Զ����ɵķ������
   	 int passengerCapacity = 2;
   	   return passengerCapacity;
   }
   public String toString(){
	   return super.toString()+"     �ػ���:"+cargoCapacity()+"�֡�"
   +"    �ؿ���:"+passengerCapacity()+"�ˡ�";
	   
   }

   
}
