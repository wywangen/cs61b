public class LinkedListDeque<stuff> {


    public class IntNode {
        public IntNode prev;
        public stuff item;
        public IntNode next;

        public IntNode(IntNode a,stuff b,IntNode c)
        {this.prev=a;this.item=b;this.next=c;}
    }

    private IntNode sentinel;
    private int size;

    //构造方法1
    public LinkedListDeque()
    {
        sentinel=new IntNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;
    }

    //构造方法2
    public LinkedListDeque(stuff x){
        size=1;
        IntNode p=new IntNode(null,x,null);
        sentinel=new IntNode(p,null,p);
        p.prev=sentinel;
        p.next=sentinel;

    }


    //在前端添加一个元素
    public void addFirst(stuff x){
        IntNode p=new IntNode(sentinel,x,sentinel.next);
        sentinel.next=p;
        p.next.prev=p;
        size+=1;
        }

     //在后端添加一个元素
     public void addLast(stuff x){
        IntNode p=new IntNode(sentinel.prev,x,sentinel);
        sentinel.prev=p;
        p.prev.next=p;
        size+=1;
     }
    //检查队列是否为空
    public boolean isEmpty(){
        if(size==0){return true;}
        else {return false;}
    }

    //返回队列的结点个数
    public int size(){
        return size;
    }

    //依次打印队列元素
    public void printDeque(){
       if(size==0){
           System.out.println("队列空");
       }
       if(size>0){
           IntNode p=sentinel.next;
           while(p!=sentinel) {System.out.print(p.item+" ");p=p.next;}
       }
    }

    //删去第一个元素
    public stuff removeFirst(){
        if(size==0){return null;}
        else {
            size-=1;
            stuff x=(stuff)sentinel.next.item;
            sentinel.next=sentinel.next.next;
            sentinel.next.prev=sentinel;
            return x;
            }
    }

//删去最后一个元素
    public stuff removeLast(){
        if(size==0){return null;}
        else {
            size-=1;
            stuff x=sentinel.prev.item;
            sentinel.prev=sentinel.prev.prev;
            sentinel.prev.next=sentinel;
            return x;
        }
    }
//用递归的方式得到第index+1个元素
 /*  这个方法用一个参数似乎不行
  public stuff get(int index){
        if(index>size-1){return null;}
        else
        {int i=0;IntNode p=sentinel.next;
            if(i==index) {return p.item;}
            else {return }
        }

    }
*/


    private stuff get_itration(IntNode p,int index)
    {
        if(index==0) {return p.item;}
        else return get_itration(p.next,index-1);


    }

    public stuff get(int index)
    {
        if(index>size-1){return null;}
        else return get_itration(sentinel.next,index);
    }




//用循环显示地index+1个元素，这里index=0表示第一个元素
    public stuff getRecursive(int index){
        if(index>size-1){return null;}
        else {int i=0;IntNode p=sentinel.next;
            while(i<index){p=p.next;i=i+1;}
           return p.item;}
    }


    }






