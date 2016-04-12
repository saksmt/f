package run.smt.f.definition.function;

import org.junit.Test;
import run.smt.f.definition.procedure.Procedure0;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Function0Test {
    private Function0<Integer> f = () -> 1;

    @Test
    public void testAndThenFunction() throws Exception {
        assertEquals(2, f.andThen((i) -> i + 1).apply().intValue());
    }

    @Test
    public void testAndThenProcedure() throws Exception {
        AtomicInteger a = new AtomicInteger(1);
        f.andThen((i) -> { a.addAndGet(i); }).apply();
        assertEquals(2, a.get());
    }

    @Test
    public void testSuppressReturn() throws Exception {
        assertTrue(f.suppressReturn() instanceof Procedure0);
    }

    @Test
    public void testExpand() throws Exception {
        assertTrue(f.expand() instanceof Function1);
        assertEquals(1, f.expand().apply(null).intValue());
        assertEquals(1, f.expand().apply(10).intValue());
        assertEquals(1, f.expand().apply(0).intValue());
    }

    @Test
    public void testIdentity() {
        assertNull(Function0.identity().apply());
    }

    @Test
    public void testConstant() {
        Object constant = new Object();
        assertEquals(constant, Function0.constant(constant).apply());
    }
}