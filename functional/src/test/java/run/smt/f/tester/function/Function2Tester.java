package run.smt.f.tester.function;

import run.smt.f.definition.function.Function2;

import static org.junit.Assert.assertEquals;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Function2Tester {
    private Object saved1;
    private Object saved2;
    private Object previous1;
    private Object previous2;
    private Function2<Object, Object, Object> testable = (a, b) -> {
        if (saved1 != null) {
            previous1 = saved1;
            previous2 = saved2;
        }
        saved1 = a;
        saved2 = b;
        return saved1;
    };

    public void verifyCalls() {
        assertEquals(previous1, saved1);
        assertEquals(previous2, saved2);
    }

    public Function2<Object, Object, Object> getTestable() {
        return testable;
    }
}
