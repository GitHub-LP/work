package shopping;

public class Person { //ÈË
	private String name; //ÈËÃû
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name =name;
	}
	Product shopping(Market market,String name){
		return market.sell(name);
	}
}
