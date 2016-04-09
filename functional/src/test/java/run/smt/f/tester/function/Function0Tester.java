package run.smt.f.tester.function;

import run.smt.f.definition.function.Function0;

import static org.junit.Assert.assertEquals;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Function0Tester {
    private static final String TEST_DATA = Function0Tester.class.getCanonicalName();
    private int callCount = 0;
    private Function0<Object> testable = () -> { callCount++; return TEST_DATA; };

    public void assertCallCount(int count) {
        assertEquals(count, callCount);
    }

    public Function0<Object> getTestable() {
        return testable;
    }
}
