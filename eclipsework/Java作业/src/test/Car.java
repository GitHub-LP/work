package test;
/*
 *  ����Car�ĸ���
 */
public class Car {
    protected String carName;//��������������
    protected int carld;//�������������
    protected double carPrice;//���������ļ۸�
    
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
		 return carName+"�����"+carPrice+"Ԫ";
	}
	
}
