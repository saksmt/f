package run.smt.f.tester.procedure;

import run.smt.f.definition.procedure.Procedure1;

import static org.junit.Assert.assertEquals;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Procedure1Tester<T> {
    private T saved;
    private T previousCall;
    private Procedure1<T> testable = (a) -> {
        if (saved != null) {
            previousCall = saved;
        }
        saved = a;
    };

    public void verifyCalls() {
        assertEquals(previousCall, saved);
    }

    public Procedure1<T> getTestable() {
        return testable;
    }
}
