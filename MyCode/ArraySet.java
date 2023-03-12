public class ArraySet<T> {
    private T[] items;
    private int size;

    public ArraySet(){
        items = (T[]) new Object[100];
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean contains(T x){
        for(T i:items){
            if(i==x)
                return true;
        }
        return false;
    }

    public void add(T x){
        if(contains(x))
            return;
        items[size++]=x;
    }

    public static void main(String[] args){
        ArraySet<String> s = new ArraySet<>();
        s.add("bbc");
        s.add("bbca");
        s.add("aab");
        s.add("bbc");
        System.out.println(s.contains("aab"));
        System.out.println(s.contains("aac"));
        System.out.println(s.size());
    }
}
