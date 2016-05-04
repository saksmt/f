package run.smt.f.definition.predicate;

import run.smt.f.definition.function.Function2;

import java.util.function.*;

import static java.util.Objects.requireNonNull;

/**
 * Represents predicate with 2 arguments (function with 2 arguments and boolean return value)
 * and all logic operations (like logical OR, logical AND and so on)
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Predicate2<A, B> extends Function2<A, B, Boolean>, BiPredicate<A, B> {
    @Override
    default boolean test(A a, B b) {
        return apply(a, b);
    }

    @Override
    default Predicate2<A, B> negate() {
        return (a, b) -> !apply(a, b);
    }

    //region OR

    //region OR()

    default Predicate2<A, B> or(Supplier<Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.get();
    }

    default Predicate2<A, B> or(Predicate0 f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.apply();
    }

    //endregion

    //region OR(A)

    default Predicate2<A, B> or(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.apply(a);
    }

    default Predicate2<A, B> or(Predicate1<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.apply(a);
    }

    default Predicate2<A, B> or(Predicate<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.test(a);
    }

    //endregion

    //region OR(A, B)

    default Predicate2<A, B> or(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.apply(a, b);
    }

    default Predicate2<A, B> or(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.apply(a, b);
    }

    @Override
    default Predicate2<A, B> or(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) || f.test(a, b);
    }

    //endregion

    //endregion

    //region AND

    //region AND()

    default Predicate2<A, B> and(Supplier<Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.get();
    }

    default Predicate2<A, B> and(Predicate0 f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.apply();
    }

    //endregion

    //region AND(A)

    default Predicate2<A, B> and(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.apply(a);
    }

    default Predicate2<A, B> and(Predicate1<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.apply(a);
    }

    default Predicate2<A, B> and(Predicate<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.test(a);
    }

    //endregion

    //region AND(A, B)

    default Predicate2<A, B> and(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.apply(a, b);
    }

    default Predicate2<A, B> and(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.apply(a, b);
    }

    @Override
    default Predicate2<A, B> and(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) && f.test(a, b);
    }

    //endregion

    //endregion

    //region XOR

    //region XOR()

    default Predicate2<A, B> xor(Supplier<Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.get();
    }

    default Predicate2<A, B> xor(Predicate0 f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.apply();
    }

    //endregion

    //region XOR(A)

    default Predicate2<A, B> xor(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.apply(a);
    }

    default Predicate2<A, B> xor(Predicate1<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.apply(a);
    }

    default Predicate2<A, B> xor(Predicate<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.test(a);
    }

    //endregion

    //region XOR(A, B)

    default Predicate2<A, B> xor(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.apply(a, b);
    }

    default Predicate2<A, B> xor(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.apply(a, b);
    }

    default Predicate2<A, B> xor(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) ^ f.test(a, b);
    }

    //endregion

    //endregion

    //region IMPLIES

    //region IMPLIES()

    default Predicate2<A, B> implies(Supplier<Boolean> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.get();
    }

    default Predicate2<A, B> implies(Predicate0 f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.apply();
    }

    //endregion

    //region IMPLIES(A)

    default Predicate2<A, B> implies(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.apply(a);
    }

    default Predicate2<A, B> implies(Predicate1<? super A> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.apply(a);
    }

    default Predicate2<A, B> implies(Predicate<? super A> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.test(a);
    }

    //endregion

    //region IMPLIES(A, B)

    default Predicate2<A, B> implies(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.apply(a, b);
    }

    default Predicate2<A, B> implies(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.apply(a, b);
    }

    default Predicate2<A, B> implies(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a, b) || f.test(a, b);
    }

    //endregion

    //endregion

    //region EQUALITY

    //region EQUALITY()

    default Predicate2<A, B> equality(Supplier<Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.get();
    }

    default Predicate2<A, B> equality(Predicate0 f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.apply();
    }

    //endregion

    //region EQUALITY(A)

    default Predicate2<A, B> equality(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.apply(a);
    }

    default Predicate2<A, B> equality(Predicate1<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.apply(a);
    }

    default Predicate2<A, B> equality(Predicate<? super A> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.test(a);
    }

    //endregion

    //region EQUALITY(A, B)

    default Predicate2<A, B> equality(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.apply(a, b);
    }

    default Predicate2<A, B> equality(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.apply(a, b);
    }

    default Predicate2<A, B> equality(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a, b) == f.test(a, b);
    }

    //endregion

    //endregion
}
