package run.smt.f.definition.predicate;

import run.smt.f.definition.function.Function1;

import java.util.function.*;

import static java.util.Objects.requireNonNull;

/**
 * Represents predicate with one argument (function with one argument and boolean return value)
 * and all logic operations (like logical OR, logical AND and so on)
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Predicate1<A> extends Function1<A, Boolean>, Predicate<A> {
    @Override
    default boolean test(A a) {
        return apply(a);
    }

    @Override
    default Predicate1<A> negate() {
        return a -> !apply(a);
    }

    //region OR

    //region OR()

    default Predicate1<A> or(Supplier<Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) || f.get();
    }

    default Predicate1<A> or(Predicate0 f) {
        requireNonNull(f);
        return a -> apply(a) || f.apply();
    }

    //endregion

    //region OR(A)

    default Predicate1<A> or(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) || f.apply(a);
    }

    default Predicate1<A> or(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) || f.apply(a);
    }

    @Override
    default Predicate1<A> or(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) || f.test(a);
    }

    //endregion

    //region OR(A, B)

    default <B> Predicate2<A, B> or(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) || f.apply(a, b);
    }

    default <B> Predicate2<A, B> or(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) || f.apply(a, b);
    }

    default <B> Predicate2<A, B> or(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) || f.test(a, b);
    }

    //endregion

    //endregion

    //region AND

    //region AND()

    default Predicate1<A> and(Supplier<Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) && f.get();
    }

    default Predicate1<A> and(Predicate0 f) {
        requireNonNull(f);
        return a -> apply(a) && f.apply();
    }

    //endregion

    //region AND(A)

    default Predicate1<A> and(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) && f.apply(a);
    }

    default Predicate1<A> and(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) && f.apply(a);
    }

    @Override
    default Predicate1<A> and(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) && f.test(a);
    }

    //endregion

    //region AND(A, B)

    default <B> Predicate2<A, B> and(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) && f.apply(a, b);
    }

    default <B> Predicate2<A, B> and(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) && f.apply(a, b);
    }

    default <B> Predicate2<A, B> and(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) && f.test(a, b);
    }

    //endregion

    //endregion

    //region XOR

    //region XOR()

    default Predicate1<A> xor(Supplier<Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) ^ f.get();
    }

    default Predicate1<A> xor(Predicate0 f) {
        requireNonNull(f);
        return a -> apply(a) ^ f.apply();
    }

    //endregion

    //region XOR(A)

    default Predicate1<A> xor(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) ^ f.apply(a);
    }

    default Predicate1<A> xor(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) ^ f.apply(a);
    }

    default Predicate1<A> xor(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) ^ f.test(a);
    }

    //endregion

    //region XOR(A, B)

    default <B> Predicate2<A, B> xor(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) ^ f.apply(a, b);
    }

    default <B> Predicate2<A, B> xor(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) ^ f.apply(a, b);
    }

    default <B> Predicate2<A, B> xor(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) ^ f.test(a, b);
    }

    //endregion

    //endregion

    //region IMPLIES

    //region IMPLIES()

    default Predicate1<A> implies(Supplier<Boolean> f) {
        requireNonNull(f);
        return a -> !apply(a) || f.get();
    }

    default Predicate1<A> implies(Predicate0 f) {
        requireNonNull(f);
        return a -> !apply(a) || f.apply();
    }

    //endregion

    //region IMPLIES(A)

    default Predicate1<A> implies(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> !apply(a) || f.apply(a);
    }

    default Predicate1<A> implies(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> !apply(a) || f.apply(a);
    }

    default Predicate1<A> implies(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> !apply(a) || f.test(a);
    }

    //endregion

    //region IMPLIES(A, B)

    default <B> Predicate2<A, B> implies(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a) || f.apply(a, b);
    }

    default <B> Predicate2<A, B> implies(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a) || f.apply(a, b);
    }

    default <B> Predicate2<A, B> implies(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> !apply(a) || f.test(a, b);
    }

    //endregion

    //endregion

    //region EQUALITY

    //region EQUALITY()

    default Predicate1<A> equality(Supplier<Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) == f.get();
    }

    default Predicate1<A> equality(Predicate0 f) {
        requireNonNull(f);
        return a -> apply(a) == f.apply();
    }

    //endregion

    //region EQUALITY(A)

    default Predicate1<A> equality(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply(a) == f.apply(a);
    }

    default Predicate1<A> equality(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) == f.apply(a);
    }

    default Predicate1<A> equality(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply(a) == f.test(a);
    }

    //endregion

    //region EQUALITY(A, B)

    default <B> Predicate2<A, B> equality(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) == f.apply(a, b);
    }

    default <B> Predicate2<A, B> equality(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) == f.apply(a, b);
    }

    default <B> Predicate2<A, B> equality(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply(a) == f.test(a, b);
    }

    //endregion

    //endregion
}
