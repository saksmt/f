package run.smt.f.definition.predicate.javapredicate;

import org.junit.Assert;
import run.smt.f.definition.predicate.Predicate0;
import run.smt.f.definition.predicate.Predicate1;
import run.smt.f.definition.predicate.Predicate2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public abstract class PredicateJPTest {
    protected static final Predicate0 T0 = () -> true;
    protected static final Predicate0 F0 = () -> false;

    protected static final Predicate<Object> T1 = (a) -> true;
    protected static final Predicate<Object> F1 = (a) -> false;

    protected static final BiPredicate<Object, Object> T2 = (a, b) -> true;
    protected static final BiPredicate<Object, Object> F2 = (a, b) -> false;


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
