
public class LinkedListDeque<T> implements Deque<T>{
    private class IntNode {
        public T item;
        public IntNode next,prev;

        public IntNode(){
            item=null;
            next=null;
            prev=null;

        }
        public IntNode(T i,IntNode pre,IntNode nxt){
            item=i;
            prev=pre;
            next=nxt;
        }
    }

    private IntNode sentFront,sentBack;
    private int size;

    public LinkedListDeque(){
        size=0;
        sentFront=new IntNode();
        sentBack=new IntNode();
        sentFront.next=sentBack;
        sentBack.prev=sentFront;
    }
    
    @Override
    public void addFirst(T x){
        IntNode now = new IntNode(x,sentFront,sentFront.next);
        sentFront.next.prev=now;
        sentFront.next=now;
        size++;
    }

    @Override
    public void addLast(T x){
        IntNode now = new IntNode(x,sentBack.prev,sentBack);
        sentBack.prev.next=now;
        sentBack.prev=now;
        size++;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public void printDeque(){
        IntNode x=sentFront.next;
        while(x!=sentBack){
            System.out.print(x.item+" ");
            x=x.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst(){
        if(sentFront.next==sentBack)
            return null;
        T now=sentFront.next.item;
        sentFront.next=sentFront.next.next; 
        sentFront.next.prev=sentFront;
        size--;
        return now;
    }

    @Override
    public T removeLast(){
        if(sentFront.next==sentBack)
            return null;
        T now=sentBack.prev.item;
        sentBack.prev=sentBack.prev.prev;
        sentBack.prev.next=sentBack;
        size--;
        return now;
    }

    @Override
    public T get(int index){
        if(index<0 || index>=size)
            return null;
        IntNode now=sentFront;
        for(int i=0;i<=index;i++)
            now=now.next;
        return now.item;
    }

}
