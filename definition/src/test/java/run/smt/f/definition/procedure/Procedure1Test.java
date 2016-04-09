package run.smt.f.definition.procedure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Procedure1Test {
    private AtomicInteger i = new AtomicInteger();
    private Procedure1<Integer> save = i::set;

    @Before
    public void setup() {
        i.set(0);
    }

    @Test
    public void testComposeF0() throws Exception {
        save.compose(() -> 10).apply();
        assertEquals(10, i.get());
    }

    @Test
    public void testComposeF1() throws Exception {
        save.compose((Integer a) -> a + 1).apply(2);
        assertEquals(3, i.get());
    }

    @Test
    public void testComposeF2() throws Exception {
        save.compose((Integer a, Integer b) -> a + b).apply(2, 3);
        assertEquals(5, i.get());
    }

    @Test
    public void testExpand() throws Exception {
        save.expand().apply(10, null);
        assertEquals(10, i.get());
        save.expand().apply(10, 123);
        assertEquals(10, i.get());
        save.expand().apply(10, 0);
        assertEquals(10, i.get());
    }

    @Test
    public void testBind() throws Exception {
        save.bind(10).apply();
        assertEquals(10, i.get());
    }

    @Test
    public void testProvideReturn() throws Exception {
        Assert.assertEquals(20, save.provideReturn(20).apply(10).intValue());
        assertEquals(10, i.get());
    }
}