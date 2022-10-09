package shopping;

public class Market { //超市
    private String marketName;//超市名
    private Product[] productArr; //超市的仓库，里面有若干商品
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
    Product sell(String name) { //卖货，指定商品名
   	 for(int i=0; i<productArr.length; i++)
   		 if(productArr[i].getproName() == name)
   			 return productArr[i];
   	 return null;
    }
}
