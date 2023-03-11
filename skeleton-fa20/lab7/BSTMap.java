public class BSTMap<K extends Comparable<K>,V> implements  Map61B<K,V>{
    private Node root;
    public class Node{
        K key;
        V value;
        Node left,right;
        int size;

        public Node(K k,V v){
            key=k;
            value =v;
            size=1;
            left=right=null;
        }
    }

    public BSTMap(){
    }

    public void clear(){
        clear(root);
    }

    private void clear(Node x){
        if(x.left!=null) clear(x.left);
        if(x.right!=null) clear(x.right);
        x.left=x.right=null;
    }

    public boolean containsKey(K key){
        return containsKey(root,key);
    }

    private boolean containsKey(Node x,K key){
        if(x==null)
            return false;
        if(key.equals(x.key))
            return true;
        if(key.compareTo(x.key)<0)
            return containsKey(x.left,key);
        return containsKey(x.right,key);
    }

    public V get(K key){
        return get(root,key);
    }

    private V get(Node x,K key){
        if(x==null)
            throw new IllegalArgumentException("get a null");
        if(key.equals(x.key))
            return x.value;
        if(key.compareTo(x.key)<0)
            return get(x.left,key);
        return get(x.right,key);
    }

    public int size(){
        return root.size;
    }
    public void put(K key, V value){
        put(root,key,value);
    }

    private void put (Node x,K key,V value){
        if(x==null){
            x=new Node(key,value);
        }
        else{
            if(key.equals(x.key))
                x.value=value;
            else{
                if(key.compareTo(x.key)<0){
                    if(x.left==null)
                        x.left=new Node(key,value);
                    else
                        put(x.left,key,value);
                }
                else{
                    if(x.right==null)
                        x.right=new Node(key,value);
                    else
                        put(x.right,key,value);
                }
            }
        }
    }

    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }
    public V remove(K key){
        throw new UnsupportedOperationException();
    }
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    public K iterator(){
        throw new UnsupportedOperationException();
    }
    
    public void printInOrder(){
        System.out.print("[");
        printInOrder(root);
        System.out.print("]");
    }

    private void printInOrder(Node x){
        if(x==null){
            return;
        }
        printInOrder(x.left); 
        System.out.print(x.key+":"+x.value+",");
        printInOrder(x.right);
    }
}
