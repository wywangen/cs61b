import javax.management.ObjectName;

public class ArrayDeque<stuff> {
    public stuff[] item;
    public int size;
    public int first;
    public int last;

    public ArrayDeque(){
        this.item=(stuff[]) new Object[8];
        this.size=0;
        this.first=0;
        this.last=0;
    }

    private void resizing(int capacity){
        stuff[] a=(stuff []) new Object[capacity];
        if(first+size<=item.length)
        {System.arraycopy(item,first,a,0,size);}
        else{
            System.arraycopy(item,first,a,0,item.length-first);
            System.arraycopy(item,0,a,item.length-first,size+first-item.length );
        }
        this.item=a;
    }



    public void addFirst(stuff x){
        size+=1;
        if(size>item.length){
            resizing(2* size);
        }
            first=(first-1)%(item.length);
            item[first]=x;
    }


    public void addLast(stuff x)
    {
        size+=1;
        if(size>item.length){
            resizing(2* size);
        }
        last=(last+1)%(item.length);
        item[last]=x;
    }


    public boolean isEmpty()
    {
        if(size==0) {return true;}
        else return false;
    }

    public int size()
    {
        return  size;
    }


    public void printDeque(){
        for (int i = first; i <first+size ; i++) {
            System.out.println(item[i% item.length]+" ");
        }
    }



    public stuff removeFirst(){
        if(size==0) return null;
        else {
            stuff x=item[first];
            size=size-1;
            if((double)size< (double)item.length/4)
            {resizing(item.length/2);
            first=0;
            last=size-1;}
            else {first=(first+1)%item.length;}
            return x;
        }
    }


    public stuff removeLast(){
        if(size==0) return null;
        else {
            stuff x=item[last];
            size=size-1;
            if((double)size< (double)item.length/4)
            {resizing(item.length/2);
            first=0;
            last=size-1;}
            else{last=(last-1)%item.length;}
            return x;
        }
    }


    public stuff get(int index){
        return item[(first+index)% item.length];
    }



}
