import static org.junit.Assert.*;

import org.apache.commons.math3.distribution.IntegerDistribution;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void TestI(){
        StudentArrayDeque<Integer> d1=new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> d2 = new ArrayDequeSolution<Integer>();
        int len=0;
        String s="";
        while(true){
            int opt = StdRandom.uniform(0,11);
            Integer a1,a2;
            if(opt<3){
                Integer num = StdRandom.uniform(10);
                d1.addFirst(num);
                d2.addFirst(num);
                s+=(String)("addFirst("+num+")\n");
                len++;
            }
            else if(opt<6){
                Integer num = StdRandom.uniform(10);
                d1.addLast(num);
                d2.addLast(num);
                s+=(String)("addLast("+num+")\n");
                len++;
            }
            else if(opt<8){
                if(len==0) continue;
                a1=d1.removeFirst();
                a2=d2.removeFirst();
                s+="removeFirst()";
                assertEquals(s,a1,a2);
                s+="\n";
                len--;
            }
            else {
                if(len==0) continue;
                a1=d1.removeLast();
                a2=d2.removeLast();
                s+="removeLast()";
                assertEquals(s,a1,a2);
                s+="\n";
                len--;
            }

        }
    }

    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests(TestArrayDequeGold.class);
    }
}
