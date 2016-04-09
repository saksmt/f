package run.smt.f.definition.predicate;

import run.smt.f.definition.function.Function1;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Predicate1<A> extends Function1<A, Boolean> {
    default Predicate1<A> negate() {
        return (a) -> !apply(a);
    }


    default Predicate1<A> or(Predicate0 f) {
        return (a) -> apply(a) || f.apply();
    }

    default Predicate1<A> or(Predicate1<A> f) {
        return (a) -> apply(a) || f.apply(a);
    }

    default <B> Predicate2<A, B> or(Predicate2<A, B> f) {
        return (a, b) -> apply(a) || f.apply(a, b);
    }


    default Predicate1<A> and(Predicate0 f) {
        return (a) -> apply(a) && f.apply();
    }

    default Predicate1<A> and(Predicate1<A> f) {
        return (a) -> apply(a) && f.apply(a);
    }

    default <B> Predicate2<A, B> and(Predicate2<A, B> f) {
        return (a, b) -> apply(a) && f.apply(a, b);
    }


    default Predicate1<A> xor(Predicate0 f) {
        return (a) -> apply(a) ^ f.apply();
    }

    default Predicate1<A> xor(Predicate1<A> f) {
        return (a) -> apply(a) ^ f.apply(a);
    }

    default <B> Predicate2<A, B> xor(Predicate2<A, B> f) {
        return (a, b) -> apply(a) ^ f.apply(a, b);
    }


    default Predicate1<A> implies(Predicate0 f) {
        return (a) -> !apply(a) || f.apply();
    }

    default Predicate1<A> implies(Predicate1<A> f) {
        return (a) -> !apply(a) || f.apply(a);
    }

    default <B> Predicate2<A, B> implies(Predicate2<A, B> f) {
        return (a, b) -> !apply(a) || f.apply(a, b);
    }


    default Predicate1<A> equality(Predicate0 f) {
        return (a) -> apply(a) == f.apply();
    }

    default Predicate1<A> equality(Predicate1<A> f) {
        return (a) -> apply(a) == f.apply(a);
    }

    default <B> Predicate2<A, B> equality(Predicate2<A, B> f) {
        return (a, b) -> apply(a) == f.apply(a, b);
    }
}
