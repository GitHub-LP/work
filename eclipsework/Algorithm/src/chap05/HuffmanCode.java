package chap05;
/*
 * ̰���㷨��
 */
class HuffmanNode {   //�������������               
	int weight;   //����Ȩֵ
	int parent;
	int lChild;
	int rChild;
	String huffmanCode; //���������봮
	boolean flag;//����������������У����ý���Ѿ���ѡȡ��������Ϊtrue
}
	//ʵ�ֹ���������
public class HuffmanCode {
	static final int MAXVALUE=10000; //���� ���
	private int leafNum;	//Ҷ�Ӹ���
	HuffmanNode [] node;	//���飬�洢��������

	//���캯��
public HuffmanCode(int[] weight) {
	this.leafNum=weight.length;
	this.node=new HuffmanNode[leafNum*2-1]; //n��Ҷ�ӵĹ�����������2n-1�����(����������)
	
	int m1,m2,x1,x2;
	//��ʼ������(ֻ��n��Ҷ��)
	int n=leafNum;
	for(int i=0;i<2*n-1;i++) {
	  HuffmanNode temp=new HuffmanNode(); //����һ�����
	if(i<n)
	  temp.weight=weight[i]; //���� ǰn����Ԫ���Ҷ��
	else
	  temp.weight=0;	//����ĺ��浥Ԫ׼�������Ҷ��
	  temp.parent=-1;
	  temp.lChild=-1;
	  temp.rChild=-1;
	  temp.flag=false;
	  node[i]=temp; // ��i����㸳ֵ
     }
	
	//�����������
	for(int i=0;i<n-1; i++) { //��������n=1����Ҷ��
	//ѡȡ������С��Ȩֵ��㣬�ֱ����x1��x2
	m1=m2=MAXVALUE;
	x1=x2=0;
	for(int j=0;j<n+i;j++) {
	  if( node[j].weight<m1&&node[j].flag==false) {
	    m2=m1;
	    x2=x1;
	    m1=node[j].weight;
	    x1=j;  
      }else if(node[j].weight<m2&&node[j].flag==false) {
	    m2=node[j].weight;
	    x2=j;
  }
 }
	//����������С��Ȩֵ�������ϲ�Ϊһ��������
	node[n+i].weight=node[x1].weight+node[x2].weight; //����������ȨֵΪ�������ӽ��֮��
	node[n+i].lChild=x1;
	node[n+i].rChild=x2;
	node[x1].parent=n+i;
	node[x2].parent=n+i;
	node[x1].flag=true;  //���Ȩֵ��ѡȡ
	node[x2].flag=true;
  
 }
}

	//���ɹ���������
public void creatCode() {
	int n=leafNum;
	int me,parents,weight;
	
	//��n��Ҷ�ӵĹ���������
	for(int i=0;i<n;i++) {
	 node[i].huffmanCode="";	// ��ʼ��
	//ȡһ��Ҷ��
	weight=node[i].weight;
	me=i;
	parents=node[i].parent;
	
	//��Ҷ�ӿ�ʼ���򵽴�������·���ϵ�0��1��Ϊ���ַ��Ĺ���������
	while(parents!=-1) {
	  if(node[parents].lChild==me) //��֧ �ϱꡰ0��
	     node[i].huffmanCode=node[i].huffmanCode+"0";
	  else
	     node[i].huffmanCode=node[i].huffmanCode+"1"; //��֧ �ϱꡰ1��
	     me=parents;	//׼������˫������������
	     parents=node[me].parent;
  }
 }
}
	
	//���
public void display() {
	for(int i=0;i<leafNum;i++) //�� ��ÿ��Ҷ�ӵĹ���������
	 System.out.println("�ַ���Ȩֵ="+node[i].weight+"������Ϊ: "+node[i].huffmanCode);
	System.out.println();
	}
	
public static void main(String[] args) {
	int[] weights= {40,10,20,15,15}; //Ȩֵ����
	HuffmanCode h=new HuffmanCode(weights);
	h.creatCode();	//���ú������������������
	h.display();
 }
}