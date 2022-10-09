package test;
/*
 *  所有Car的父类
 */
public class Car {
    protected String carName;//定义汽车的名字
    protected int carld;//定义汽车的序号
    protected double carPrice;//定义汽车的价格
    
    public String getName() {
		return carName;
	}
	public void setName(String carName) {
		this.carName = carName;
	}
	public int getCarld() {
		return carld;
	}
	public void setCarld(int carld) {
		this.carld = carld;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	 public String toString() {
		 return carName+"日租金"+carPrice+"元";
	}
	
}
