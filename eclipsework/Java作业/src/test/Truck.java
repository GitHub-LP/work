package test;

public class Truck extends Car implements ICargoCapacity {    
	public Truck() {
    	 carName ="解放";
    	 carPrice = 1500;
   
	}
	@Override
	public double cargoCapacity() {
		// TODO 自动生成的方法存根
		int cargoCapacity = 25;
		return cargoCapacity;
	}
	 
	 public String toString(){
		   return super.toString()+"     载货量:"+cargoCapacity()+"吨。";
	
	 }

 
}
