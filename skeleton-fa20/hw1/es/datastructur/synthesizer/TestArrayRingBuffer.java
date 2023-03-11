package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(10);
        arb.enqueue(16);
        arb.enqueue(18);
        arb.enqueue(0);
        Integer x = arb.dequeue();
        assertEquals(x,(Integer)10);
        assertEquals(arb.fillCount(),3);
        x = arb.dequeue();
        assertEquals(x,(Integer)16);
        x = arb.dequeue();
        assertEquals(x,(Integer)18);
        assertEquals(arb.fillCount(),1);
        x = arb.dequeue();
        assertEquals(x,(Integer)0);
        assertEquals(arb.fillCount(),0);
        arb.enqueue(10);
        arb.enqueue(16);
        arb.enqueue(18);
        arb.enqueue(0);
        arb.enqueue(10);
        x = arb.dequeue();
        assertEquals(x,(Integer)10);
        assertEquals(arb.fillCount(),4);
        arb.enqueue(16);
        arb.enqueue(18);
        x = arb.dequeue();
        assertEquals(x,(Integer)16);
        arb.enqueue(0);
        assertEquals(arb.fillCount(),6);


        
    }
}
