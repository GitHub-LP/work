package shopping;

public class Shopping {
   public static void main(String[] args) {
       //������Ʒ���󣬸����ָ�ֵ
    Product p1 = new Product();
    Product p2 = new Product(); 
    Product p3 = new Product();
    Product p4 = new Product();
    Product p5 = new Product();
    p1.setProName("���ӻ�");
    p2.setProName("ϴ�»�");
    p3.setProName("������");
    p4.setProName("�յ���");
    p5.setProName("�����");
    //�����������󣬸��������ָ�ֵ�����ֿ⸳ֵ
    Market m = new Market();
    m.setMarketName("���ָ�");
    m.getProductArr(new Product[]{p1,p2,p3,p4,p5});
   //���������ߣ��������ָ�ֵ
    Person p = new Person();
    p.setName("С��");
    //���ù��﷽���������к���Ʒ�����ù�����
    Product result = p.shopping(m,"������");
    //���ݽ�������ж�
    if (result != null){
    System.out.println(p.getName()+"��"
             +m.getMarketName()+"����"
             +result.getproName());
    }else{ 
    	 System.out.println(p.getName()+"��"
                 +m.getMarketName()+"ʲô��û��");
    }        
   }
}

