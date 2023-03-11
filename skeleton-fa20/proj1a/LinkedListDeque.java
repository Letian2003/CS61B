/* 
public class LinkedListDeque<T> {
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

    public void addFirst(T x){
        IntNode now = new IntNode(x,sentFront,sentFront.next);
        sentFront.next.prev=now;
        sentFront.next=now;
        size++;
    }

    public void addLast(T x){
        IntNode now = new IntNode(x,sentBack.prev,sentBack);
        sentBack.prev.next=now;
        sentBack.prev=now;
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void printDeque(){
        IntNode x=sentFront.next;
        while(x!=sentBack){
            System.out.print(x.item+" ");
            x=x.next;
        }
        System.out.println();
    }

    public void removeFirst(){
        if(sentFront.next==sentBack)
            return;
        sentFront.next=sentFront.next.next; 
        sentFront.next.prev=sentFront;
        size--;
    }

}

*/
