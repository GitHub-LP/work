package test;

public class PassageCar extends Car implements IPassengerCapacity{
     
	public PassageCar() {
    	 carName ="沃尔沃";
    	 carPrice = 1000;
   
	}

	@Override
	public int passengerCapacity() {
		// TODO 自动生成的方法存根
		int passengerCapacity = 4;
		return passengerCapacity;
	} 
	 public String toString() {
		   return super.toString()+"     载客量:"+passengerCapacity()+"人。";
		   
	   }

}
