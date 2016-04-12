package run.smt.f.definition.procedure;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Procedure0Test {
    private AtomicInteger i = new AtomicInteger();
    private Procedure0 increment = i::incrementAndGet;

    @Before
    public void setup() {
        i.set(0);
    }

    @Test
    public void testExpand() throws Exception {
        increment.expand().apply(null);
        assertEquals(1, i.get());
        increment.expand().apply(123);
        assertEquals(2, i.get());
    }

    @Test
    public void testProvideReturn() throws Exception {
        assertEquals(10, increment.provideReturn(10).apply().intValue());
        assertEquals(1, i.get());
    }

    @Test
    public void smokeIdentity() {
        Procedure0.identity().apply();
    }
}