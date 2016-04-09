package run.smt.f.tester.procedure;

import run.smt.f.definition.procedure.Procedure2;

import static org.junit.Assert.assertEquals;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Procedure2Tester<A, B> {
    private A saved1;
    private B saved2;
    private A previous1;
    private B previous2;
    private Procedure2<A, B> testable = (a, b) -> {
        if (saved1 != null) {
            previous1 = saved1;
            previous2 = saved2;
        }
        saved1 = a;
        saved2 = b;
    };

    public void verifyCalls() {
        assertEquals(previous1, saved1);
        assertEquals(previous2, saved2);
    }

    public Procedure2<A, B> getTestable() {
        return testable;
    }
}
