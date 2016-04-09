package run.smt.f.tester.procedure;

import run.smt.f.definition.procedure.Procedure0;

import static org.junit.Assert.assertEquals;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public class Procedure0Tester {
    private int callCount = 0;
    private Procedure0 testable = () -> callCount++;

    public void assertCallCount(int count) {
        assertEquals(count, callCount);
    }

    public Procedure0 getTestable() {
        return testable;
    }
}
