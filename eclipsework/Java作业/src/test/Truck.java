package test;

public class Truck extends Car implements ICargoCapacity {    
	public Truck() {
    	 carName ="���";
    	 carPrice = 1500;
   
	}
	@Override
	public double cargoCapacity() {
		// TODO �Զ����ɵķ������
		int cargoCapacity = 25;
		return cargoCapacity;
	}
	 
	 public String toString(){
		   return super.toString()+"     �ػ���:"+cargoCapacity()+"�֡�";
	
	 }

 
}
