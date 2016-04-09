package run.smt.f.tester.function;

import run.smt.f.definition.function.Function1;

import static org.junit.Assert.assertEquals;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Function1Tester {
    private Object saved;
    private Object previousCall;
    private Function1<Object, Object> testable = (a) -> {
        if (saved != null) {
            previousCall = saved;
        }
        saved = a;
        return saved;
    };

    public void verifyCalls() {
        assertEquals(previousCall, saved);
    }

    public Function1<Object, Object> getTestable() {
        return testable;
    }
}
