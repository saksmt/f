package run.smt.f.functional;

import org.junit.Test;
import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

import static org.junit.Assert.*;
import static run.smt.f.functional.Cast.f;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class CastTest {

    @Test
    public void testFF0() throws Exception {
        assertTrue(Cast.f(() -> "") instanceof Function0);
    }

    @Test
    public void testFF1() throws Exception {
        assertTrue(Cast.f((a) -> a) instanceof Function1);
    }

    @Test
    public void testFF2() throws Exception {
        assertTrue(Cast.f((a, b) -> a) instanceof Function2);
    }

    @Test
    public void testFP0() throws Exception {
        assertTrue(Cast.f(() -> {}) instanceof Procedure0);
    }

    @Test
    public void testFP1() throws Exception {
        assertTrue(Cast.f((a) -> {}) instanceof Procedure1);
    }

    @Test
    public void testFP2() throws Exception {
        assertTrue(Cast.f((a, b) -> {}) instanceof Procedure2);
    }
}