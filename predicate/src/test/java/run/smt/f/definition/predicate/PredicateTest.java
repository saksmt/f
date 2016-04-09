package run.smt.f.definition.predicate;

import org.junit.Assert;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public abstract class PredicateTest {
    protected static final Predicate0 T0 = () -> true;
    protected static final Predicate0 F0 = () -> false;

    protected static final Predicate1<Object> T1 = (a) -> true;
    protected static final Predicate1<Object> F1 = (a) -> false;

    protected static final Predicate2<Object, Object> T2 = (a, b) -> true;
    protected static final Predicate2<Object, Object> F2 = (a, b) -> false;


    protected static Boolean call(Predicate0 f) {
        return f.apply();
    }

    protected static Boolean call(Predicate1<Object> f) {
        return f.apply(null);
    }

    protected static Boolean call(Predicate2<Object, Object> f) {
        return f.apply(null, null);
    }


    protected static void assertFalse(Predicate0 f) {
        Assert.assertFalse(call(f));
    }

    protected static void assertFalse(Predicate1<Object> f) {
        Assert.assertFalse(call(f));
    }

    protected static void assertFalse(Predicate2<Object, Object> f) {
        Assert.assertFalse(call(f));
    }


    protected static void assertTrue(Predicate0 f) {
        Assert.assertTrue(call(f));
    }

    protected static void assertTrue(Predicate1<Object> f) {
        Assert.assertTrue(call(f));
    }

    protected static void assertTrue(Predicate2<Object, Object> f) {
        Assert.assertTrue(call(f));
    }
}
