package run.smt.f.definition.predicate;

import run.smt.f.definition.function.Function0;

/**
 * Represents predicate with no arguments (function with no arguments and boolean return value)
 * and all logic operations (like logical OR, logical AND and so on)
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Predicate0 extends Function0<Boolean> {
    default Predicate0 negate() {
        return () -> !apply();
    }

    default Predicate0 or(Predicate0 f) {
        return () -> apply() || f.apply();
    }

    default <A> Predicate1<A> or(Predicate1<A> f) {
        return (a) -> apply() || f.apply(a);
    }

    default <A, B> Predicate2<A, B> or(Predicate2<A, B> f) {
        return (a, b) -> apply() || f.apply(a, b);
    }


    default Predicate0 and(Predicate0 f) {
        return () -> apply() && f.apply();
    }

    default <A> Predicate1<A> and(Predicate1<A> f) {
        return (a) -> apply() && f.apply(a);
    }

    default <A, B> Predicate2<A, B> and(Predicate2<A, B> f) {
        return (a, b) -> apply() && f.apply(a, b);
    }


    default Predicate0 xor(Predicate0 f) {
        return () -> apply() ^ f.apply();
    }

    default <A> Predicate1<A> xor(Predicate1<A> f) {
        return (a) -> apply() ^ f.apply(a);
    }

    default <A, B> Predicate2<A, B> xor(Predicate2<A, B> f) {
        return (a, b) -> apply() ^ f.apply(a, b);
    }


    default Predicate0 implies(Predicate0 f) {
        return () -> !apply() || f.apply();
    }

    default <A> Predicate1<A> implies(Predicate1<A> f) {
        return (a) -> !apply() || f.apply(a);
    }

    default <A, B> Predicate2<A, B> implies(Predicate2<A, B> f) {
        return (a, b) -> !apply() || f.apply(a, b);
    }


    default Predicate0 equality(Predicate0 f) {
        return () -> apply() == f.apply();
    }

    default <A> Predicate1<A> equality(Predicate1<A> f) {
        return (a) -> apply() == f.apply(a);
    }

    default <A, B> Predicate2<A, B> equality(Predicate2<A, B> f) {
        return (a, b) -> apply() == f.apply(a, b);
    }
}
