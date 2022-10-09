package test;

public class Pickup extends Car implements IPassengerCapacity,ICargoCapacity{
   public Pickup(){
	   carName ="纳瓦拉";
	   carPrice =500.0;
	   
   }
   @Override
   public double cargoCapacity() {
   	// TODO 自动生成的方法存根
   	 int cargoCapacity = 5;
   	   return cargoCapacity;
   }
   @Override
   public int passengerCapacity() {
   	// TODO 自动生成的方法存根
   	 int passengerCapacity = 2;
   	   return passengerCapacity;
   }
   public String toString(){
	   return super.toString()+"     载货量:"+cargoCapacity()+"吨。"
   +"    载客量:"+passengerCapacity()+"人。";
	   
   }

   
}
