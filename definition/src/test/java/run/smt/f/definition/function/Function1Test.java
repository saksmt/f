package run.smt.f.definition.function;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Function1Test {
    private Function1<Integer, Integer> plusOne = (i) -> i + 1;

    @Test
    public void testAndThenFunction() throws Exception {
        // (1 + 1) * 2
        assertEquals(4, plusOne.andThen((i) -> i * 2).apply(1).intValue());
    }

    @Test
    public void testAndThenProcedure() throws Exception {
        AtomicInteger a = new AtomicInteger(0);
        plusOne.andThen(a::set).apply(1);
        assertEquals(2, a.get());
    }

    @Test
    public void testCompose0() throws Exception {
        assertEquals(11, plusOne.compose(() -> 10).apply().intValue());
    }

    @Test
    public void testCompose1() throws Exception {
        // 1 + (1 * 2)
        assertEquals(3, plusOne.compose((Integer i) -> i * 2).apply(1).intValue());
    }

    @Test
    public void testCompose2() throws Exception {
        // (2 * 2) + 1
        assertEquals(5, plusOne.compose((Integer a, Integer b) -> a * b).apply(2, 2).intValue());
    }

    @Test
    public void testBind() throws Exception {
        assertEquals(3, plusOne.bind(2).apply().intValue());
    }

    @Test
    public void testExpand() throws Exception {
        assertEquals(2, plusOne.expand().apply(1, null).intValue());
        assertEquals(2, plusOne.expand().apply(1, 100).intValue());
        assertEquals(2, plusOne.expand().apply(1, 0).intValue());
    }

    @Test
    public void testSuppressReturn() throws Exception {
        AtomicInteger a = new AtomicInteger();
        ((Function1<Integer, Integer>) a::getAndSet).suppressReturn().apply(2);
        assertEquals(2, a.get());
    }
}