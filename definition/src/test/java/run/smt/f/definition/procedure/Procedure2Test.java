package run.smt.f.definition.procedure;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Procedure2Test {
    private AtomicInteger a = new AtomicInteger();
    private AtomicInteger b = new AtomicInteger();
    private Procedure2<Integer, Integer> save = (aa, bb) -> {
        a.set(aa);
        b.set(bb);
    };

    @Before
    public void setup() {
        a.set(0);
        b.set(0);
    }

    @Test
    public void testCompose0and0() throws Exception {
        save.compose(() -> 10, () -> 2).apply();
        assertEquals(10, a.get());
        assertEquals(2, b.get());
    }

    @Test
    public void testCompose0and1() throws Exception {
        save.compose(() -> 1, (Integer i) -> i + 1).apply(1);
        assertEquals(1, a.get());
        assertEquals(2, b.get());
    }

    @Test
    public void testCompose1and0() throws Exception {
        save.compose((Integer i) -> i + 1, () -> 5).apply(1);
        assertEquals(2, a.get());
        assertEquals(5, b.get());
    }

    @Test
    public void testCompose1and1() throws Exception {
        save.compose((Integer i) -> i + 1, (Integer i) -> i * 2).apply(2, 3);
        assertEquals(3, a.get());
        assertEquals(6, b.get());
    }

    @Test
    public void testComposeRight() throws Exception {
        // save(x), save(x + y)
        // save(1), save(1 + 2)
        save.composeRight((Integer a, Integer b) -> a + b).apply(1, 2);
        assertEquals(1, a.get());
        assertEquals(3, b.get());
    }

    @Test
    public void testComposeLeft() throws Exception {
        // save(x + y), save(y)
        // save(1 + 2), save(2)
        save.composeLeft((Integer a, Integer b) -> a + b).apply(1, 2);
        assertEquals(3, a.get());
        assertEquals(2, b.get());
    }

    @Test
    public void testFlip() throws Exception {
        save.flip().apply(1, 2);
        assertEquals(2, a.get());
        assertEquals(1, b.get());
    }

    @Test
    public void testBind() throws Exception {
        save.bind(1).apply(2);
        assertEquals(1, a.get());
        assertEquals(2, b.get());
    }

    @Test
    public void testBindLast() throws Exception {
        save.bindLast(2).apply(1);
        assertEquals(1, a.get());
        assertEquals(2, b.get());
    }

    @Test
    public void testBindAll() throws Exception {
        save.bind(1, 2).apply();
        assertEquals(1, a.get());
        assertEquals(2, b.get());
    }

    @Test
    public void testProvideReturn() throws Exception {
        assertEquals(10, save.provideReturn(10).apply(1, 2).intValue());
        assertEquals(1, a.get());
        assertEquals(2, b.get());
    }
}