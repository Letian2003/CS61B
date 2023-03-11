
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class UnionTest {
    @Test
    public void Test1(){
        UnionFind a = new UnionFind(6);
        int[] correct = {-1,-1,-1,-1,-1,-1};
        assertArrayEquals(correct, a.parent);
        
        a.connect(1, 2);
        correct[1]=2; correct[2]=-2;
        assertArrayEquals(correct, a.parent);
        a.connect(1, 2);
        assertArrayEquals(correct, a.parent);
        a.connect(0, 0);
        assertArrayEquals(correct, a.parent);

        a.connect(2,3);
        correct[2]=-3; correct[3]=2;
        assertArrayEquals(correct, a.parent);
        a.connect(4,5);
        correct[4]=5; correct[5]=-2;
        assertArrayEquals(correct, a.parent);
        a.connect(5,0);
        correct[5]=-3; correct[0]=5;
        assertArrayEquals(correct, a.parent);
        a.connect(0,3);
        correct[5]=2; correct[2]=-6;
        assertArrayEquals(correct, a.parent);
    }
}
