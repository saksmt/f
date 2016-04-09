package run.smt.f.definition.function;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Function2Test {
    private Function2<Integer, Integer, Integer> minus = (a, b) -> a - b;
    private Function2<Integer, Integer, Integer> plus = (a, b) -> a + b;
    private Function2<Integer, Integer, Integer> multiply = (a, b) -> a * b;

    @Test
    public void testComposeLeft() throws Exception {
        // (x * y) + y
        // (10 * 2) + 2
        assertEquals(22, plus.composeLeft(multiply).apply(10, 2).intValue());
    }

    @Test
    public void testComposeRight() throws Exception {
        // x + (x * y)
        // 10 + (10 * 2)
        assertEquals(30, plus.composeRight(multiply).apply(10, 2).intValue());
    }

    @Test
    public void testComposeF0andF0() throws Exception {
        assertEquals(7, plus.compose(() -> 4, () -> 3).apply().intValue());
    }

    @Test
    public void testComposeF0andF1() throws Exception {
        // (5) - (x * 2)
        // (5) - (7 * 2)
        assertEquals(-9, minus.compose(() -> 5, (Integer i) -> i * 2).apply(7).intValue());
    }

    @Test
    public void testComposeF1andF0() throws Exception {
        // (x * 2) - (5)
        // (7 * 2) - (5)
        assertEquals(9, minus.compose((Integer i) -> i * 2, () -> 5).apply(7).intValue());
    }

    @Test
    public void testComposeF1andF1() throws Exception {
        // (x * 2) - (y / 4)
        // (4 * 2) - (8 / 4)
        assertEquals(6, minus.compose((Integer i) -> i * 2, (Integer j) -> j / 4).apply(4, 8).intValue());
    }

    @Test
    public void testAndThenFunction() throws Exception {
        // 2 * (x + y)
        // 2 * (2 + 3)
        assertEquals(10, plus.andThen((i) -> i * 2).apply(2, 3).intValue());
    }

    @Test
    public void testAndThenProcedure() throws Exception {
        AtomicInteger i = new AtomicInteger();
        plus.andThen(i::set).apply(2, 4);
        assertEquals(6, i.get());
    }

    @Test
    public void testAndThenRightFunction() throws Exception {
        // x - (x * y)
        // 2 - (2 * 3)
        assertEquals(-4, multiply.andThenRight(minus).apply(2, 3).intValue());
    }

    @Test
    public void testAndThenRightProcedure() throws Exception {
        AtomicInteger a = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();
        // save(x), save(x - y)
        // save(2), save(2 - 3)
        minus.andThenRight((aa, bb) -> {
            a.set(aa);
            b.set(bb);
        }).apply(2, 3);
        assertEquals(2, a.get());
        assertEquals(-1, b.get());
    }

    @Test
    public void testAndThenLeftFunction() throws Exception {
        // (x * y) - y
        // (2 * 3) - 3
        assertEquals(3, multiply.andThenLeft(minus).apply(2, 3).intValue());
    }

    @Test
    public void testAndThenLeftProcedure() throws Exception {
        AtomicInteger a = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();
        // save(x - y), save(y)
        // save(2 - 3), save(3)
        minus.andThenLeft((aa, bb) -> {
            a.set(aa);
            b.set(bb);
        }).apply(2, 3);
        assertEquals(-1, a.get());
        assertEquals(3, b.get());
    }

    @Test
    public void testFlip() throws Exception {
        // x - y === -(x - y)
        assertEquals(
            -minus.apply(2, 3),
            minus.flip().apply(2, 3).intValue()
        );
    }

    @Test
    public void testBind() throws Exception {
        assertEquals(5, minus.bind(10).apply(5).intValue());
    }

    @Test
    public void testBindLast() throws Exception {
        assertEquals(-5, minus.bindLast(10).apply(5).intValue());
    }

    @Test
    public void testBind2() throws Exception {
        assertEquals(5, plus.bind(2, 3).apply().intValue());
    }

    @Test
    public void testSuppressReturn() throws Exception {
        AtomicInteger a = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();
        Function2<Integer, Integer, Integer> f = (aa, bb) -> {
            a.set(aa);
            b.set(bb);
            return aa;
        };
        f.suppressReturn().apply(10, 2);
        assertEquals(10, a.get());
        assertEquals(2, b.get());
    }
}