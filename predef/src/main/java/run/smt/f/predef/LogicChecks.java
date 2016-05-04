package run.smt.f.predef;

import run.smt.f.definition.predicate.Predicate0;
import run.smt.f.definition.predicate.Predicate1;
import run.smt.f.definition.predicate.Predicate2;

/**
 * Contains boolean checks functional representation
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface LogicChecks {
    static <A, B> Predicate2<A, B> equal() {
        return (a, b) -> (a == b) || (a != null && a.equals(b));
    }

    static <A, B> Predicate2<A, B> notEqual() {
        return (a, b) -> !((a == b) || (a != null && a.equals(b)));
    }

    static <A extends Comparable, B extends Comparable> Predicate2<A, B> lessThan() {
        return (a, b) -> a.compareTo(b) < 0;
    }

    static <A extends Comparable, B extends Comparable> Predicate2<A, B> greaterThan() {
        return (a, b) -> a.compareTo(b) > 0;
    }

    static Predicate0 truth() {
        return () -> true;
    }

    static Predicate0 lie() {
        return () -> false;
    }

    static <A> Predicate1<A> equalTo(A arg) {
        return a -> (a == arg) || (a != null && a.equals(arg));
    }

    static <A> Predicate1<A> notEqualTo(A arg) {
        return a -> !((a == arg) || (a != null && a.equals(arg)));
    }

    static <A> Predicate1<A> isNull() {
        return a -> a == null;
    }

    static <A> Predicate1<A> isNotNull() {
        return a -> a != null;
    }

    static <A> Predicate1<A> isInstanceOf(Class clazz) {
        return a -> a != null && a.getClass().isAssignableFrom(clazz);
    }
}
