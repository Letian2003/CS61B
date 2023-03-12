import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class BuiltinList {
    public static void main(String[] args){
        Set<Integer> s1 = Set.of(1,5,6);
        Set<Integer> s2 = Set.of(1,5,6);
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        Map<String,Integer> m = new TreeMap<>();
        String[] text = {"a","b","c","ab","ac","bc","b","c","b"};
        for(String s : text){
            int count = m.getOrDefault(s, 0);
            m.put(s,count+1);
        }
        System.out.println(m);
    }
}
