package chap05;
/*
 * 贪心算法例
 */
class HuffmanNode {   //哈夫曼树结点类               
	int weight;   //结点的权值
	int parent;
	int lChild;
	int rChild;
	String huffmanCode; //哈夫曼编码串
	boolean flag;//构造哈夫曼树过程中，若该结点已经被选取过，则标记为true
}
	//实现哈夫曼编码
public class HuffmanCode {
	static final int MAXVALUE=10000; //无穷 大∞
	private int leafNum;	//叶子个数
	HuffmanNode [] node;	//数组，存储哈夫曼树

	//构造函数
public HuffmanCode(int[] weight) {
	this.leafNum=weight.length;
	this.node=new HuffmanNode[leafNum*2-1]; //n个叶子的哈夫曼树共有2n-1个结点(二叉树性质)
	
	int m1,m2,x1,x2;
	//初始化数组(只含n个叶子)
	int n=leafNum;
	for(int i=0;i<2*n-1;i++) {
	  HuffmanNode temp=new HuffmanNode(); //创建一个结点
	if(i<n)
	  temp.weight=weight[i]; //数组 前n个单元存放叶子
	else
	  temp.weight=0;	//数组的后面单元准备构造非叶子
	  temp.parent=-1;
	  temp.lChild=-1;
	  temp.rChild=-1;
	  temp.flag=false;
	  node[i]=temp; // 第i个结点赋值
     }
	
	//构造哈夫曼树
	for(int i=0;i<n-1; i++) { //构造它的n=1个非叶子
	//选取两个最小的权值结点，分别存入x1和x2
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
	//将这两个最小的权值的子树合并为一棵新子树
	node[n+i].weight=node[x1].weight+node[x2].weight; //新子树根的权值为两个孩子结点之和
	node[n+i].lChild=x1;
	node[n+i].rChild=x2;
	node[x1].parent=n+i;
	node[x2].parent=n+i;
	node[x1].flag=true;  //标记权值已选取
	node[x2].flag=true;
  
 }
}

	//生成哈夫曼编码
public void creatCode() {
	int n=leafNum;
	int me,parents,weight;
	
	//求n个叶子的哈夫曼编码
	for(int i=0;i<n;i++) {
	 node[i].huffmanCode="";	// 初始化
	//取一个叶子
	weight=node[i].weight;
	me=i;
	parents=node[i].parent;
	
	//从叶子开始逆向到达树根，路径上的0、1串为该字符的哈夫曼编码
	while(parents!=-1) {
	  if(node[parents].lChild==me) //左支 上标“0”
	     node[i].huffmanCode=node[i].huffmanCode+"0";
	  else
	     node[i].huffmanCode=node[i].huffmanCode+"1"; //右支 上标“1”
	     me=parents;	//准备沿着双亲链向上搜索
	     parents=node[me].parent;
  }
 }
}
	
	//输出
public void display() {
	for(int i=0;i<leafNum;i++) //输 出每个叶子的哈夫曼编码
	 System.out.println("字符的权值="+node[i].weight+"，编码为: "+node[i].huffmanCode);
	System.out.println();
	}
	
public static void main(String[] args) {
	int[] weights= {40,10,20,15,15}; //权值集合
	HuffmanCode h=new HuffmanCode(weights);
	h.creatCode();	//调用函数，构造哈夫曼编码
	h.display();
 }
}