package run.smt.f.definition.predicate;

import run.smt.f.definition.function.Function2;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Predicate2<A, B> extends Function2<A, B, Boolean> {
    default Predicate2<A, B> negate() {
        return (a, b) -> !apply(a, b);
    }


    default Predicate2<A, B> or(Predicate0 f) {
        return (a, b) -> apply(a, b) || f.apply();
    }

    default Predicate2<A, B> or(Predicate1<A> f) {
        return (a, b) -> apply(a, b) || f.apply(a);
    }

    default Predicate2<A, B> or(Predicate2<A, B> f) {
        return (a, b) -> apply(a, b) || f.apply(a, b);
    }


    default Predicate2<A, B> and(Predicate0 f) {
        return (a, b) -> apply(a, b) && f.apply();
    }

    default Predicate2<A, B> and(Predicate1<A> f) {
        return (a, b) -> apply(a, b) && f.apply(a);
    }

    default Predicate2<A, B> and(Predicate2<A, B> f) {
        return (a, b) -> apply(a, b) && f.apply(a, b);
    }


    default Predicate2<A, B> xor(Predicate0 f) {
        return (a, b) -> apply(a, b) ^ f.apply();
    }

    default Predicate2<A, B> xor(Predicate1<A> f) {
        return (a, b) -> apply(a, b) ^ f.apply(a);
    }

    default Predicate2<A, B> xor(Predicate2<A, B> f) {
        return (a, b) -> apply(a, b) ^ f.apply(a, b);
    }


    default Predicate2<A, B> implies(Predicate0 f) {
        return (a, b) -> !apply(a, b) || f.apply();
    }

    default Predicate2<A, B> implies(Predicate1<A> f) {
        return (a, b) -> !apply(a, b) || f.apply(a);
    }

    default Predicate2<A, B> implies(Predicate2<A, B> f) {
        return (a, b) -> !apply(a, b) || f.apply(a, b);
    }


    default Predicate2<A, B> equality(Predicate0 f) {
        return (a, b) -> apply(a, b) == f.apply();
    }

    default Predicate2<A, B> equality(Predicate1<A> f) {
        return (a, b) -> apply(a, b) == f.apply(a);
    }

    default Predicate2<A, B> equality(Predicate2<A, B> f) {
        return (a, b) -> apply(a, b) == f.apply(a, b);
    }
}
