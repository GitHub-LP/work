package shopping;

public class Market { //����
    private String marketName;//������
    private Product[] productArr; //���еĲֿ⣬������������Ʒ
    public String getMarketName(){
   	 return marketName;
    }
    public void setMarketName(String marketName){
   	 this.marketName = marketName;
    }
    public Product[] getProductArr() {
   	 return productArr;
    }
    public void getProductArr(Product[] productArr) {
   	 this.productArr = productArr;
    }
    Product sell(String name) { //������ָ����Ʒ��
   	 for(int i=0; i<productArr.length; i++)
   		 if(productArr[i].getproName() == name)
   			 return productArr[i];
   	 return null;
    }
}
